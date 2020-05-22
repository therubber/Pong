package entities;

import java.util.UUID;

public class Guest {

    public final UUID id;
    public final String firstname;
    public final String lastname;
    public boolean hasPaid;


    public Guest(String firstname, String lastname) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.hasPaid = false;
    }

    public Guest(String firstname, String lastname, boolean hasPaid) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.hasPaid = hasPaid;
    }

    @Override
    public String toString() {
        return  System.lineSeparator() +
                firstname + '\t' +
                lastname + '\t' +
                hasPaid;
    }
}
