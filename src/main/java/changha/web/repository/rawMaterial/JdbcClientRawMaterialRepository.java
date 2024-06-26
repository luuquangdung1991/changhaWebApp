package changha.web.repository.rawMaterial;

import changha.web.models.Boba;
import changha.web.models.RawMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class JdbcClientRawMaterialRepository {
    private static final Logger log = LoggerFactory.getLogger(JdbcClientRawMaterialRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRawMaterialRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public void create(RawMaterial rawMaterial) {
        assert rawMaterial.massInMilliliters() != null;
        jdbcClient.sql("INSERT INTO rawmaterial(id,name,type_of_product,weight_in_grams,mass_in_milliliters,price_per_unit,current_price_in_euro,last_update_ts," +
                        "last_price_in_euro) values(?,?,?,?,?,?,?,?,?)")
        .params(List.of(rawMaterial.id(), rawMaterial.name(), rawMaterial.typeOfMaterial().label, rawMaterial.weightInGrams(), rawMaterial.massInMilliliters(),
                rawMaterial.pricePerUnit(), rawMaterial.currentPriceInEuro(), rawMaterial.lastUpdateTs(),rawMaterial.lastPriceInEuro()))
        .update();
    }

    public int count() {
        return jdbcClient.sql("select * from rawmaterial")
                .query()
                .listOfRows().size();
    }

    public void saveAll(List<RawMaterial> rawMaterials) {
        rawMaterials.stream().forEach(this::create);
    }

    public void deleteAll() {
        try {
            var updated = jdbcClient.sql("delete from rawmaterial").params()
                    .update();
            Assert.state(updated != 0, "Failed to delete rawmaterial");
        } catch (Exception e) {
            log.error("Failed to delete rawmaterial", e);
        }
    }

    public List<RawMaterial> findAll() {
        return jdbcClient.sql("select * from rawmaterial").params()
                .query(RawMaterial.class)
                .list();
    }

}
