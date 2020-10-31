package entity.human.impl;

import entity.human.Human;
import entity.human.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends Human {

    private int amountOfWorkHours;

    private Driver() {
    }

    private Driver(String name, String surname, int age, Role role, int amountOfWorkHours) {
        super(name, surname, age, role);
        this.amountOfWorkHours = amountOfWorkHours;
    }

    public static Driver ofDriver() {
        return new Driver();
    }

    public static Driver ofDriver(String name, String surname, int age, Role role, int amountOfWorkHours) {
        return new Driver(name, surname, age, role, amountOfWorkHours);
    }

    @Override
    public String toString() {
        return " Name: " + super.getName() +
                " Surname: " + super.getSurname() +
                " Age: " + super.getAge() +
                " Role: " + super.getRole() +
                " Amount of work hours: " + this.getAmountOfWorkHours();
    }
}
