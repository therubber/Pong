package gui;

import repos.GuestList;
import javax.swing.*;
import java.awt.*;

public class GuestListView extends JFrame {

    public GuestListView(GuestList guestList, MainView mainView) {
        
        setLayout(new GridLayout(2, 1));
        setSize(500, 500);

        JPanel navigation = new JPanel(new GridLayout(3, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new BackListener(mainView, this));
        navigation.add(new JPanel()); // Placeholder for Logo in Menu
        navigation.add(backButton);
        navigation.add(new JPanel());

        add(navigation);

        JPanel guestListPanel = new GuestListPanel(guestList);

        add(guestListPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
