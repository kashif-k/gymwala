package gymwala.repo;

import gymwala.util.ReadOnlyRepository;
import gymwala.view.MemberTrainee;
import org.springframework.stereotype.Repository;

@Repository
public interface MTraineeRepo extends ReadOnlyRepository<MemberTrainee, Integer> {
}
