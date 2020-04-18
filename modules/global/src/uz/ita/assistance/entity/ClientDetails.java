package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NamePattern("%s|name")
@MetaClass(name = "assistance_ClientDitails")
@Embeddable
public class ClientDetails extends EmbeddableEntity {
    private static final long serialVersionUID = 2335491134550184559L;

    @Column(name = "TIN", length = 12)
    protected String tin;

    @Column(name = "NAME", length = 150)
    protected String name;

    @Column(name = "CHIEF_NAME", length = 120)
    protected String chiefName;

    @Column(name = "ACCOUNTANT_NAME", length = 120)
    protected String accountantName;

    @Column(name = "CONTACT_NAME", length = 120)
    protected String contactName;

    @Column(name = "DOCUMENT", length = 120)
    protected String document;

    @Column(name = "NCEA", length = 5)
    protected String ncea;

    public String getNcea() {
        return ncea;
    }

    public void setNcea(String ncea) {
        this.ncea = ncea;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAccountantName() {
        return accountantName;
    }

    public void setAccountantName(String accountantName) {
        this.accountantName = accountantName;
    }

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }
}