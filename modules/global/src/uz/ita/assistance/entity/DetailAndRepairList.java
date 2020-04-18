package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "ASSISTANCE_DETAIL_AND_REPAIR_LIST")
@Entity(name = "assistance_DetailAndRepairList")
public class DetailAndRepairList extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -9149971511537279901L;

    @NotNull
    @Column(name = "NAME", nullable = false, length = 200)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}