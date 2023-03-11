package gymwala.repo;

import gymwala.model.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MemberRepo extends CrudRepository<Member, Integer> {
    Optional<Member> findByPhone(long phone);
    @Transactional
    @Modifying
    @Query("update Member m set m.name = ?1, m.address = ?2, m.photo = ?3, m.phone = ?4, m.weight = ?5 where m.id = ?6")
    void updateMember(String name, String address, String photo, long phone, String weight, int id);
}
