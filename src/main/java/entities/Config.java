package entities;

import java.awt.*;
import java.io.File;

public class Config {

    public static final File guestSaveFile = new File("guestsavefile.json");
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final File LOGO_FILE = new File("logo.png");

    private Config() {}
}
