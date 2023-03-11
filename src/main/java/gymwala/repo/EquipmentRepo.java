package gymwala.repo;

import gymwala.model.Equipment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {
    @Transactional
    @Modifying
    @Query("update Equipment e set e.name = ?1, e.quantity = ?2 where e.id = ?3")
    int updateEquipment(String name, int quantity, int id);

}
