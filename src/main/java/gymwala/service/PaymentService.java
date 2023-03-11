package gymwala.service;

import gymwala.model.Member;
import gymwala.model.Payment;
import gymwala.repo.MPayRepo;
import gymwala.repo.MemberRepo;
import gymwala.repo.PaymentRepo;
import gymwala.view.MemberPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepo payRepo;
    private final MPayRepo mPayRepo;
    private final MemberRepo memberRepo;

    @Autowired
    public PaymentService(PaymentRepo payRepo, MPayRepo mPayRepo, MemberRepo memberRepo) {
        this.payRepo = payRepo;
        this.memberRepo = memberRepo;
        this.mPayRepo = mPayRepo;
    }

    public List<MemberPay> getAll(){
        return new ArrayList<>(mPayRepo.findAll());
    }

    public List<MemberPay> getPayByMember(long phone){
        return new ArrayList<>(mPayRepo.findByPhone(phone));
    }

    public List<Payment> getPayMember(int id){
        return payRepo.findByMemberId(id);
    }

    public void addPay(Payment payment){
        payRepo.save(payment);
    }

    public Member findMember(long phone){
        return memberRepo.findByPhone(phone).orElse(null);
    }

    public String totalPayment(){
        return payRepo.totalPayment().toString();
    }


}
