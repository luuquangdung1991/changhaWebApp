package changha.web.models;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

public record RawMaterial(
        @Id
        Integer id,
        @NotBlank
        String name,
        @NotBlank
        TypeOfMaterial typeOfMaterial,
        @Positive
        Integer weightInGrams,
        @Nullable
        Integer massInMilliliters,
        @Positive
        Double pricePerUnit,
        @Positive
        Double currentPriceInEuro,
        String lastUpdateTs,
        Double lastPriceInEuro
) { }
