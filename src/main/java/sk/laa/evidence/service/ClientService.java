package sk.laa.evidence.service;

import sk.laa.evidence.enumeration.Gender;
import sk.laa.evidence.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final List<Client> clientDtb = new ArrayList<>();

    /**
     * pridanie objektu Client do arraylistu
     *
     * @param name    constructor objektu Client = parameter name
     * @param surname constructor objektu Client = parameter surname
     * @param age     constructor objektu Client = parameter age
     * @param gender  constructor objektu Client = parameter gender
     * @param email   constructor objektu Client = parameter email
     * @param tel     constructor objektu Client = parameter tel
     * @return proces pridania .add()
     */
    public boolean save(String name, String surname, Integer age, Gender gender, String email, Integer tel) {
        return clientDtb.add(new Client(name, surname, age, gender, email, tel));
    }

    /**
     * odstranenie objektu Client z arraylistu
     *
     * @param id index na vymazanie
     * @return proces odstranenia .remove()
     */
    public Client delete(int id) {
        return clientDtb.remove(id - 1);
    }

    /**
     * zmena uz existujuceho objektu Client v arrayliste
     *
     * @param id      zmena na zaklade indexu
     * @param name    nova hodnota podla parametru constructora name
     * @param surname nova hodnota podla parametru constructora surname
     * @param age     nova hodnota podla parametru constructora age
     * @param gender  nova hodnota podla parametru constructora gender
     * @param email   nova hodnota podla parametru constructora email
     * @param tel     nova hodnota podla parametru constructora tel
     * @return proces zmeny .set()
     */
    public Client update(int id, String name, String surname, Integer age, Gender gender, String email, Integer tel) {
        return clientDtb.set(id, new Client(name, surname, age, gender, email, tel));
    }

    /**
     * metoda na navrat posledneho pridaneho objektu Client do arraylistu
     *
     * @return navrat objektu s poslednym id v arrayliste .get()
     */
    public Client lastSaved() {
        return clientDtb.get(clientDtb.size() - 1);
    }

    /**
     * metoda na vymazanie posledneho elementu vlozeneho do arraylistu
     *
     * @return odstrani element s poslednym indexom .remove()
     */
    public Client deleteLast() {
        return clientDtb.remove(clientDtb.size() - 1);
    }

    /**
     * preiterovanie arraylistom a vypis vsetkych objektov v nom ulozenych.
     * ku kazdemu je priradene ID, co je vlastne iba index objektu + 1
     */
    public void list() {
        for (int i = 0; i <= (clientDtb.size() - 1); i++) {
            System.out.println("ID:\t" + (i + 1) + " | " + clientDtb.get(i));
        }
    }

    /**
     * vyhladanie konkretneho objektu ulozeneho v arrayliste na zaklade jeho indexu
     *
     * @param id parameter urcujuci index hladaneho objektu
     * @return proces najdenia .get()
     */
    public Client findById(int id) {
        return clientDtb.get(id - 1);
    }

    /**
     * nasledujuce metody vyuzivaju stream, kde
     * .filter - hlada pomocou gettera v objekte elementy,
     * .startsWith - na zaklade podmientky z query ktore nasledne
     * .tolist - vytiahne do listu ktory
     * .foreach - preiteruje a vypise do konzole
     *
     * @param query parameter udavajuci podmienku filtrovania
     */
    public void findByName(String query) {
        clientDtb.stream()
                .filter(client -> client.getName().toLowerCase().startsWith(query))
                .toList()
                .forEach(System.out::println);
    }

    public void findBySurname(String query) {
        clientDtb.stream()
                .filter(client -> client.getSurname().toLowerCase().startsWith(query))
                .toList()
                .forEach(System.out::println);
    }

    public void findByEmail(String query) {
        clientDtb.stream()
                .filter(client -> client.getEmail().toLowerCase().startsWith(query))
                .toList()
                .forEach(System.out::println);
    }

    public void findByTel(Integer query) {
        clientDtb.stream()
                .filter(client -> client.getTel().equals(query))
                .toList()
                .forEach(System.out::println);
    }

    public void testSubjects() {
        clientDtb.add(new Client("Janko", "Špánik", 20, Gender.Muz, "janko@mail.sk", 123456789));
        clientDtb.add(new Client("Gabriela", "Úžasná", 19, Gender.Zena, "gabriela@mail.sk", 435892743));
        clientDtb.add(new Client("Radek", "Pytón", 18, Gender.Muz, "radek@mail.co.uk", 759836829));
        clientDtb.add(new Client("Milda", "Kotlík", 18, Gender.Muz, "milda@mail.co.uk", 989321234));
        clientDtb.add(new Client("Jozef", "Brokolica", 42, Gender.Muz, "jozef@mail.sk", 759473409));
        clientDtb.add(new Client("Romana", "Stratená", 19, Gender.Zena, "romana@mail.sk", 489384002));
        clientDtb.add(new Client("Boris", "Britva", 51, Gender.Muz, "boris@mail.sk", 338924850));
        clientDtb.add(new Client("Klaudia", "Ostrá", 16, Gender.Zena, "klaudia@mail.sk", 994012012));
        clientDtb.add(new Client("Martina", "Neverná", 18, Gender.Zena, "martina@mail.sk", 743002232));
        clientDtb.add(new Client("Pegy", "Nestabilná", 17, Gender.Zena, "pegy@mail.sk", 840378448));
        clientDtb.add(new Client("Sergej", "Britva", 53, Gender.Muz, "sergej@mail.sk", 490487443));
        clientDtb.add(new Client("Kristina", "Obláčiková", 18, Gender.Zena, "kristina@mail.sk", 478477421));
        clientDtb.add(new Client("Brandon", "Walsh", 74, Gender.Muz, "brandon@mail.sk", 902100000));
        clientDtb.add(new Client("Arnold", "Terminátor", 81, Gender.Muz, "arnold@mail.sk", 644203345));
        clientDtb.add(new Client("James", "Bond", 61, Gender.Muz, "007@mail.sk", 777007007));
        clientDtb.add(new Client("Eliška", "Zdravá", 16, Gender.Zena, "eliska@mail.sk", 843234054));
        clientDtb.add(new Client("Ondrej", "Ďalší", 35, Gender.Muz, "pernik@mail.sk", 393939393));
        clientDtb.add(new Client("Maggie", "Opilá", 13, Gender.Zena, "maggie@mail.sk", 760443876));
        clientDtb.add(new Client("Peter", "Labilný", 30, Gender.Muz, "peter@mail.sk", 859403456));
        clientDtb.add(new Client("Kitty", "Drzá", 13, Gender.Zena, "kitty@mail.sk", 757484943));
        clientDtb.add(new Client("Peter", "Ďalší", 78, Gender.Muz, "peter.next@mail.sk", 753008751));
        clientDtb.add(new Client("Gunter", "Kominár", 54, Gender.Muz, "gunter@mail.sk", 879684032));
    }

}
