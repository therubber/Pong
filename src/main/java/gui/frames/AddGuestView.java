package gui.frames;

import entities.Config;
import entities.Guest;
import gui.NavigationBar;
import repos.GuestList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGuestView extends JFrame {

    private JTextField firstnameField;
    private JTextField lastnameField;
    private JCheckBox hasPaidCheck;
    private JCheckBox participantCheck;

    public AddGuestView(GuestList guestList, MainView mainView) {

        setLayout(new GridLayout(3, 1));

        add(new NavigationBar(mainView, this));

        JPanel form = new JPanel(new GridLayout(1, 5));

        firstnameField = new JTextField();
        lastnameField = new JTextField();
        hasPaidCheck = new JCheckBox("Paid");
        participantCheck = new JCheckBox("Pong participant");
        JButton submit = new JButton("Add to List");
        submit.addActionListener(new SubmitListener(guestList));

        form.add(firstnameField);
        form.add(lastnameField);
        form.add(hasPaidCheck);
        form.add(participantCheck);
        add(form);
        add(submit);

        setSize(Config.SCREEN_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class SubmitListener implements ActionListener {

        private final GuestList guestList;

        private SubmitListener(GuestList guestList) {
            this.guestList = guestList;
        }

        public void actionPerformed(ActionEvent e) {
            if(!firstnameField.getText().equals("") && !lastnameField.getText().equals("")) {

                guestList.add(new Guest(firstnameField.getText(), lastnameField.getText(), hasPaidCheck.isSelected(), participantCheck.isSelected()));
                guestList.save();

                firstnameField.setText("");
                lastnameField.setText("");
                hasPaidCheck.setSelected(false);
            }
        }
    }
}