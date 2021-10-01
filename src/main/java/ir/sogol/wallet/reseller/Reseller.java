package ir.sogol.wallet.reseller;

import ir.sogol.wallet.user.User;

import javax.persistence.*;


@Entity
@Table(name ="interview_reseller")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("reseller")
public class Reseller extends User {

    @Column(name = "CODE")
    private String code;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    @Override
    public String toString() {
        return "Reseller [code=" + code + ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getName()=" + getName() + "]";
    }
}
