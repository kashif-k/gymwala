package gymwala.repo;

import gymwala.model.Balance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface BalanceRepo extends CrudRepository<Balance, Integer> {
    Optional<Balance> findByMemberId(int memberId);
    @Transactional
    @Modifying
    @Query("update Balance b set b.amount = ?1 where b.memberId = ?2")
    void updateBalance(BigDecimal amount, int memberId);
}
