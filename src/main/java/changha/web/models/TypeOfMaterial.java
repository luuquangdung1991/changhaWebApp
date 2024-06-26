package changha.web.models;

public enum TypeOfMaterial {
    POWDER("POWDER"), JAM("JAM"), BOBOQ_SYRUP("BOBOQ_SYRUP"),
    CANNED_FRUIT("CANNED_FRUIT"), SUGAR("SUGAR"), WATER("WATER"),
    PACKAGING("PACKAGING");
    public final String label;

    private TypeOfMaterial(String label) {
        this.label = label;
    }
}
