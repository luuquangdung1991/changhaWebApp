package changha.web.repository.RecipeOfDrinks;

import changha.web.models.Boba;
import changha.web.models.TypeOfDrinks;
import changha.web.models.RecipeOfDrinks;
import changha.web.models.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class JdbcClientRecipeOfDrinksRepository {
    private static final Logger log = LoggerFactory.getLogger(JdbcClientRecipeOfDrinksRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRecipeOfDrinksRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public void create(RecipeOfDrinks recipeOfDrinks) {
        assert recipeOfDrinks.fruitSyrup() != null;
        assert recipeOfDrinks.coconutMilk() != null;
        assert recipeOfDrinks.matcha() != null;
        assert recipeOfDrinks.taro() != null;
        assert recipeOfDrinks.sugar() != null;
        assert recipeOfDrinks.powderMilk() != null;

        jdbcClient.sql("INSERT INTO recipeofdrinks(id,name,size,type_of_drinks,sugar,fruit_syrup,powder_milk,coconut_milk,matcha,taro) values(?,?,?,?,?,?,?,?,?,?)")
        .params(List.of(recipeOfDrinks.id(), recipeOfDrinks.name(), recipeOfDrinks.size().label, recipeOfDrinks.typeOfDrinks().label, recipeOfDrinks.sugar(),
                recipeOfDrinks.fruitSyrup(), recipeOfDrinks.powderMilk(), recipeOfDrinks.coconutMilk(), recipeOfDrinks.matcha(), recipeOfDrinks.taro()))
        .update();
    }

    public int count() {
        return jdbcClient.sql("select * from recipeofdrinks")
                .query()
                .listOfRows().size();
    }

    public void saveAll(List<RecipeOfDrinks> recipeOfDrinks) {
        recipeOfDrinks.stream().forEach(this::create);
    }

    public void deleteAll() {
        try {
            var updated = jdbcClient.sql("delete from recipeofdrinks").params()
                    .update();
            Assert.state(updated != 0, "Failed to delete recipe of drinks");
        } catch (Exception e) {
            log.error("Failed to delete recipe of drinks", e);
        }
    }

}
