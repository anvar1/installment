package uz.ita.assistance.entity.address;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "ASSISTANCE_COUNTRY")
@Entity(name = "assistance_Country")
public class Country extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 1688958827789723164L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 80)
    protected String name;

    @Column(name = "NAME_FULL", length = 80)
    protected String nameFull;

    @NotNull
    @Column(name = "NAME_EN", nullable = false, unique = true, length = 80)
    protected String nameEn;

    @NotNull
    @Column(name = "ALPHA2", nullable = false, unique = true, length = 2)
    protected String alpha2;

    @NotNull
    @Column(name = "ALPHA3", nullable = false, unique = true, length = 3)
    protected String alpha3;

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}