package Klientai;

public class VersloKlientas extends Klientas{
    private String ImonesPavadinimas;
    private String PVMMoketojoKodas;

    public VersloKlientas() {
    }

    public String getImonesPavadinimas() {
        return ImonesPavadinimas;
    }

    public String getPVMMoketojoKodas() {
        return PVMMoketojoKodas;
    }

    public void setImonesPavadinimas(String imonesPavadinimas) {
        ImonesPavadinimas = imonesPavadinimas;
    }

    public void setPVMMoketojoKodas(String PVMMoketojoKodas) {
        this.PVMMoketojoKodas = PVMMoketojoKodas;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Klientas klientas = (Klientas) object;
        return super.getId() == klientas.getId();
    }

    @Override
    public int hashCode() {
        return super.getId();
    }
}


