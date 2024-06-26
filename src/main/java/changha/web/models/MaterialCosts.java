package changha.web.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record MaterialCosts(
        @NotBlank
        String name,
        @NotBlank
        TypeOfMaterial typeOfMaterial,
        @Positive
        Double costPerUnit,
        @NotBlank
        Unit unit
) {
}
