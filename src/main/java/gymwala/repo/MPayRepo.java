package gymwala.repo;

import gymwala.util.ReadOnlyRepository;
import gymwala.view.MemberPay;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MPayRepo extends ReadOnlyRepository<MemberPay, Integer> {
    List<MemberPay> findByPhone(long phone);

    List<MemberPay> findByPhoneAndDate(long phone, Date date);

}
