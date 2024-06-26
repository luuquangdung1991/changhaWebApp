package changha.web.repository.boba;

import changha.web.models.Boba;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface BobaRepository extends ListCrudRepository<Boba,Integer> {
    @Query(value = "select * from boba where name = :name")
    Optional<Boba> findBobaByName(String name);
}

