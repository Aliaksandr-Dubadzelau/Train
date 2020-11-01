package entity.human.impl;

import entity.human.Human;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends Human {

    private int amountOfWorkHours;

    private Driver() {
    }

    private Driver(String name, String surname, int age, int amountOfWorkHours) {
        super(name, surname, age);
        this.amountOfWorkHours = amountOfWorkHours;
    }

    public static Driver of() {
        return new Driver();
    }

    public static Driver of(String name, String surname, int age, int amountOfWorkHours) {
        return new Driver(name, surname, age, amountOfWorkHours);
    }

    @Override
    public String toString() {
        return " Name: " + super.getName() +
                " Surname: " + super.getSurname() +
                " Age: " + super.getAge() +
                " Amount of work hours: " + this.getAmountOfWorkHours();
    }
}
