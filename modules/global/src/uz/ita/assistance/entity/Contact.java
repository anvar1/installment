package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NamePattern("%s|mobilePhone")
@MetaClass(name = "assistance_Contact")
@Embeddable
public class Contact extends EmbeddableEntity {
    private static final long serialVersionUID = 3301876973153152899L;

    @Column(name = "PHONE", length = 50)
    protected String phone;

    @Column(name = "FAX", length = 50)
    protected String fax;

    @Column(name = "MOBILE_PHONE", length = 50)
    protected String mobilePhone;

    @Column(name = "EMAIL", length = 50)
    protected String email;

    @Column(name = "WWW", length = 50)
    protected String www;

    @Column(name = "TELEGRAM", length = 50)
    protected String telegram;

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}