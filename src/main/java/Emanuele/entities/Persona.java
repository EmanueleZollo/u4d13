package Emanuele.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public class Persona {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String mail;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private List<Partecipazione> attendingList;

    public Persona() {}

    public Persona(String name, String surname, String mail, LocalDate birthday, Gender gender, List<Partecipazione> attendingList) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.birthday = birthday;
        this.gender = gender;
        this.attendingList = attendingList;
    }

    public long getId() {
        return id;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Partecipazione> getAttendingList() {
        return attendingList;
    }

    public void setAttendingList(List<Partecipazione> attendingList) {
        this.attendingList = attendingList;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", attendingList=" + attendingList +
                '}';
    }
}
