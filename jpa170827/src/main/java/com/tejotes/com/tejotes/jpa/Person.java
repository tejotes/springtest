package com.tejotes.com.tejotes.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String vorname;

    Date geburtsDatum;

    protected Person() {
        // ntd
    }

    public Person(String name, String vorname, Date geburtsDatum) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsDatum = geburtsDatum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", geburtsDatum=" + geburtsDatum +
                '}';
    }

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Long getId() {
        return id;
    }
}
