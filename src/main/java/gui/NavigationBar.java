package gui;

import entities.Config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NavigationBar extends JPanel {

    public NavigationBar(MainView mainView, JFrame currentView) {

        setLayout(new GridLayout(1, 3));

        add(new BackButton(mainView, currentView));

        try {
            BufferedImage image = ImageIO.read(Config.LOGO_FILE);
            ImageIcon logo = new ImageIcon(image);
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(logo);
            add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(new JPanel());
    }
}
