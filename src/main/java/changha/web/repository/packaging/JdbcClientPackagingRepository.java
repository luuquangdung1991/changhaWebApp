package changha.web.repository.packaging;

import changha.web.models.Boba;
import changha.web.models.Packaging;
import changha.web.models.TypeOfPackaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class JdbcClientPackagingRepository {
    private static final Logger log = LoggerFactory.getLogger(JdbcClientPackagingRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientPackagingRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public void create(Packaging packaging) {
        jdbcClient.sql("INSERT INTO packaging(id,name,type_of_packaging,number_per_pack,current_price_in_euro,last_update_ts,last_price_in_euro) values(?,?,?,?,?,?,?)")
        .params(List.of(packaging.id(), packaging.name(), packaging.typeOfPackaging().label, packaging.numberPerPack(), packaging.currentPriceInEuro(), packaging.lastUpdateTs(), packaging.lastPriceInEuro()))
        .update();
    }

    public int count() {
        return jdbcClient.sql("select * from packaging")
                .query()
                .listOfRows().size();
    }

    public void saveAll(List<Packaging> packagings) {
        packagings.stream().forEach(this::create);
    }

    public void deleteAll() {
        var updated = jdbcClient.sql("delete from packaging").params()
                .update();
        Assert.state(updated != 0, "Failed to delete packaging");
    }

    public List<Packaging> findAll() {
        return jdbcClient.sql("select * from packaging").params()
                .query(Packaging.class)
                .list();
    }
}
