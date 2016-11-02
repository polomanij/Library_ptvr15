package Entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import parser.ParseId;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String fName;
    private String lName;
    private String isik;
    private String birthsday;
    private String sex;

    public Person() {
    }

    public Person(String fName, String lName, String isik) {
        this.fName = fName;
        this.lName = lName;
        this.isik = isik;
        this.birthsday = ParseId.birthday(isik);
        this.sex = ParseId.getGender(isik);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getIsik() {
        return isik;
    }

    public void setIsik(String isik) {
        this.isik = isik;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getBirthsday() {
        return birthsday;
    }

    public void setBirthsday(String birthsday) {
        this.birthsday = birthsday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.birthsday);
        hash = 37 * hash + Objects.hashCode(this.sex);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        
        if (!Objects.equals(this.birthsday, other.birthsday)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        return true;
    }
    
    
}
