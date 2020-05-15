package controller;

import entities.Guest;
import repos.GuestList;

import java.util.Scanner;

public class TerminalController {

    private final GuestList guestList;
    Scanner scanner = new Scanner(System.in);
    String command = "menu";

    public TerminalController() {
        this.guestList = new GuestList();
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
