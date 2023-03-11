package gymwala.repo;

import gymwala.model.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface PaymentRepo extends CrudRepository<Payment, Integer> {
    List<Payment> findByMemberId(int memberId);

    @Query("SELECT SUM(p.amount) FROM Payment p")
    BigDecimal totalPayment();

    List<Payment> findByMemberIdAndDate(int memberId, Date date);

}
