package entities;

import java.util.UUID;

public class Guest {

    public final UUID id;
    public final String firstname;
    public final String lastname;
    public boolean hasPaid;
    private boolean isParticipant;


    public Guest(String firstname, String lastname) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.hasPaid = false;
        this.isParticipant = false;
    }

    public Guest(String firstname, String lastname, boolean hasPaid, boolean isParticipant) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.hasPaid = hasPaid;
        this.isParticipant = isParticipant;
    }

    /**
     * Changes the guests payment status
     */
    public void changePaymentStatus() {
        this.hasPaid = !this.hasPaid;
    }

    /**
     * Checks whether the guest is participating in the tournament
     * @return boolean whether the guest is participating in the tournament
     */
    public boolean isParticipant() {
        return this.isParticipant;
    }

    /**
     * Changes the guests tournament participation status
     */
    public void changeParticipation() {
        this.isParticipant = !this.isParticipant;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", hasPaid=" + hasPaid +
                ", isParticipant=" + isParticipant +
                '}';
    }
}
