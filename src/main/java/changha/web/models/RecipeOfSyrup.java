package changha.web.models;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public record RecipeOfSyrup(
        @Id
        Integer id,
        @NotBlank
        String name,
        @Nullable
        Integer sugarInGrams,
        @Nullable
        Integer gellingSugarInGrams,
        @Nullable
        Integer jamInGrams,
        @Nullable
        Integer cannedFruitInGrams,
        @Nullable
        Integer boboqSyrupInMilliliters,
        @Nullable
        Integer waterInMilliliters,
        @Nullable
        Integer totalAmount
) {
}
