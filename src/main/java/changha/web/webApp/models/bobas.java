package changha.web.webApp.models;

import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record bobas(
        @Id
        String name,
        @Positive
        Integer weightInGrams,
        @Positive
        Double currentPriceInEuro,
        @Positive
        Double pricePerUnit,
        LocalDateTime lastUpdateTs,
        Double lastPriceInEuro
) {
}
