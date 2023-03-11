package gymwala.repo;

import gymwala.util.ReadOnlyRepository;
import gymwala.view.MemberDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface MDetailRepo extends ReadOnlyRepository<MemberDetail, Integer> {
}
