package changha.web.repository.RecipeOfDrinks;

import changha.web.models.Boba;
import changha.web.models.RecipeOfDrinks;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RecipeOfDrinksRepository extends ListCrudRepository<RecipeOfDrinks,Integer> {
    @Query(value = "select * from recipeofdrinks where name = :name")
    Optional<Boba> findRecipeOfDrinksByName(String name);
}

