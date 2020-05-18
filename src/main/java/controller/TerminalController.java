package controller;

import gui.AddGuestView;
import gui.GuestListView;
import gui.MainView;
import repos.GuestList;

public class TerminalController {

    public final GuestList guestList;
    public final MainView mainView;
    public GuestListView guestListView; // Non-final -> reassigned when a new guest is added to the list
    public final AddGuestView addGuestView;

    public TerminalController() {
        this.guestList = new GuestList();
        this.mainView = new MainView(this);
        this.guestListView = new GuestListView(guestList, mainView);
        this.addGuestView = new AddGuestView(guestList, mainView);
    }

    public static void main(String[] args) {
        TerminalController controller = new TerminalController();
        controller.guestList.save();
    }
}
