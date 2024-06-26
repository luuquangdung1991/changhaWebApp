package changha.web.models;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

public record RecipeOfDrinks(
        @Id
        Integer id,
        @NotBlank
        String name,
        @NotEmpty
        Size size,
        @NotEmpty
        TypeOfDrinks typeOfDrinks,
        @Nullable
        Integer sugar,
        @Nullable
        Integer fruitSyrup,
        @Nullable
        Integer powderMilk,
        @Nullable
        Integer coconutMilk,
        @Nullable
        Integer matcha,
        @Nullable
        Integer taro
) {
}
