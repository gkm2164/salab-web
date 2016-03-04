package kr.ac.kaist.salab.model.entity.types;

/**
 * Created by USER on 2016-03-04.
 */
public enum DegreeType {
    PROFESSOR("prof"),
    PHD("phd"),
    MS("ms"),
    EXTERNAL("external");

    private String value;

    DegreeType(String value) {
        this.value = value;
    }
}