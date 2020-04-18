package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|code")
@Table(name = "ASSISTANCE_PRODUCT")
@Entity(name = "assistance_Product")
public class Product extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -7629974733313956810L;

    @CaseConversion
    @NotNull
    @Column(name = "CODE", nullable = false, unique = true, length = 10)
    protected String code;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 150)
    protected String name;

    @Column(name = "DESCRIPTION")
    protected String description;

    @Composition
    @OneToMany(mappedBy = "product")
    protected List<SubProduct> subProduct;

    public List<SubProduct> getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(List<SubProduct> subProduct) {
        this.subProduct = subProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
