package entity.human;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Human {

    private String name;
    private String surname;
    private int age;
    private Role role;

    protected Human() {
    }

    protected Human(String name, String surname, int age, Role role) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.role = role;
    }
}
