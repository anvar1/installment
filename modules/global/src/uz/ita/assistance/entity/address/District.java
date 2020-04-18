package uz.ita.assistance.entity.address;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "ASSISTANCE_DISTRICT")
@Entity(name = "assistance_District")
public class District extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 2398783664126742402L;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 60)
    protected String name;

    @NotNull
    @Column(name = "NAME_UZ", nullable = false, length = 60)
    protected String nameUz;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REGION_ID")
    protected Region region;

    @Column(name = "ORDER_")
    protected Integer order;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getNameUz() {
        return nameUz;
    }

    public void setNameUz(String nameUz) {
        this.nameUz = nameUz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}