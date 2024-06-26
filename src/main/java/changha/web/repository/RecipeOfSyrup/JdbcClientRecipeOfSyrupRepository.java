package changha.web.repository.RecipeOfSyrup;

import changha.web.models.Boba;
import changha.web.models.RecipeOfSyrup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class JdbcClientRecipeOfSyrupRepository {
    private static final Logger log = LoggerFactory.getLogger(JdbcClientRecipeOfSyrupRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRecipeOfSyrupRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public void create(RecipeOfSyrup recipeOfSyrup) {

        assert recipeOfSyrup.sugarInGrams() != null;
        assert recipeOfSyrup.gellingSugarInGrams() != null;
        assert recipeOfSyrup.jamInGrams() != null;
        assert recipeOfSyrup.cannedFruitInGrams() != null;
        assert recipeOfSyrup.waterInMilliliters() != null;
        assert recipeOfSyrup.boboqSyrupInMilliliters() != null;
        assert recipeOfSyrup.totalAmount() != null;

        jdbcClient.sql("INSERT INTO recipeofsyrup(id,name,sugar_in_grams,gelling_sugar_in_grams,jam_in_grams,canned_fruit_in_grams," +
                        "boboq_syrup_in_milliliters,water_in_milliliters,total_amount) values(?,?,?,?,?,?,?,?,?)")
        .params(List.of(recipeOfSyrup.id(), recipeOfSyrup.name(), recipeOfSyrup.sugarInGrams(), recipeOfSyrup.gellingSugarInGrams(),
                recipeOfSyrup.jamInGrams(), recipeOfSyrup.cannedFruitInGrams(), recipeOfSyrup.boboqSyrupInMilliliters(),
                recipeOfSyrup.waterInMilliliters(), recipeOfSyrup.totalAmount()))
        .update();
    }

    public int count() {
        return jdbcClient.sql("select * from recipeofsyrup")
                .query()
                .listOfRows().size();
    }

    public void saveAll(List<RecipeOfSyrup> recipeOfSyrups) {
        recipeOfSyrups.stream().forEach(this::create);
    }

    public void deleteAll() {
        try {
            var updated = jdbcClient.sql("delete from recipeofsyrup").params()
                    .update();
            Assert.state(updated != 0, "Failed to delete recipe of syrup");
        } catch (Exception e) {
            log.error("Failed to delete recipe of syrup", e);
        }
    }
}
