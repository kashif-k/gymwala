package gymwala.api;

import gymwala.model.*;
import gymwala.model.Package;
import gymwala.repo.PackageRepo;
import gymwala.service.BalanceService;
import gymwala.service.MemberService;
import gymwala.service.TrainerService;
import gymwala.view.MemberDetail;
import gymwala.view.MemberSubscription;
import gymwala.view.MemberTrainee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberApi {

    private final MemberService memberService;
    private final TrainerService trainerService;

    private final BalanceService balanceService;
    private final PackageRepo packageRepo;
    private static final Logger logger = LoggerFactory.getLogger(MemberApi.class);

    @Autowired
    public MemberApi(MemberService memberService, TrainerService trainerService, BalanceService balanceService, PackageRepo packageRepo) {
        this.memberService = memberService;
        this.trainerService = trainerService;
        this.balanceService = balanceService;
        this.packageRepo = packageRepo;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Member profile(@PathVariable int id){
        logger.info("MemberApi.profile was accessed with param="+id);
        return memberService.findById(id);
    }

    @GetMapping("/subs/{id}")
    @ResponseBody
    public MemberSubscription membership(@PathVariable int id){
        logger.info("MemberApi.membership was accessed with param="+id);
        return memberService.singleSub(id);
    }

    @GetMapping("/trainee/{id}")
    @ResponseBody
    public MemberTrainee traineeship(@PathVariable int id){
        logger.info("MemberApi.membership was accessed with param="+id);
        return memberService.singleTrainee(id);
    }

    @GetMapping("/detaillist")
    @ResponseBody
    public List<MemberDetail> memberDetailList(){
        logger.info("MemberApi.memberDetailList was accessed");
        return memberService.getAll();
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Member> memberList(){
        logger.info("MemberApi.memberList was accessed");
        return memberService.members();
    }

    @GetMapping("/count")
    @ResponseBody
    public Map<String, String> memberCount(){
        logger.info("MemberApi.memberCount was accessed");
        return Collections.singletonMap("count", "" + memberService.getCount());
    }

    @GetMapping("/subs")
    @ResponseBody
    public List<MemberSubscription> subscriptionList(){
        logger.info("MemberApi.subscriptionList was accessed");
        return memberService.getSub();
    }

    @GetMapping("/trainee")
    @ResponseBody
    public List<MemberTrainee> traineeList(){
        logger.info("MemberApi.traineeList was accessed");
        return memberService.getTrainee();
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, String> addMember(@RequestBody Member member){
        logger.info("MemberApi.addMember was accessed with parameter="+member.toString());
        memberService.addMember(member);
        return Collections.singletonMap("status", "success");
    }

    @PutMapping("/update")
    @ResponseBody
    public Map<String, String> updateMember(@RequestBody Member member){
        logger.info("MemberApi.updateMember was accessed with parameter="+member.toString());
        return Collections.singletonMap("status", memberService.updateMember(member));
    }

    @PostMapping("/subadd")
    @ResponseBody
    public Map<String, String> addSubscription(@RequestBody Map<String, String> params){
        Member member = memberService.findMember(Long.parseLong(params.get("phone")));
        BigDecimal amount = new BigDecimal(params.get("amount"));
        if(member == null) return Collections.singletonMap("status", "failed");
        memberService.addPay(new Payment(member.getId(), amount , new Date(System.currentTimeMillis())));
        Payment payment = memberService.findPayId(member.getId(), new Date(System.currentTimeMillis()));
        if(payment == null) return Collections.singletonMap("status", "failed");
        Package pkg = packageRepo.findByTypeAndDuration(params.get("subscription"), Integer.parseInt(params.get("month"))).get();
        if(pkg.getAmount().compareTo(amount) != 0){
            Balance balance = balanceService.balance(member.getId());
            if(balance == null){
                balanceService.setBalance(new Balance(member.getId(), pkg.getAmount().subtract(amount)));
            }else{
                balance.setAmount(balance.getAmount().add(pkg.getAmount().subtract(amount)));
                balanceService.updateBalance(balance);
            }
        }

        Membership membership = new Membership(member.getId(),
                pkg.getId(),
                new Date(System.currentTimeMillis()),
                payment.getId());
        if(memberService.subExist(membership.getMemberId())){
            logger.info("MemberApi.addSubscription#Exist was accessed with parameter="+ params);
            memberService.updateSubscription(membership);
        }else{
            logger.info("MemberApi.addSubscription#NotExist was accessed with parameter="+ params);
            memberService.addSubscription(membership);
        }
        return Collections.singletonMap("status", "success");
    }

    @PostMapping("/trnadd")
    @ResponseBody
    public Map<String, String> addTrainee(@RequestBody Map<String, String> params){
        System.out.println(params);
        Member member = memberService.findMember(Long.parseLong(params.get("phone")));
        if(member == null) return Collections.singletonMap("status", "failed");
        Trainer trainer = trainerService.getTrainer(Long.parseLong(params.get("trainerPhone")));
        if(trainer == null) return Collections.singletonMap("status", "failed");
        Traineeship traineeship = new Traineeship(
                member.getId(),
                trainer.getId(),
                Integer.parseInt(params.get("month")),
                new Date(System.currentTimeMillis())
        );

        if(memberService.traineeExist(traineeship.getMemberId())){
            logger.info("MemberApi.addTrainee#Exist was accessed with parameter="+ params);
            memberService.updateTraineeship(traineeship);
        }else{
            logger.info("MemberApi.addTrainee#NotExist was accessed with parameter="+ params);
            memberService.addTraineeship(traineeship);
        }
        return Collections.singletonMap("status", "success");
    }

    @GetMapping("/balance/{id}")
    @ResponseBody
    public Map<String, String> balance(@PathVariable int id){
        logger.info("MemberApi.balance was accessed with parameter="+id);
        Balance bal = balanceService.balance(id);
        return Collections.singletonMap("balance", (bal == null? "0.0" : bal.getAmount().toString()));
    }



}
