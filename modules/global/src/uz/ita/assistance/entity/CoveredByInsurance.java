package uz.ita.assistance.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CoveredByInsurance implements EnumClass<String> {

    COVERED("COVERED"),
    NOT_COVERED("NOT_COVERED");

    private String id;

    CoveredByInsurance(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CoveredByInsurance fromId(String id) {
        for (CoveredByInsurance at : CoveredByInsurance.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}