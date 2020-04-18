package uz.ita.assistance.entity.address;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|address")
@MetaClass(name = "assistance_Address")
@Embeddable
public class Address extends EmbeddableEntity {
    private static final long serialVersionUID = 3149864208412683655L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COUNTRY_ID")
    protected Country country;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REGION_ID")
    protected Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTRICT_ID")
    protected District district;

    @Column(name = "CITY", length = 80)
    protected String city;

    @Column(name = "ADDRESS", length = 150)
    protected String address;

    public void setDistrict(District district) {
        this.district = district;
    }

    public District getDistrict() {
        return district;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
