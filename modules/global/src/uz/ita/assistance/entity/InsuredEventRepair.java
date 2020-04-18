package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseLongIdEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|id")
@Table(name = "ASSISTANCE_INSURED_EVENT_REPAIR")
@Entity(name = "assistance_InsuredEventRepair")
public class InsuredEventRepair extends BaseLongIdEntity {
    private static final long serialVersionUID = -5496001980981820040L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSURED_EVENT_ID")
    protected InsuredEvent insuredEvent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REPAIR_ID")
    protected DetailAndRepairList repair;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    protected Double price;

    @NotNull
    @Column(name = "COUNT_", nullable = false)
    protected Integer count;

    @NotNull
    @Column(name = "SUM_", nullable = false)
    protected Double sum;

    @NotNull
    @Column(name = "VAT", nullable = false)
    protected Double vat;

    @NotNull
    @Column(name = "VAT_SUM", nullable = false)
    protected Double vatSum;

    @NotNull
    @Column(name = "TOTAL", nullable = false)
    protected Double total;

    public InsuredEvent getInsuredEvent() {
        return insuredEvent;
    }

    public void setInsuredEvent(InsuredEvent insuredEvent) {
        this.insuredEvent = insuredEvent;
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

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getSum() {
        return sum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public DetailAndRepairList getRepair() {
        return repair;
    }

    public void setRepair(DetailAndRepairList repair) {
        this.repair = repair;
    }

}
