package changha.web.repository.boba;

import changha.web.models.Boba;
import changha.web.models.Packaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class JdbcClientBobaRepository {
    private static final Logger log = LoggerFactory.getLogger(JdbcClientBobaRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientBobaRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public void create(Boba boba) {
        jdbcClient.sql("INSERT INTO boba(id,name,weight_in_grams,current_price_in_Euro,price_per_unit,last_update_ts,last_price_in_euro) values(?,?,?,?,?,?,?)")
        .params(List.of(boba.id(), boba.name(), boba.weightInGrams(), boba.currentPriceInEuro(), boba.pricePerUnit(), boba.lastUpdateTs(), boba.lastPriceInEuro()))
        .update();
    }

    public int count() {
        return jdbcClient.sql("select * from boba")
                .query()
                .listOfRows().size();
    }

    public void saveAll(List<Boba> bobas) {
        bobas.stream().forEach(this::create);
    }

    public void deleteAll() {
        try {
            var updated = jdbcClient.sql("delete from boba").params()
                    .update();
            Assert.state(updated != 0, "Failed to delete boba");
        } catch (Exception e) {
            log.error("Failed to delete boba", e);
        }
    }

    public List<Boba> findAll() {
        return jdbcClient.sql("select * from boba").params()
                .query(Boba.class)
                .list();
    }
}
