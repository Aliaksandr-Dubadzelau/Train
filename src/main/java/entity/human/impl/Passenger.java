package entity.human.impl;

import entity.human.Human;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger extends Human {

    private int ticketNumber;

    private Passenger() {
    }

    private Passenger(String name, String surname, int age, int ticketNumber) {
        super(name, surname, age);
        this.ticketNumber = ticketNumber;
    }

    public static Passenger of() {
        return new Passenger();
    }

    public static Passenger of(String name, String surname, int age, int ticket) {
        return new Passenger(name, surname, age, ticket);
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() +
                " Surname: " + super.getSurname() +
                " Age: " + super.getAge() +
                " Ticket number: " + this.getTicketNumber();
    }
}
