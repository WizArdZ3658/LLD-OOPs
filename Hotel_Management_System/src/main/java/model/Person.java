package model;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Person {

    private String name;
    private Integer age;
    private Gender gender;
    private String phone;
    private String emailId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Person person = (Person) o;
        return emailId.equals(person.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId);
    }
}
