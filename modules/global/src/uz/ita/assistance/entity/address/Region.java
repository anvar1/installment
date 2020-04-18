package uz.ita.assistance.entity.address;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "ASSISTANCE_REGION")
@Entity(name = "assistance_Region")
public class Region extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 8469986665294391593L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 40)
    protected String name;

    @NotNull
    @Column(name = "NAME_UZ", nullable = false, unique = true, length = 40)
    protected String nameUz;

    @Column(name = "ORDER_")
    protected Integer order;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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