package gui;

import entities.Guest;
import repos.GuestList;
import javax.swing.*;
import java.awt.*;

public class GuestListView extends JFrame {

    public GuestListView(GuestList guestList, MainView mainView) {

        setSize(500, 300);

        setLayout(new GridLayout(guestList.list.size() + 2, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new BackListener(mainView, this));
        add(backButton);
        add(new JPanel()); // Empty GUI Space for readablilty of the list

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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
