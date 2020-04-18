package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|agent")
@Table(name = "ASSISTANCE_AGENT_HIERARCHY")
@Entity(name = "assistance_AgentHierarchy")
public class AgentHierarchy extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 3406637146587331368L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AGENT_ID")
    private Agent agent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARENT_ID")
    private Agent parent;

    @Column(name = "LEVEL_")
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Agent getParent() {
        return parent;
    }

    public void setParent(Agent parent) {
        this.parent = parent;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

}