package changha.web.repository.rawMaterial;

import changha.web.models.Boba;
import changha.web.models.RawMaterial;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RawMaterialRepository extends ListCrudRepository<RawMaterial,Integer> {
    @Query(value = "select * from rawmaterial where name = :name")
    Optional<Boba> findRawMaterialByName(String name);
}

