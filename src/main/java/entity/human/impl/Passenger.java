package entity.human.impl;

import entity.human.Human;
import entity.human.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger extends Human {

    private int ticketNumber;

    private Passenger() {
    }

    private Passenger(String name, String surname, int age, Role role, int ticketNumber) {
        super(name, surname, age, role);
        this.ticketNumber = ticketNumber;
    }

    public static Passenger ofPassenger() {
        return new Passenger();
    }

    public static Passenger ofPassenger(String name, String surname, int age, Role role, int ticket) {
        return new Passenger(name, surname, age, role, ticket);
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() +
                " Surname: " + super.getSurname() +
                " Age: " + super.getAge() +
                " Role: " + super.getRole() +
                " Ticket number: " + this.getTicketNumber();
    }
}
