package gymwala.repo;

import gymwala.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Integer> {
    boolean existsByUsernameAndPassword(String username, String password);
}
