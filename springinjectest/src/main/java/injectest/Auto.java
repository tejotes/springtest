package injectest;

public class Auto {

    String kennzeichen;

    String hersteller;

    public Auto() {
        System.out.println(this.getClass().getName()+": default constructor");
    }

    @Override
    public String toString() {
        return "Auto{" +
                "kennzeichen='" + kennzeichen + '\'' +
                ", hersteller='" + hersteller + '\'' +
                '}';
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
}
