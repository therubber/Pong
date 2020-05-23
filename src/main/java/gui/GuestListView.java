package gui;

import entities.Config;
import repos.GuestList;
import javax.swing.*;
import java.awt.*;

public class GuestListView extends JFrame {

    public GuestListView(GuestList guestList, MainView mainView) {

        setLayout(new GridLayout(2, 1));

        add(new NavigationBar(mainView, this));

        JScrollPane guestListPanel = new JScrollPane(new GuestListPanel(guestList, false));

        add(guestListPanel);

        setSize(Config.SCREEN_SIZE); // Sets window size to Fullscreen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
