package changha.web.webApp.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record packaging(
        @Id
        String name,
        @NotNull
        TypeOfPackaging typeOfPackaging,
        @Positive
        Integer numberPerPack,
        @Positive
        Double currentPriceInEuro,
        LocalDateTime lastUpdateTs,
        Double lastPrice
) {}
