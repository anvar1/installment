package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MetaClass(name = "assistance_Passport")
@Embeddable
public class Passport extends EmbeddableEntity {
    private static final long serialVersionUID = 76499705477321607L;

    @Column(name = "SERIES", length = 3)
    protected String series;

    @Column(name = "NUMBER_", length = 9)
    protected String number;

    @Column(name = "GIVEN")
    protected String given;

    @Temporal(TemporalType.DATE)
    @Column(name = "GIVEN_DATE")
    protected Date givenDate;

    public Date getGivenDate() {
        return givenDate;
    }

    public void setGivenDate(Date givenDate) {
        this.givenDate = givenDate;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}