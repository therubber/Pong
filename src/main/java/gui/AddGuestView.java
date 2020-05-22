package gui;

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
        setSize(500, 300);

        setLayout(new GridLayout(3, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new BackListener(mainView, this));
        add(backButton);

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