package changha.web.models;

public enum Unit {
    GRAMS("GRAMS"), MILLILITER("MILLILITER");

    public final String label;
    private Unit(String label) {
        this.label = label;
    }
}
