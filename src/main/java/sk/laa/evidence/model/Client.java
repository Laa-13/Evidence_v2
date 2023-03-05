package sk.laa.evidence.model;

import sk.laa.evidence.enumeration.Gender;

import java.util.Objects;

public class Client {
    private String name;
    private String surname;
    private Integer age;
    private Gender gender;
    private String email;
    private Integer tel;

    public Client(String name, String surname, Integer age, Gender gender, String email, Integer tel) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(age, client.age) && gender == client.gender && Objects.equals(email, client.email) && Objects.equals(tel, client.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, gender, email, tel);
    }

    @Override
    public String toString() {
        String tableForm = "%-10S %-12S ; pohlavie: %-5s ; vek: %-3d ; email: %-17s ; tel: %-15d";
        return String.format(tableForm, name, surname, gender, age, email, tel);
    }
}
