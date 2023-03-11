package gymwala.repo;

import gymwala.util.ReadOnlyRepository;
import gymwala.view.MemberBalance;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MBalanceRepo extends ReadOnlyRepository<MemberBalance, Integer> {
    Optional<MemberBalance> findByPhone(long phone);
}
