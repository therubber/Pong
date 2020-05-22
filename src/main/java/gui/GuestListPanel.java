package gui;

import entities.Guest;
import repos.GuestList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestListPanel extends JPanel {

    private GuestList guestList;

    public GuestListPanel(GuestList guestList, boolean advanced) {

        this.guestList = guestList;

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

            if(advanced) {
                panel.add(new MarkPaidButton(guest));
            } else {
                panel.add(new JLabel(Boolean.toString(guest.hasPaid)));
            }

            add(panel);
            i++;
        }
    }

    private class MarkPaidButton extends JButton {

        private final Guest guest;

        public MarkPaidButton(Guest guest) {
            this.guest = guest;
            if(!guest.hasPaid) {
                this.setText("Mark as paid");
            } else {
                this.setText("Mark as not paid");
            }
            this.addActionListener(new MarkPaidListener());
        }

        private class MarkPaidListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                guest.hasPaid = !guest.hasPaid;
                guestList.save();
            }
        }
    }
}
