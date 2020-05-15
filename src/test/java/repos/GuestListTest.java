package repos;

import entities.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestListTest {

    private GuestList guestList;

    @BeforeEach
    void setUp() {
        this.guestList = new GuestList();
    }

    @Test
    void testHasList() {
        assertNotNull(guestList.list);
    }

    @Test
    void add() {
        Guest guest = new Guest("Jay", "Unit", true);
        guestList.add(guest);

        assertTrue(guestList.list.contains(guest));
    }
}