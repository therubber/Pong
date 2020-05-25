package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    private Guest guest;

    @BeforeEach
    void setUp() {
        this.guest = new Guest("Jay", "Unit", true, false);
    }

    @Test
    void hasFirstname() {
        assertNotNull(guest.firstname);
    }

    @Test
    void hasLastname() {
        assertNotNull(guest.lastname);
    }

    @Test
    void hasPaidField() {
        assertTrue(guest.hasPaid);
    }

    @Test
    void isParticipantTest() {
        assertFalse(guest.isParticipant());
    }
}