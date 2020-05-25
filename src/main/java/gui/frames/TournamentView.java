package gui.frames;

import entities.Config;
import gui.NavigationBar;
import repos.GuestList;

import javax.swing.*;
import java.awt.*;

public class TournamentView extends JFrame {

    public TournamentView(GuestList guestList, MainView mainView) {
        setLayout(new GridLayout(3, 1));

        add(new NavigationBar(mainView, this));

        add(new JButton("View Teams"));
        add(new JButton("Add Teams"));

        setSize(Config.SCREEN_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
