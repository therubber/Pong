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

        setLayout(new GridLayout(5, 1));

        add(new NavigationBar());

        JButton guestListButton = new JButton("Guest list");
        guestListButton.addActionListener(new NavigationListener(this, "GUESTLIST"));
        add(guestListButton);

        JButton addGuestsButton = new JButton("Add Guests");
        addGuestsButton.addActionListener(new NavigationListener(this, "ADD_GUEST"));
        add(addGuestsButton);

        JButton markPaidButton = new JButton("Mark guests as paid");
        markPaidButton.addActionListener(new NavigationListener(this, "MARK_PAID"));
        add(markPaidButton);

        JButton tournamentButton = new JButton("Tournament");
        tournamentButton.addActionListener(new NavigationListener(this, "TOURNAMENT"));
        add(tournamentButton);

        setSize(Config.SCREEN_SIZE); // Sets window size to fullscreen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * ActionListener to switch between two windows in the program
     * Used for the main Navigation
     */
    private class NavigationListener implements ActionListener {

        private final MainView mainView;
        private final String mode;

        public NavigationListener(MainView mainView, String mode) {
            this.mainView = mainView;
            this.mode = mode;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (mode) {
                case "ADD_GUEST":
                    controller.addGuestView.setVisible(true);
                    mainView.setVisible(false);
                    break;
                case "TOURNAMENT":
                    controller.tournamentView.setVisible(true);
                    mainView.setVisible(false);
                    break;
                case "MARK_PAID":
                    controller.markPaidView = new MarkPaidView(controller.guestList, mainView);
                    controller.markPaidView.setVisible(true);
                    mainView.setVisible(false);
                    break;
                case "GUESTLIST":
                    controller.guestListView = new GuestListView(controller.guestList, controller.mainView);
                    controller.guestListView.setVisible(true);
                    mainView.setVisible(false);
                    break;
                default:
                    break;
            }
        }
    }
}
