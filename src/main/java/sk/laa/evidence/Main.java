package sk.laa.evidence;

import sk.laa.evidence.service.ClientService;
import sk.laa.evidence.service.ConsoleUi;
import sk.laa.evidence.service.UserService;

public class Main {
    public static void main(String[] args) {

        ClientService clientService = new ClientService();
        UserService userService = new UserService();
        ConsoleUi consoleUi = new ConsoleUi(clientService, userService);

        System.out.println("""
                                        
                                        
                    Evidencia poistencov - jednoducha verzia.
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    Prepracovana konzolova aplikacia, povodne ako projekt ku
                    zaverecnej skuske IT network.
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                                        
                                        
                    Na prve spustenie treba vytvorit uzivatela s admin pravami.
                    """);
        consoleUi.addUserMenu();
        consoleUi.loginMenu();
        consoleUi.mainMenu();
    }
}
