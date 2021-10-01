package ir.sogol.wallet.employee;

import ir.sogol.wallet.user.User;

import javax.persistence.*;

@Entity
@Table(name ="interview_employee")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("employee")
public class Employee extends User {

    @Column(name = "POSITION")
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "position='" + position + '\'' +
            '}';
    }
}
