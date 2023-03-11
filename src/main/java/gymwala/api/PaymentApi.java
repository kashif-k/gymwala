package gymwala.api;

import gymwala.model.Balance;
import gymwala.model.Member;
import gymwala.model.Payment;
import gymwala.service.BalanceService;
import gymwala.service.PaymentService;
import gymwala.view.MemberPay;
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
@RequestMapping("/payment")
public class PaymentApi {

    private final PaymentService payService;
    private final BalanceService balanceService;
    private static final Logger logger = LoggerFactory.getLogger(PaymentApi.class);

    @Autowired
    public PaymentApi(PaymentService payService, BalanceService balanceService) {
        this.payService = payService;
        this.balanceService = balanceService;
    }



    @GetMapping("/list")
    @ResponseBody
    public List<MemberPay> getAll(){
        logger.info("PaymentApi.getAll was accessed");
        return payService.getAll();
    }

    @GetMapping("/list/{phone}")
    @ResponseBody
    public List<MemberPay> getPayOfMember(@PathVariable long phone){
        logger.info("PaymentApi.getPayOfMember was accessed with parameter=" + phone);
        return payService.getPayByMember(phone);
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public List<Payment> getPayMember(@PathVariable int id){
        logger.info("PaymentApi.getPayMember was accessed with parameter=" + id);
        return payService.getPayMember(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, String> addPayment(@RequestBody Map<String, String> payRequest){
        Member memberId = payService.findMember(Long.parseLong(payRequest.get("phone")));
        if(memberId == null)  return Collections.singletonMap("status", "failed");
        Payment payment = new Payment(memberId.getId(), new BigDecimal(payRequest.get("amount")), new Date(System.currentTimeMillis()));
        logger.info("PaymentApi.addPayment was accessed with parameter=" + payRequest);
        payService.addPay(payment);
        Balance balance = balanceService.balance(memberId.getId());
        if(balance != null){
            balance.setAmount(balance.getAmount().subtract(payment.getAmount()));
            balanceService.updateBalance(balance);
        }
        return Collections.singletonMap("status", "success");
    }

    @GetMapping("/total")
    @ResponseBody
    public Map<String, String> totalPayment(){
        logger.info("PaymentApi.totalPayment was accessed");
        return Collections.singletonMap("count", payService.totalPayment());
    }

}
