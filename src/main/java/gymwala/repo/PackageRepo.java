package gymwala.repo;

import gymwala.model.Package;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackageRepo extends CrudRepository<Package, Integer> {
    Optional<Package> findByTypeAndDuration(String type, int duration);
}
