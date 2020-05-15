package repos;

import entities.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestList {

    public List<Guest> list;

    public GuestList() {
        this.list = new ArrayList<>();
    }

    /**
     * Used for adding users to the list
     * @param guest Guest to be added to the list
     */
    public void add(Guest guest) {
        list.add(guest);
    }
}
