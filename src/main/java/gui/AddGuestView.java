package gui;

import entities.Config;
import entities.Guest;
import repos.GuestList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGuestView extends JFrame {

    private JTextField firstnameField;
    private JTextField lastnameField;
    private JCheckBox hasPaidCheck;

    public AddGuestView(GuestList guestList, MainView mainView) {

        setLayout(new GridLayout(3, 1));

        add(new BackButton(mainView, this));

        JPanel form = new JPanel(new GridLayout(1, 4));

        firstnameField = new JTextField();
        lastnameField = new JTextField();
        hasPaidCheck = new JCheckBox("Paid");
        JButton submit = new JButton("Add to List");
        submit.addActionListener(new SubmitListener(guestList));

        form.add(firstnameField);
        form.add(lastnameField);
        form.add(hasPaidCheck);
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

                guestList.add(new Guest(firstnameField.getText(), lastnameField.getText(), hasPaidCheck.isSelected()));
                guestList.save();

                firstnameField.setText("");
                lastnameField.setText("");
                hasPaidCheck.setSelected(false);
            }
        }
    }
}