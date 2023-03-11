package gymwala.service;

import gymwala.model.Member;
import gymwala.model.Membership;
import gymwala.model.Payment;
import gymwala.model.Traineeship;
import gymwala.repo.*;
import gymwala.view.MemberDetail;
import gymwala.view.MemberSubscription;
import gymwala.view.MemberTrainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepo memberRepo;
    private final MembershipRepo membershipRepo;
    private final TraineeshipRepo traineeshipRepo;
    private final MSubRepo subRepo;
    private final MTraineeRepo traineeRepo;
    private final MDetailRepo mDetailRepo;

    private final PaymentRepo payRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo, MembershipRepo membershipRepo, TraineeshipRepo traineeshipRepo, MSubRepo subRepo, MTraineeRepo traineeRepo, MDetailRepo mDetailRepo, PaymentRepo payRepo) {
        this.memberRepo = memberRepo;
        this.membershipRepo = membershipRepo;
        this.traineeshipRepo = traineeshipRepo;
        this.subRepo = subRepo;
        this.traineeRepo = traineeRepo;
        this.mDetailRepo = mDetailRepo;
        this.payRepo = payRepo;
    }

    public List<MemberDetail> getAll(){
        return new ArrayList<>(mDetailRepo.findAll());
    }

    public List<Member> members(){
        return new ArrayList<>((Collection) memberRepo.findAll());
    }

    public void addMember(Member member){
        memberRepo.save(member);
    }

    public String updateMember(Member member){
        if(memberRepo.existsById(member.getId())){
            memberRepo.updateMember(member.getName(), member.getAddress(), member.getPhoto(), member.getPhone(), member.getWeight(), member.getId());
            return "success";
        }
        return "failed";
    }

    public void addSubscription(Membership membership){
        membershipRepo.save(membership);
    }

    public void updateSubscription(Membership membership){
        membershipRepo.updateMembership(membership.getPackageId(), membership.getStartDate(), membership.getPaymentId(), membership.getMemberId());
    }

    public void addTraineeship(Traineeship traineeship){
        traineeshipRepo.save(traineeship);
    }

    public void updateTraineeship(Traineeship traineeship){
        traineeshipRepo.updateTraineeship(traineeship.getTrainerId(), traineeship.getMonth(), traineeship.getStartDate(), traineeship.getMemberId());
    }

    public boolean subExist(int memberId){
        return membershipRepo.existsByMemberId(memberId);
    }

    public boolean traineeExist(int memberId){
        return traineeshipRepo.existsByMemberId(memberId);
    }

    public List<MemberSubscription> getSub(){
        return new ArrayList<>(subRepo.findAll());
    }

    public List<MemberTrainee> getTrainee(){
        return new ArrayList<>(traineeRepo.findAll());
    }

    public Member findMember(long phone){
        return memberRepo.findByPhone(phone).orElse(null);
    }

    public Member findById(int id){ return memberRepo.findById(id).orElse(null); }

    public Payment findPayId(int memberId, Date date){
        List<Payment> p =  payRepo.findByMemberIdAndDate(memberId, date);
        if(p.size() == 0) return null;
        return p.get(p.size() - 1);
    }

    public void addPay(Payment payment){
        payRepo.save(payment);
    }

    public long getCount(){
        return memberRepo.count();
    }

    public Date calcEndDate(Date date, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return new Date(calendar.getTimeInMillis());
    }

    public MemberSubscription singleSub(int id){
        Member m = memberRepo.findById(id).orElse(null);
        if(m == null) return null;
        return subRepo.findByPhone(m.getPhone()).orElse(null);
    }
    public MemberTrainee singleTrainee(int id){
        return traineeRepo.findById(id).orElse(null);
    }

    public List<MemberSubscription> subExpiry(){
        List<MemberSubscription> expiring = new ArrayList<>();

        return expiring;
    }

}
