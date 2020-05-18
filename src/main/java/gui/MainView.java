package gui;

import controller.TerminalController;
import entities.Guest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI that the program boots into
 * Contains main menu buttons for navigation
 */
public class MainView extends JFrame {

    private final transient TerminalController controller;

    public MainView(TerminalController controller) {
        this.controller = controller;

        setLayout(new GridLayout(4, 1));

        JButton guestListButton = new JButton("Guest list");
        guestListButton.addActionListener(new GuestListListener(this));
        add(guestListButton);

        JButton addGuestsButton = new JButton("Add Guests");
        addGuestsButton.addActionListener(new AddGuestListener(this));
        add(addGuestsButton);

        JButton markPaidButton = new JButton("Mark guests as paid");
        add(markPaidButton);

        JButton tournamentButton = new JButton("Tournament");
        add(tournamentButton);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    /**
     * ActionListener to get to a view of the current GuestList
     */
    private class GuestListListener implements ActionListener {

        private final MainView mainView;

        public GuestListListener(MainView mainView) {
            this.mainView = mainView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.guestListView = new GuestListView(controller.guestList, controller.mainView);
            controller.guestListView.setVisible(true);
            mainView.setVisible(false);
        }
    }

    private class AddGuestListener implements ActionListener {

        private final MainView mainView;

        public AddGuestListener(MainView mainView) {
            this.mainView = mainView;
        }

        public void actionPerformed(ActionEvent e) {
            controller.addGuestView.setVisible(true);
            mainView.setVisible(false);
        }
    }
}
