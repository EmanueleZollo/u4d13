package Emanuele.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
    private Persona person;
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Partecipazione() {}

    public Partecipazione(Persona person, Evento evento, Status status) {
        this.person = person;
        this.evento = evento;
        this.status = status;
    }

    public long getId() {
        return id;
    }


    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", person=" + person +
                ", evento=" + evento +
                ", status=" + status +
                '}';
    }
}
