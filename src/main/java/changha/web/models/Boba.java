package changha.web.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Boba(
        @Id
        Integer id,
        @NotBlank
        String name,
        @Positive
        Integer weightInGrams,
        @Positive
        Double currentPriceInEuro,
        @Positive
        Double pricePerUnit,
        String lastUpdateTs,
        Double lastPriceInEuro
) {
}
