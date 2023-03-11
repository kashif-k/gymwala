package gymwala.service;

import gymwala.model.Balance;
import gymwala.repo.BalanceRepo;
import gymwala.repo.MBalanceRepo;
import gymwala.view.MemberBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceService {

    private final MBalanceRepo mBalanceRepo;
    private final BalanceRepo balanceRepo;

    @Autowired
    public BalanceService(MBalanceRepo mBalanceRepo, BalanceRepo balanceRepo) {
        this.mBalanceRepo = mBalanceRepo;
        this.balanceRepo = balanceRepo;
    }

    public List<MemberBalance> getAll(){
        return new ArrayList<>(mBalanceRepo.findAll());
    }

    public BigDecimal getBalance(long phone){
        var amount = mBalanceRepo.findByPhone(phone);
        if(amount.isPresent()) return amount.get().getAmount();
        return BigDecimal.ZERO;
    }

    public Balance balance(int memberId){
        return balanceRepo.findByMemberId(memberId).orElse(null);
    }

    public void setBalance(Balance balance){
        balanceRepo.save(balance);
    }

    public void updateBalance(Balance balance){
        balanceRepo.updateBalance(balance.getAmount(), balance.getMemberId());
    }

}
