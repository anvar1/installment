package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.*;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NamePattern("%s|number")
@Table(name = "ASSISTANCE_INSURED_EVENT")
@Entity(name = "assistance_InsuredEvent")
public class InsuredEvent extends BaseLongIdEntity implements Versioned, SoftDelete, Updatable, Creatable {
    private static final long serialVersionUID = -5671659407395141436L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTRACT_ID")
    protected Contract contract;

    @NotNull
    @Column(name = "INSURANT", nullable = false)
    protected String insurant;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "series", column = @Column(name = "PASSPORT_SERIES")),
            @AttributeOverride(name = "number", column = @Column(name = "PASSPORT_NUMBER_")),
            @AttributeOverride(name = "given", column = @Column(name = "PASSPORT_GIVEN")),
            @AttributeOverride(name = "givenDate", column = @Column(name = "PASSPORT_GIVEN_DATE"))
    })
    protected Passport passport;

    @Column(name = "NUMBER_", length = 20)
    protected String number;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_", nullable = false)
    @NotNull
    protected Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID")
    protected Service service;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "EVENT_DATE", nullable = false)
    protected Date eventDate;

    @Column(name = "YEAR_")
    protected Integer year;

    @NotNull
    @Column(name = "WAS_INSURED", nullable = false)
    protected Boolean wasInsured = true;

    @Column(name = "PHONE", length = 20)
    protected String phone;

    @NotNull
    @Column(name = "SUM_", nullable = false)
    protected Double sum = 0D;

    @NotNull
    @Column(name = "SUM_NOT_RECOVERED", nullable = false)
    protected Double sumNotRecovered = 0D;

    @NotNull
    @Column(name = "VAT_SUM", nullable = false)
    protected Double vatSum = 0D;

    @NotNull
    @Column(name = "VAT_SUM_NOT_RECOVERED", nullable = false)
    protected Double vatSumNotRecovered = 0D;

    @NotNull
    @Column(name = "TOTAL", nullable = false)
    protected Double total = 0D;

    @NotNull
    @Column(name = "TOTAL_NOT_RECOVERED", nullable = false)
    protected Double totalNotRecovered = 0D;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "insuredEvent")
    protected List<InsuredEventRepair> repair;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "insuredEvent")
    protected List<InsuredEventRepairNotCovered> repairNotCovered;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    protected String status = InsuredEventStatus.ACTIVE.getId();

    @Version
    @Column(name = "VERSION", nullable = false)
    protected Integer version;

    @Column(name = "DELETE_TS")
    protected Date deleteTs;

    @Column(name = "DELETED_BY", length = 50)
    protected String deletedBy;

    @Column(name = "UPDATE_TS")
    protected Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    protected String updatedBy;

    @Column(name = "CREATE_TS")
    protected Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    protected String createdBy;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public InsuredEventStatus getStatus() {
        return status == null ? null : InsuredEventStatus.fromId(status);
    }

    public void setStatus(InsuredEventStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public Double getTotalNotRecovered() {
        return totalNotRecovered;
    }

    public void setTotalNotRecovered(Double totalNotRecovered) {
        this.totalNotRecovered = totalNotRecovered;
    }

    public Double getVatSumNotRecovered() {
        return vatSumNotRecovered;
    }

    public void setVatSumNotRecovered(Double vatSumNotRecovered) {
        this.vatSumNotRecovered = vatSumNotRecovered;
    }

    public Double getSumNotRecovered() {
        return sumNotRecovered;
    }

    public void setSumNotRecovered(Double sumNotRecovered) {
        this.sumNotRecovered = sumNotRecovered;
    }

    public List<InsuredEventRepairNotCovered> getRepairNotCovered() {
        return repairNotCovered;
    }

    public void setRepairNotCovered(List<InsuredEventRepairNotCovered> repairNotCovered) {
        this.repairNotCovered = repairNotCovered;
    }

    public List<InsuredEventRepair> getRepair() {
        return repair;
    }

    public void setRepair(List<InsuredEventRepair> repair) {
        this.repair = repair;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setVatSum(Double vatSum) {
        this.vatSum = vatSum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getTotal() {
        return total;
    }

    public Double getVatSum() {
        return vatSum;
    }

    public Double getSum() {
        return sum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInsurant() {
        return insurant;
    }

    public void setInsurant(String insurant) {
        this.insurant = insurant;
    }

    public Boolean getWasInsured() {
        return wasInsured;
    }

    public void setWasInsured(Boolean wasInsured) {
        this.wasInsured = wasInsured;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getCreateTs() {
        return createTs;
    }

    @Override
    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    @Override
    public Boolean isDeleted() {
        return deleteTs != null;
    }

    @Override
    public String getDeletedBy() {
        return deletedBy;
    }

    @Override
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public Date getDeleteTs() {
        return deleteTs;
    }

    @Override
    public void setDeleteTs(Date deleteTs) {
        this.deleteTs = deleteTs;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

}
