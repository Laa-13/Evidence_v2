package sk.laa.evidence.service;

import java.util.HashMap;

public class UserService {
    private boolean isUser = false;
    private boolean isAdmin = false;
    private final HashMap<String, String> userDtb = new HashMap<>();
    private final HashMap<String, String> adminDtb = new HashMap<>();

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
    public boolean checkPassword(String userName, String password) {
        if(userDtb.containsKey(userName) && password.equals(userDtb.get(userName))) {
            return isUser = true;
        }
        if (adminDtb.containsKey(userName) && password.equals(adminDtb.get(userName))) {
            return isAdmin = true;
        }
        return false;
    }
    public void logout() {
        isUser = false;
        isAdmin = false;
    }

}
