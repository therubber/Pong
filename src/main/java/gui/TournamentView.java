package gui;

import entities.Config;
import repos.GuestList;

import javax.swing.*;
import java.awt.*;

public class TournamentView extends JFrame {

    public TournamentView(GuestList guestList, MainView mainView) {
        setLayout(new GridLayout(2, 1));

        add(new BackButton(mainView, this));
        add(new GuestListPanel(guestList, false));

        setSize(Config.SCREEN_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
