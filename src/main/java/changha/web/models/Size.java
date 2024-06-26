package changha.web.models;

public enum Size {
    BIG("BIG"),SMALL("SMALL");

    public final String label;
    private Size(String label) {
        this.label = label;
    }
}
