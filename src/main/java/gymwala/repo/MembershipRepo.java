package gymwala.repo;

import gymwala.model.Membership;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface MembershipRepo extends CrudRepository<Membership, Integer> {
    @Transactional
    @Modifying
    @Query("update Membership m set m.packageId = ?1, m.startDate = ?2, m.paymentId = ?3 where m.memberId = ?4")
    void updateMembership(int packageId, Date startDate, int paymentId, int memberId);

    boolean existsByMemberId(int memberId);
}
