package changha.web.webApp.models;

import jakarta.annotation.Nullable;
import org.springframework.data.annotation.Id;

public record recipeOfSyrup(
        @Id
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
        Integer waterInMilliliters
) {
}
