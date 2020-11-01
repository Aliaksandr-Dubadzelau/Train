package entity.human;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;

@Setter
@Getter
public abstract class Human {

    private String name;
    private String surname;
    private int age;

    protected Human() {
    }

    protected Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
