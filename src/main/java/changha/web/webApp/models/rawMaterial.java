package changha.web.webApp.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record rawMaterial(
        @Id @NotNull
        String name,
        @NotBlank
        TypeOfProduct typeOfProduct,
        @Positive
        Integer weightInGrams,
        @Positive
        Integer massInMilliliters,
        @Positive
        Double pricePerUnit,
        @Positive
        Double currentPriceInEuro,
        LocalDateTime lastUpdateTs,
        Double lastPriceInEuro
) {
}
