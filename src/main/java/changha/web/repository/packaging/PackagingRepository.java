package changha.web.repository.packaging;

import changha.web.models.Boba;
import changha.web.models.Packaging;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface PackagingRepository extends ListCrudRepository<Packaging,Integer> {
    @Query(value = "select * from packaging where name = :name")
    Optional<Boba> findPackagingByName(String name);
}

