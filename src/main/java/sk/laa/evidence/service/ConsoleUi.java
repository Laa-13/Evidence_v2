package sk.laa.evidence.service;

import sk.laa.evidence.enumeration.Gender;
import sk.laa.evidence.model.Client;

import java.util.Scanner;

public class ConsoleUi {
    Scanner scanner = new Scanner(System.in);
    private final ClientService clientService;
    private final UserService userService;

    public ConsoleUi(ClientService clientService, UserService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }

    public Gender enumSwitch(int input) {
        while ((input < 1) || (input > 2)) {
            System.out.println("Pohlavie: [1] = muz , [2] = zena");
            input = Integer.parseInt(scanner.nextLine());
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
        System.out.println("Zadaj meno:");
        String name = scanner.nextLine().trim();
        System.out.println("Zadaj priezvisko:");
        String surname = scanner.nextLine().trim();
        System.out.println("Zadaj vek:");
        int age = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Pohlavie: [1] = muz , [2] = zena");
        Gender gender = enumSwitch(Integer.parseInt(scanner.nextLine()));
        System.out.println("Zadaj email:");
        String email = scanner.nextLine().trim();
        System.out.println("Zadaj telefon");
        int tel = Integer.parseInt(scanner.nextLine());
        clientService.save(name, surname, age, gender, email, tel);
        System.out.println("Zaznam pridany :\n" + clientService.lastSaved());
    }

    public void deleteClientMenu() {
        Client[] deleted = new Client[1];
        clientService.list();
        System.out.println("Zadaj ID zaznamu na vymazanie:");
        int input = Integer.parseInt(scanner.nextLine());
        deleted[0] = clientService.findById(input);
        clientService.delete(input);
        System.out.println("Zaznam vymazany:\n" + deleted[0]);
        deleted[0] = null;
    }

    public void listClientMenu() {
        clientService.list();
    }

    public void searchClientByNameMenu() {
        System.out.println("Zadaj meno klienta:");
        clientService.findByName(scanner.nextLine().trim().toLowerCase());
    }

    public void searchClientBySurameMenu() {
        System.out.println("Zadaj priezvisko klienta:");
        clientService.findBySurname(scanner.nextLine().trim().toLowerCase());
    }

    public void searchClientByEmailMenu() {
        System.out.println("Zadaj meno klienta:");
        clientService.findByEmail(scanner.nextLine().trim().toLowerCase());
    }

    public void searchClientByTelMenu() {
        System.out.println("Zadaj meno klienta:");
        clientService.findByTel(Integer.parseInt(scanner.nextLine().trim().toLowerCase()));
    }

    public void searchClientMenu() {
        System.out.println("""
                Vyhladam zaznam podla:
                
                [1] - mena
                [2] - priezviska
                [3] - emailu
                [4] - tel.cisla
                
                """);
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1 -> searchClientByNameMenu();
            case 2 -> searchClientBySurameMenu();
            case 3 -> searchClientByEmailMenu();
            case 4 -> searchClientByTelMenu();
        }
    }

    public void mainMenu() {
        System.out.println("""
                Zvol si akciu:
                [1] - Pridat zaznam
                [2] - Zobrazit zaznamy
                [3] - Vyhladat zaznam
                [4] - Vymazat zaznam
                
                [5] - Odhlasit
                [6] - Admin menu
                
                [7] - Ukoncit program
                
                [8] - Vytvorit test dtb
                """);
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1 -> addClientMenu();
            case 2 -> listClientMenu();
            case 3 -> searchClientMenu();
            case 4 -> deleteClientMenu();
            case 5 -> {
                //odhlasit
            }
            case 6 -> {
                //adminmenu
            }
            case 7 -> userService.logout();
            case 8 -> clientService.testSubjects();
        }
    }
}
