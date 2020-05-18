package controller;

import entities.Guest;
import gui.AddGuestView;
import gui.GuestListView;
import gui.MainView;
import repos.GuestList;

import java.util.Scanner;

public class TerminalController {

    public final GuestList guestList;
    public final MainView mainView;
    public GuestListView guestListView; // Non-final -> reassigned when a new guest is added to the list
    public final AddGuestView addGuestView;
    Scanner scanner = new Scanner(System.in);
    String command = "menu";

    public TerminalController() {
        this.guestList = new GuestList();
        this.mainView = new MainView(this);
        this.guestListView = new GuestListView(guestList, mainView);
        this.addGuestView = new AddGuestView(guestList, mainView);
    }

    public static void main(String[] args) {
        TerminalController controller = new TerminalController();

        controller.enterCommand();

        while(!controller.command.equals("exit")) {
            controller.navigate();
        }
        controller.guestList.save();
    }

    public void enterCommand() {
        command = scanner.nextLine();
    }

    private void navigate() {
        switch(command) {
            case "menu":
                System.out.println("Dummy Menu");
                break;
            case "new":
                System.out.println("Enter firstname: ");
                String firstname = scanner.nextLine();
                System.out.println("Enter lastname: ");
                String lastname = scanner.nextLine();

                guestList.add(new Guest(firstname, lastname));
                guestList.save();
                break;
            case "list":
                System.out.println(guestList.toString());
                break;
            default:
                command = "menu";
                break;
        }
        enterCommand();
    }
}
