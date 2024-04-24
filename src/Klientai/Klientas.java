package Klientai;

import AutoKlases.Automobilis;
import AutoKlases.PakaitinisAutomobilis;

import java.util.ArrayList;
import java.util.List;

public class Klientas {
    private int id;
    private String vardas;
    private String pavarde;
    private String email;
    private PakaitinisAutomobilis automobilis;
    private List<Automobilis> klientoAutomobiliuSaraas;

    public Klientas() {
        klientoAutomobiliuSaraas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getEmail() {
        return email;
    }

    public Automobilis getAutomobilis() {
        return automobilis;
    }

    public List<Automobilis> getKlientoAutomobiliuSaraas() {
        return klientoAutomobiliuSaraas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAutomobilis(PakaitinisAutomobilis automobilis) {
        this.automobilis = automobilis;
    }

    public void setKlientoAutomobiliuSaraas(Automobilis automobilis) {
        this.klientoAutomobiliuSaraas.add(automobilis);
    }


}
