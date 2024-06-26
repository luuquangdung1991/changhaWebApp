package changha.web.models;

public enum TypeOfBoboQSyrup {
    PEACH("PEACH"), PASSION("PASSION"), MANGO("MANGO") , RASPBERRY("RASPBERRY"),
    LITCHI("LITCHI"), LIME("LIME"), CHERRY("CHERRY"), BLUEBERRY("BLUEBERRY"),
    STRAWBERRY("STRAWBERRY"), GREEN_APPLE("GREEN_APPLE"), HONEYDEW_MELON("HONEYDEW_MELON"), GUAVE("GUAVE");

    public final String label;
    private TypeOfBoboQSyrup(String label) {
        this.label = label;
    }
}
