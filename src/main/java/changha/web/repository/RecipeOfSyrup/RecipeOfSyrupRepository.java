package changha.web.repository.RecipeOfSyrup;

import changha.web.models.Boba;
import changha.web.models.RecipeOfSyrup;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RecipeOfSyrupRepository extends ListCrudRepository<RecipeOfSyrup,Integer> {
    @Query(value = "select * from recipeofsyrup where name = :name")
    Optional<Boba> findRecipeOfSyrupByName(String name);
}

