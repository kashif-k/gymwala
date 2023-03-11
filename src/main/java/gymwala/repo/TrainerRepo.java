package gymwala.repo;

import gymwala.model.Trainer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TrainerRepo extends CrudRepository<Trainer, Integer> {
    @Transactional
    @Modifying
    @Query("update Trainer t set t.name = ?1, t.address = ?2, t.photo = ?3, t.phone = ?4, t.aadhaar = ?5 where t.id = ?6")
    int updateTrainer(String name, String address, String photo, long phone, long aadhaar, int id);

    Optional<Trainer> findByPhone(long phone);
}
