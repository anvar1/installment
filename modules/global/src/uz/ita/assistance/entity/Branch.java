package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;
import uz.ita.assistance.entity.address.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "ASSISTANCE_BRANCH")
@Entity(name = "assistance_Branch")
public class Branch extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 9119907620227943508L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 120)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Branch parent;

    @OneToMany(mappedBy = "branch")
    @OrderBy("level")
    private List<BranchHierarchy> hierarchyList;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "tin", column = @Column(name = "CLIENT_TIN")),
            @AttributeOverride(name = "name", column = @Column(name = "CLIENT_NAME")),
            @AttributeOverride(name = "chiefName", column = @Column(name = "CLIENT_CHIEF_NAME")),
            @AttributeOverride(name = "accountantName", column = @Column(name = "CLIENT_ACCOUNTANT_NAME")),
            @AttributeOverride(name = "contactName", column = @Column(name = "CLIENT_CONTACT_NAME")),
            @AttributeOverride(name = "document", column = @Column(name = "CLIENT_DOCUMENT")),
            @AttributeOverride(name = "ncea", column = @Column(name = "CLIENT_NCEA"))
    })
    protected ClientDetails client;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AssociationOverrides({
            @AssociationOverride(name = "country", joinColumns = @JoinColumn(name = "ADDRESS_COUNTRY_ID")),
            @AssociationOverride(name = "region", joinColumns = @JoinColumn(name = "ADDRESS_REGION_ID")),
            @AssociationOverride(name = "district", joinColumns = @JoinColumn(name = "ADDRESS_DISTRICT_ID"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "ADDRESS_CITY")),
            @AttributeOverride(name = "address", column = @Column(name = "ADDRESS_ADDRESS"))
    })
    protected Address address;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "code", column = @Column(name = "BANK_CODE")),
            @AttributeOverride(name = "accountNumber", column = @Column(name = "BANK_ACCOUNT_NUMBER"))
    })
    protected BankDetails bank;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "phone", column = @Column(name = "CONTACT_PHONE")),
            @AttributeOverride(name = "fax", column = @Column(name = "CONTACT_FAX")),
            @AttributeOverride(name = "mobilePhone", column = @Column(name = "CONTACT_MOBILE_PHONE")),
            @AttributeOverride(name = "email", column = @Column(name = "CONTACT_EMAIL")),
            @AttributeOverride(name = "www", column = @Column(name = "CONTACT_WWW")),
            @AttributeOverride(name = "telegram", column = @Column(name = "CONTACT_TELEGRAM"))
    })
    protected Contact contact;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "series", column = @Column(name = "PASSPORT_SERIES")),
            @AttributeOverride(name = "number", column = @Column(name = "PASSPORT_NUMBER_")),
            @AttributeOverride(name = "given", column = @Column(name = "PASSPORT_GIVEN")),
            @AttributeOverride(name = "givenDate", column = @Column(name = "PASSPORT_GIVEN_DATE"))
    })
    protected Passport passport;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ClientDetails getClient() {
        return client;
    }

    public void setClient(ClientDetails client) {
        this.client = client;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public BankDetails getBank() {
        return bank;
    }

    public void setBank(BankDetails bank) {
        this.bank = bank;
    }

    public List<BranchHierarchy> getHierarchyList() {
        return hierarchyList;
    }

    public void setHierarchyList(List<BranchHierarchy> hierarchyList) {
        this.hierarchyList = hierarchyList;
    }

    public Branch getParent() {
        return parent;
    }

    public void setParent(Branch parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}