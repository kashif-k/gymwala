package gymwala.repo;

import gymwala.model.Traineeship;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface TraineeshipRepo extends CrudRepository<Traineeship, Integer> {
    @Transactional
    @Modifying
    @Query("update Traineeship t set t.trainerId = ?1, t.month = ?2, t.startDate = ?3 where t.memberId = ?4")
    void updateTraineeship(int trainerId, int month, Date startDate, int memberId);

    boolean existsByMemberId(int memberId);
}
