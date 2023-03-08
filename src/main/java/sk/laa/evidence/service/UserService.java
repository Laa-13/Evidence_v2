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

    public String saveUser(String userName, String password) {
        return userDtb.put(userName, password);
    }

    public String saveAdmin(String userName, String password) {
        return adminDtb.put(userName, password);
    }

    public String deleteUser(String userName) {
        return userDtb.remove(userName);
    }

    public String deleteAdmin(String userName) {
        return adminDtb.remove(userName);
    }

    public void listOfUsers() {
        userDtb.forEach((k, v) -> System.out.println((k + " : " + v)));
    }

    public void listOfAdmins() {
        adminDtb.forEach((k, v) -> System.out.println((k + " : " + v)));
    }

    public boolean findUser(String name) {
        return userDtb.containsKey(name);
    }

    public boolean findAdmin(String name) {
        return adminDtb.containsKey(name);
    }

    public boolean login(String userName, String password) {
        if (adminDtb.containsKey(userName) && password.equals(adminDtb.get(userName))) {
            return isAdmin = true;
        }
        if (userDtb.containsKey(userName) && password.equals(userDtb.get(userName))) {
            return isUser = true;
        }
        return false;
    }

    public void logout() {
        isUser = false;
        isAdmin = false;
    }

}
