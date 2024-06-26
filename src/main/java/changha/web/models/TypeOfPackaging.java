package changha.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TypeOfPackaging {
    @JsonProperty("CUP")
    CUP("CUP"),
    @JsonProperty("DRINKING_STRAW")
    DRINKING_STRAW("DRINKING_STRAW"),
    @JsonProperty("SEALING_FILM")
    SEALING_FILM("SEALING_FILM");
    public final String label;

    private TypeOfPackaging(String label) {
        this.label = label;
    }

}
