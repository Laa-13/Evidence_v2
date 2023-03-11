package sk.laa.evidence.service;

import java.util.HashMap;

public class UserService {
    private final HashMap<String, String> userDtb = new HashMap<>();
    private final HashMap<String, String> adminDtb = new HashMap<>();
    private boolean isUser = false;
    private boolean isAdmin = false;

    public boolean isUser() {
        return isUser;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * ulozi zadane hodnoty do hash mapy zhromazdujucej mena a hesla uzivatelov
     *
     * @param userName parameter prijme String reprezentujuci uzivatelske meno
     * @param password parameter prijme String reprezentujuci uzivatelske heslo k danemu menu
     * @return vlozi hodnoty z parametrov do hash mapy .put() kde key = meno a value = heslo
     */
    public String saveUser(String userName, String password) {
        return userDtb.put(userName, password);
    }

    /**
     * ulozi zadane hodnoty do hash mapy zhromazdujucej mena a hesla administratorov
     *
     * @param userName parameter prijme String reprezentujuci uzivatelske meno
     * @param password parameter prijme String reprezentujuci uzivatelske heslo k danemu menu
     * @return vlozi hodnoty z parametrov do hash mapy .put() kde key = meno a value = heslo
     */
    public String saveAdmin(String userName, String password) {
        return adminDtb.put(userName, password);
    }

    /**
     * vymaze z hash mapy key a value na zaklade zhody uzivatelskeho mena
     *
     * @param userName prijme String na zaklade ktoreho vyhlada key value na odstranenie
     * @return odstranenie key a value na zaklade zhody key z parametra funkcie .remove()
     */
    public String deleteUser(String userName) {
        return userDtb.remove(userName);
    }

    /**
     * vymaze z hash mapy key a value na zaklade zhody uzivatelskeho mena
     *
     * @param userName prijme String na zaklade ktoreho vyhlada key value na odstranenie
     * @return odstranenie key a value na zaklade zhody key z parametra funkcie .remove ()
     */
    public String deleteAdmin(String userName) {
        return adminDtb.remove(userName);
    }

    /**
     * metoda bez navratovej hodnoty, ktora vykona vypis z hash mapy reprezentujucej
     * uziatelske mena a hesla
     */
    public void listOfUsers() {
        userDtb.forEach((k, v) -> System.out.println((k + " : " + v)));
    }

    /**
     * metoda bez navratovej hodnoty, ktora vykona vypis z hash mapy reprezentujucej
     * administratorske mena a hesla
     */
    public void listOfAdmins() {
        adminDtb.forEach((k, v) -> System.out.println((k + " : " + v)));
    }

    /**
     * metoda na vyhladanine key na zaklade zhody zadaneho parametra
     *
     * @param name prijma String na vyhladanie key z mapy
     * @return filter key values
     */
    public boolean findUser(String name) {
        return userDtb.containsKey(name);
    }

    /**
     * metoda na vyhladanine key na zaklade zhody zadaneho parametra
     *
     * @param name prijma String na vyhladanie key z mapy
     * @return filter key values
     */
    public boolean findAdmin(String name) {
        return adminDtb.containsKey(name);
    }

    /**
     * metoda ktora simuluje prihlasenie uzivatela / administratora.
     * logika spociva v tom, ze hlavne programove menu na obsluhu je zacyklene iba v pripade,
     * ze boolean isUser, alebo isAdmin je nastaveny na true. jedina moznost, ako nastavit
     * zmienene booleany na hodnotu true je ak su zadane key a value, ktore uz existuju v mape.
     * metoda vykona kontrolu, ci sa parameter userName zhoduje s nejakym key z mapy a v pripade,
     * ze priradena value najdeneho key sa zhoduje s parametrom password, nastavi boolean na true
     *
     * @param userName parameter podla ktoreho sa hlada key v hash mape
     * @param password parameter podla ktoreho porovnava priradena value v najdenom key
     * @return boolean sa na true nenastavi, ak nie su splnene podienky uvedene vyssie
     */
    public boolean login(String userName, String password) {
        if (adminDtb.containsKey(userName) && password.equals(adminDtb.get(userName))) {
            return isAdmin = true;
        }
        if (userDtb.containsKey(userName) && password.equals(userDtb.get(userName))) {
            return isUser = true;
        }
        return false;
    }

    /**
     * tym, ze ovladacie menu programu je zacyklene pokial je nastaveny boolean na true,
     * logout uzivatela sa da vyriesit jednoduchym prepnutim booleanov na false.
     * po vyskoceni z cykla sa da zavolat metoda login na dalsie zacyklenie a pracu s menu
     */
    public void logout() {
        isUser = false;
        isAdmin = false;
    }
}