package gui;

import entities.Config;
import repos.GuestList;
import javax.swing.*;
import java.awt.*;

public class GuestListView extends JFrame {

    public GuestListView(GuestList guestList, MainView mainView) {

        setLayout(new GridLayout(2, 1));

        JPanel navigation = new JPanel(new GridLayout(2, 1));

        navigation.add(new JPanel()); // Placeholder for Logo in Menu
        navigation.add(new BackButton(mainView, this));

        add(navigation);

        JScrollPane guestListPanel = new JScrollPane(new GuestListPanel(guestList, false));

        add(guestListPanel);

        setSize(Config.SCREEN_SIZE); // Sets window size to Fullscreen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
