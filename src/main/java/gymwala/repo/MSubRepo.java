package gymwala.repo;

import gymwala.util.ReadOnlyRepository;
import gymwala.view.MemberSubscription;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MSubRepo extends ReadOnlyRepository<MemberSubscription, Integer> {
    Optional<MemberSubscription> findByPhone(long phone);
}
