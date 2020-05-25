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

        setLayout(new GridLayout(guestList.list.size() + 2, 1));

        JPanel description = new JPanel(new GridLayout(1, 5));
        description.add(new JLabel("No."));
        description.add(new JLabel("Firstname"));
        description.add(new JLabel("Lastname"));
        description.add(new JLabel("Paid"));
        description.add(new JLabel("BeerPong"));
        add(description);

        int i = 1;
        for(Guest guest : guestList.list) {
            JPanel panel = new JPanel(new GridLayout(1, 5));
            panel.add(new JLabel(Integer.toString(i)));
            panel.add(new JLabel(guest.firstname));
            panel.add(new JLabel(guest.lastname));

            if(advanced) {
                panel.add(new PaymentStatusCheckBox(guest));
                panel.add(new ParticipationCheckBox(guest));
            } else {
                JCheckBox hasPaidCheckBox = new JCheckBox();
                hasPaidCheckBox.setSelected(guest.hasPaid);
                hasPaidCheckBox.setEnabled(false);
                panel.add(hasPaidCheckBox);

                JCheckBox beerPong = new JCheckBox();
                beerPong.setEnabled(false);
                if(guest.isParticipant()) {
                    beerPong.setSelected(true);
                }
                panel.add(beerPong);
            }

            add(panel);
            i++;
        }
    }

    private class PaymentStatusCheckBox extends JCheckBox {

        private final Guest guest;

        public PaymentStatusCheckBox(Guest guest) {
            this.guest = guest;
            this.addActionListener(new MarkPaidListener());

            if(guest.hasPaid) {
                setSelected(true);
            }
        }

        private class MarkPaidListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                guest.changePaymentStatus();
                guestList.save();
            }
        }
    }

    private class ParticipationCheckBox extends JCheckBox {

        private final Guest guest;

        public ParticipationCheckBox(Guest guest) {
            this.guest = guest;
            addActionListener(new ParticipantCheckBoxListener());

            if(guest.isParticipant()) {
                setSelected(true);
            }
        }

        private class ParticipantCheckBoxListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                guest.changeParticipation();
                guestList.save();
            }
        }
    }
}
