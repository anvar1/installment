package uz.ita.assistance.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum InsuredEventStatus implements EnumClass<String> {

    ACTIVE("ACTIVE"),
    COMPLETED("COMPLETED"),
    DENIED("DENIED");

    private String id;

    InsuredEventStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static InsuredEventStatus fromId(String id) {
        for (InsuredEventStatus at : InsuredEventStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}