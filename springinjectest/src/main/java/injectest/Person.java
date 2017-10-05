package injectest;

import java.util.Date;

import org.springframework.stereotype.Component;

public class Person {

    String nachname;

    String vorname;

    Date geburtsDatum;

    public Person() {
        System.out.println(this.getClass().getName()+": default constructor");
    }

    @Override
    public String toString() {
        return "Person{" +
                "nachname='" + nachname + '\'' +
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

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
