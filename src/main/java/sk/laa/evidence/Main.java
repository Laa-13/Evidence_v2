package sk.laa.evidence;

import sk.laa.evidence.service.ClientService;
import sk.laa.evidence.service.ConsoleUi;
import sk.laa.evidence.service.UserService;

public class Main {
    public static void main(String[] args) {

        ClientService clientService = new ClientService();
        UserService userService = new UserService();
        ConsoleUi consoleUi = new ConsoleUi(clientService, userService);

        System.out.print("""
                                    
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                Aplikacia : Evidencia poistencov - jednoducha verzia.
                                
                Aplikacia vytvorena ako projekt ku zaverecnej skuske
                rekvalifikacneho kurzu ITnetwork. Program dokaze
                ulozit novy zaznam poistenca, zobrazit existujuci
                zaznam poistenca, vypisat list vsetkch poistencov
                a mazat existujuce zaznamy podla potreby. Program
                funguje na principe uzivatel / administrator. Po
                spusteni je potrebne registrovat admina na obsluhu
                aplikacie a vytvaranie novych uzivatelov s roznymi
                pravami.
                                
                Dakujem. Janko
                                
                v1 = final ku zaverecnej skuske.
                v2 = aktualna komplet prepisana aplikacia.
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                                    
                                    
                """);
        consoleUi.addUserMenu();
        consoleUi.loginMenu();
        consoleUi.mainMenu();


    }
}
