package gui;

import entities.Guest;
import repos.GuestList;

import javax.swing.*;
import java.awt.*;

public class GuestListViewer extends JFrame {

    public GuestListViewer(GuestList guestList) {
        int i = 1;

        setLayout(new GridLayout(guestList.list.size() + 1, 1));

        JPanel menu = new JPanel(new GridLayout(1, 4));
        menu.add(new JLabel("No."));
        menu.add(new JLabel("Firstname"));
        menu.add(new JLabel("Lastname"));
        menu.add(new JLabel("Paid"));
        add(menu);

        for(Guest guest : guestList.list) {
            JPanel panel = new JPanel(new GridLayout(1, 4));
            panel.add(new JLabel(Integer.toString(i)));
            panel.add(new JLabel(guest.firstname));
            panel.add(new JLabel(guest.lastname));
            panel.add(new JLabel(Boolean.toString(guest.hasPaid)));
            add(panel);
            i++;
        }

        setSize(500, 200);
    }
}
