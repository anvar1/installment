package uz.ita.assistance.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.EmbeddableEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@MetaClass(name = "assistance_BankDetails")
@Embeddable
public class BankDetails extends EmbeddableEntity {
    private static final long serialVersionUID = -7380526779154682239L;

    @Column(name = "CODE", length = 5)
    protected String code;

    @Column(name = "BANK_NAME")
    protected String bankName;

    @Column(name = "ACCOUNT_NUMBER", length = 20)
    protected String accountNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}