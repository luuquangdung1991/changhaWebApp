package changha.web.models;

public enum TypeOfDrinks {
    ICE_TEA("ICE_TEA"), SODA("SODA"), CLASSIC_MILK_TEA("CLASSIC_MILK_TEA"),
    FRUIT_MILK_TEA("FRUIT_MILK_TEA"), COFFEE("COFFEE");

    public final String label;
    private TypeOfDrinks(String label) {
        this.label = label;
    }
}
