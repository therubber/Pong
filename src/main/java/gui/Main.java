package gui;

import controller.TerminalController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI that the program boots into
 * Contains main menu buttons for navigation
 */
public class Main extends JFrame {

    private final transient TerminalController controller;

    public Main(TerminalController controller) {
        this.controller = controller;

        setLayout(new GridLayout(4, 1));

        JButton guestListButton = new JButton("Guest list");
        guestListButton.addActionListener(new GuestListListener(this));
        add(guestListButton);

        JButton addGuestsButton = new JButton("Add Guests");
        add(addGuestsButton);

        JButton markPaidButton = new JButton("Mark guests as paid");
        add(markPaidButton);

        JButton tournamentButton = new JButton("Tournament");
        add(tournamentButton);

        setSize(500, 500);
        setVisible(true);
    }

    /**
     * ActionListener to get to a view of the current GuestList
     */
    private class GuestListListener implements ActionListener {

        private final Main main;

        public GuestListListener(Main main) {
            this.main = main;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.guestListViewer.setVisible(true);
            main.setVisible(false);
        }
    }
}
