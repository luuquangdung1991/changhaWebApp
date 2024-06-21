package changha.web.webApp.models;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record recipeOfDrinks(
        @Id
        @NotEmpty
        String name,
        @NotEmpty
        Size size,
        @Nullable
        Integer sugar,
        @Nullable
        Integer fruitSyrup,
        @Nullable
        Integer coconutMilk,
        @Nullable
        Integer matcha,
        @Nullable
        Integer taro
) {
}
