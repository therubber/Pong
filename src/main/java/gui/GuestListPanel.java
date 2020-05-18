package gui;

import entities.Guest;
import repos.GuestList;
import javax.swing.*;
import java.awt.*;

public class GuestListPanel extends JPanel {

    public GuestListPanel(GuestList guestList) {

        setLayout(new GridLayout(guestList.list.size() + 1, 1));

        JPanel description = new JPanel(new GridLayout(1, 4));
        description.add(new JLabel("No."));
        description.add(new JLabel("Firstname"));
        description.add(new JLabel("Lastname"));
        description.add(new JLabel("Paid"));
        add(description);

        int i = 1;
        for(Guest guest : guestList.list) {
            JPanel panel = new JPanel(new GridLayout(1, 4));
            panel.add(new JLabel(Integer.toString(i)));
            panel.add(new JLabel(guest.firstname));
            panel.add(new JLabel(guest.lastname));
            panel.add(new JLabel(Boolean.toString(guest.hasPaid)));
            add(panel);
            i++;
        }
    }
}
