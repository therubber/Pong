package gui;

import entities.Config;
import repos.GuestList;

import javax.swing.*;
import java.awt.*;

public class MarkPaidView extends JFrame {

    public MarkPaidView(GuestList guestList, MainView mainView) {

        setLayout(new GridLayout(2, 1));

        add(new NavigationBar(mainView, this));

        JPanel main = new JPanel();
        main.add(new GuestListPanel(guestList, true));

        add(main);

        setSize(Config.SCREEN_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
