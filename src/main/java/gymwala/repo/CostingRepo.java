package gymwala.repo;

import gymwala.model.Costing;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;

@Repository
public interface CostingRepo extends CrudRepository<Costing, Integer> {
    @Transactional
    @Modifying
    @Query("update Costing c set c.title = ?1, c.amount = ?2, c.date = ?3 where c.id = ?4")
    int updateCosting(String title, BigDecimal amount, Date date, int id);

    @Query("SELECT SUM(c.amount) FROM Costing c")
    BigDecimal totalCost();

}
