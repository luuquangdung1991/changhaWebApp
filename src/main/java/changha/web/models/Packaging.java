package changha.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

public record Packaging(
        @Id
        Integer id,
        @NotBlank
        String name,
        @NotNull
        TypeOfPackaging typeOfPackaging,
        @Positive
        Integer numberPerPack,
        @Positive
        Double currentPriceInEuro,
        String lastUpdateTs,
        Double lastPriceInEuro
) {}
