package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackListener implements ActionListener {

    private MainView mainView;
    private JFrame currentView;

    public BackListener(MainView mainView, JFrame jFrame) {
        this.mainView = mainView;
        this.currentView = jFrame;
    }

    public void actionPerformed(ActionEvent e) {
        mainView.setVisible(true);
        currentView.setVisible(false);
    }
}
