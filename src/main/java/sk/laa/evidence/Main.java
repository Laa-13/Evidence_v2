package sk.laa.evidence;

import sk.laa.evidence.service.ClientService;
import sk.laa.evidence.service.ConsoleUi;
import sk.laa.evidence.service.UserService;

public class Main {
    public static void main(String[] args) {

        ClientService clientService = new ClientService();
        UserService userService = new UserService();

        ConsoleUi consoleUi = new ConsoleUi(clientService, userService);
        consoleUi.mainMenu();


    }
}
