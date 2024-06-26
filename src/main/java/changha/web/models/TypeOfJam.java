package changha.web.models;

public enum TypeOfJam {
    RASPBERRY("RASPBERRY"), CHERRY("CHERRY"), BLUEBERRY("BLUEBERRY"), STRAWBERRY("STRAWBERRY");

    public final String label;
    private TypeOfJam(String label) {
        this.label = label;
    }
}
