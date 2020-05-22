package gui;

import controller.TerminalController;
import entities.Config;

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
        addGuestsButton.addActionListener(new AddGuestViewListener(this));
        add(addGuestsButton);

        JButton markPaidButton = new JButton("Mark guests as paid");
        markPaidButton.addActionListener(new MarkPaidViewListener(this));
        add(markPaidButton);

        JButton tournamentButton = new JButton("Tournament");
        add(tournamentButton);

        setSize(Config.SCREEN_SIZE); // Sets window size to fullscreen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    /**
     * ActionListener to get to get to a view where you can add new guests to the list
     */
    private class AddGuestViewListener implements ActionListener {

        private final MainView mainView;

        public AddGuestViewListener(MainView mainView) {
            this.mainView = mainView;
        }

        public void actionPerformed(ActionEvent e) {
            controller.addGuestView.setVisible(true);
            mainView.setVisible(false);
        }
    }

    /**
     * ActionListener to get to a view where guests can be marked to have paid the entrance fee
     */
    private class MarkPaidViewListener implements ActionListener {

        private MainView mainView;

        public MarkPaidViewListener(MainView mainView) {
            this.mainView = mainView;
        }

        public void actionPerformed(ActionEvent e) {
            controller.markPaidView = new MarkPaidView(controller.guestList, mainView);
            controller.markPaidView.setVisible(true);
            mainView.setVisible(false);
        }
    }
}
