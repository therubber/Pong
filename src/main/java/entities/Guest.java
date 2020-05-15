package entities;

public class Guest {

    public final String firstname;
    public final String lastname;
    public boolean hasPaid;


    public Guest(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.hasPaid = false;
    }

    public Guest(String firstname, String lastname, boolean hasPaid) {
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
