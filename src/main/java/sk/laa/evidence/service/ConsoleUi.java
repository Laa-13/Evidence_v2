package sk.laa.evidence.service;

import sk.laa.evidence.enumeration.Gender;
import sk.laa.evidence.model.Client;

import java.util.Scanner;

public class ConsoleUi {
    public Scanner scanner = new Scanner(System.in);
    private final ClientService clientService;
    private final UserService userService;
    private final String[] session = new String[2];
    private boolean active;
    private boolean back;

    public ConsoleUi(ClientService clientService, UserService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }

    public Gender enumSwitch(int input) {
        while ((input < 1) || (input > 2)) {
            System.out.println("Pohlavie: [1] = muz , [2] = zena");
            input = Integer.parseInt(scanner.nextLine().trim());
        }
        switch (input) {
            case 1 -> {
                return Gender.Muz;
            }
            case 2 -> {
                return Gender.Zena;
            }
            default -> {
                return null;
            }
        }
    }

    public void addClientMenu() {
        back = false;
        System.out.println("Zadaj meno:");
        String name = scanner.nextLine().trim();
        System.out.println("Zadaj priezvisko:");
        String surname = scanner.nextLine().trim();
        System.out.println("Zadaj vek:");
        int age = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Pohlavie: [1] = muz , [2] = zena");
        Gender gender = enumSwitch(Integer.parseInt(scanner.nextLine().trim()));
        System.out.println("Zadaj email:");
        String email = scanner.nextLine().trim();
        System.out.println("Zadaj telefon");
        int tel = Integer.parseInt(scanner.nextLine().trim());
        clientService.save(name, surname, age, gender, email, tel);
        System.out.println("Zaznam pridany :\n" + clientService.lastSaved());
        System.out.println("""
                Je zaznam zadany spravne?
                [Enter] - pokracovat ; edit - Editovat zaznam.
                """);
        if (scanner.nextLine().equals("edit")) {
            clientService.deleteLast();
            addClientMenu();
        } else {
            back = true;
        }
    }

    public void deleteClientMenu() {
        back = false;
        Client[] temp = new Client[1];
        clientService.list();
        System.out.println("Zadaj ID zaznamu na vymazanie:");
        int input = Integer.parseInt(scanner.nextLine().trim());
        temp[0] = clientService.findById(input);
        clientService.delete(input);
        System.out.println("Zaznam vymazany:\n" + temp[0]);
        temp[0] = null;
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void listClientMenu() {
        back = false;
        clientService.list();
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void searchClientByNameMenu() {
        back = false;
        System.out.println("Zadaj meno klienta:");
        clientService.findByName(scanner.nextLine().trim().toLowerCase());
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void searchClientBySurameMenu() {
        back = false;
        System.out.println("Zadaj priezvisko klienta:");
        clientService.findBySurname(scanner.nextLine().trim().toLowerCase());
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void searchClientByEmailMenu() {
        back = false;
        System.out.println("Zadaj email klienta:");
        clientService.findByEmail(scanner.nextLine().trim().toLowerCase());
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void searchClientByTelMenu() {
        back = false;
        System.out.println("Zadaj meno klienta:");
        clientService.findByTel(Integer.parseInt(scanner.nextLine().trim().toLowerCase()));
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void searchClientMenu() {
        active = true;
        while (active) {
            System.out.println("""
                    Vyhladam zaznam podla:
                                        
                    [1] - Mena
                    [2] - Priezviska
                    [3] - eMailu
                    [4] - Tel.cisla
                    =-=-=-=-=-=-=-=-=-=-=-=
                    """);
            switch (Integer.parseInt(scanner.nextLine().trim())) {
                case 1 -> {
                    do {
                        searchClientByNameMenu();
                    } while (!back);
                    back = false;
                }
                case 2 -> {
                    do {
                        searchClientBySurameMenu();
                    } while (!back);
                    back = false;
                }
                case 3 -> {
                    do {
                        searchClientByEmailMenu();
                    } while (!back);
                    back = false;
                }
                case 4 -> {
                    do {
                        searchClientByTelMenu();
                    } while (!back);
                    back = false;
                }
                case 5 -> active = false;
                default -> System.out.println("Zadaj cislo podla legendy!");
            }
        }
    }

    public void addUserMenu() {
        System.out.println("Zadaj meno uzivatela:");
        String name = scanner.nextLine().trim();
        System.out.println("zadaj heslo uzivatela:");
        String password = scanner.nextLine().trim();
        System.out.println("""
                Bude mat uzivatel admin prava?
                   [1] - nie ; [2] - ano
                """);
        int input = Integer.parseInt(scanner.nextLine().trim());
        while ((input < 1) || (input > 2)) {
            System.out.println("""
                    Bude mat uzivatel admin prava?
                       [1] - nie ; [2] - ano
                    """);
            input = Integer.parseInt(scanner.nextLine().trim());
        }
        switch (input) {
            case 1 -> userService.saveUser(name, password);
            case 2 -> userService.saveAdmin(name, password);
        }
    }

    public void deleteUserMenu() {
        System.out.println("Zadaj meno pouzivatela na odstranenie:");
        String input = scanner.nextLine().trim();
        while (!userService.findUser(input)) {
            System.out.printf("""
                    Uzivatelske meno %s nie je v databaze.
                    Zadaj meno znova.
                    """, input);
            input = scanner.nextLine().trim();
        }
        userService.deleteUser(input);
        System.out.printf("""
                Uzivatel odstraneny z databaze:
                %s
                """, input);
    }

    public void deleteAdminMenu() {
        System.out.println("Zadaj meno administratora na odstranenie:");
        String input = scanner.nextLine().trim();
        while (!userService.findAdmin(input)) {
            System.out.printf("""
                    Uzivatelske meno %s nie je v databaze.
                    Zadaj meno znova.
                    """, input);
            input = scanner.nextLine().trim();
        }
        userService.deleteAdmin(input);
        System.out.printf("""
                Admin odstraneny z databaze:
                %s
                """, input);
    }

    public void deleteUserAdminMenu() {
        System.out.println("""
                Odstranit:
                [1] - Uzivatela
                [2] - Admina
                """);
        int input = Integer.parseInt(scanner.nextLine().trim());
        while ((input < 1) || (input > 2)) {
            System.out.println("Zadanie musi byt podla legendy.");
            input = Integer.parseInt(scanner.nextLine().trim());
        }
        switch (input) {
            case 1 -> deleteUserMenu();
            case 2 -> deleteAdminMenu();
        }
    }

    public void listOfUsersMenu() {
        back = false;
        System.out.println("""
                Zobrazujem list uzivatelov:
                =-=-=-=-=-=-=-=-=-=-=-=-=-=
                """);
        userService.listOfUsers();
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void listOfAdminsMenu() {
        back = false;
        System.out.println("""
                Zobrazujem list administratorov:
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """);
        userService.listOfAdmins();
        System.out.println("[Enter] - pokracovat");
        if (scanner.nextLine().equals("[press any key to continue]")) {
            back = true;
        } else {
            back = true;
        }
    }

    public void loginMenu() {
        System.out.println("Zadaj prihlasovacie meno:");
        String name = scanner.nextLine().trim();
        System.out.println("Zadaj prihlasovacie heslo:");
        String password = scanner.nextLine().trim();
        userService.login(name, password);
        session[0] = name;
        if (userService.isUser()) {
            session[1] = "uzivatel";
        }
        if (userService.isAdmin()) {
            session[1] = "administrator";
        }
    }

    public void logoutMenu() {
        userService.logout();
        System.out.println("""
                Uzivatel bol odhlaseny.
                =-=-=-=-=-=-=-=-=-=-=-=
                """);
        loginMenu();
    }

    public void adminMenu() {
        if (!userService.isAdmin()) {
            System.out.println("""
                                        
                    Nie si administrator.
                    Nemas pravo prehliadat tuto sekciu
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    """);
        } else {
            do {
                active = true;
                System.out.println("""
                        Administratorske menu.
                        =-=-=-=-=-=-=-=-=-=-=-=-=
                        [1] - Pridat uzivatela
                        [2] - Vymazat uzivatela
                        [3] - Vypis uzivatelov
                        [4] - Vypis administratorov
                        [5] - Navrat do menu
                        """);

                int input = Integer.parseInt(scanner.nextLine().trim());
                switch (input) {
                    case 1 -> addUserMenu();
                    case 2 -> deleteUserAdminMenu();
                    case 3 -> {
                        do {
                            listOfUsersMenu();
                        } while (!back);
                        back = false;
                    }
                    case 4 -> {
                        do {
                            listOfAdminsMenu();
                        } while (!back);
                        back = false;
                    }
                    case 5 -> active = false;
                    default -> System.out.println("Zadaj cislo podla legendy!");
                }
            } while (active);
        }
    }

    public void mainMenu() {
        while (userService.isAdmin() || userService.isUser()) {
            System.out.printf("""
                    Vitaj, %s %s.
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    [1] - Pridat zaznam
                    [2] - Zobrazit zaznamy
                    [3] - Vyhladat zaznam
                    [4] - Vymazat zaznam
                                    
                    [5] - Odhlasit
                    [6] - Admin menu
                                    
                    [7] - Ukoncit program
                                    
                    [8] - Vytvorit test dtb
                    """, session[1], session[0]);
            switch (Integer.parseInt(scanner.nextLine().trim())) {
                case 1 -> {
                    do {
                        addClientMenu();
                    } while (!back);
                    back = false;
                }
                case 2 -> {
                    do {
                        listClientMenu();
                    } while (!back);
                    back = false;
                }
                case 3 -> searchClientMenu();
                case 4 -> {
                    do {
                        deleteClientMenu();
                    } while (!back);
                    back = false;
                }
                case 5 -> logoutMenu();
                case 6 -> {
                    active = true;
                    while (active) {
                        adminMenu();
                    }
                }
                case 7 -> userService.logout();
                case 8 -> clientService.testSubjects();
                default -> System.out.println("Zadaj cislo podla legendy!");
            }
        }
    }

    public void welcome() {
        back = false;
        while (!back) {
            System.out.println("""
                                        
                                        
                    Evidencia poistencov - jednoducha verzia.
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                    Prepracovana konzolova aplikacia, povodne ako projekt ku
                    zaverecnej skuske IT network.
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                                        
                                        
                    Na prve spustenie treba vytvorit uzivatela s admin pravami.
                    """);
            System.out.println("[Enter] - pokracovat");
            if (scanner.nextLine().equals("[press any key to continue]")) {
                back = true;
            } else {
                back = true;
            }
        }
    }
}
