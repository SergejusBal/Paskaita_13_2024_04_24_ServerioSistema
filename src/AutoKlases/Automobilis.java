package AutoKlases;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Automobilis {
    private String marke;
    private String modelis;
    private int metai;
    private KuroTipas kuroTipas;

    public Automobilis(){}
    public Automobilis(String marke, String modelis, int metai, KuroTipas kuroTipas) {
        this.marke = marke;
        this.modelis = modelis;
        this.metai = metai;
        this.kuroTipas = kuroTipas;
    }

    public String getMarke() {
        return marke;
    }

    public String getModelis() {
        return modelis;
    }

    public int getLocalDate() {
        return metai;
    }

    public KuroTipas getKuroTipas() {
        return kuroTipas;
    }

    public void setMarke(String marke) {
        marke = marke;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public void setmetai(int metai) {
        this.metai = metai;
    }

    public void setKuroTipas(KuroTipas kuroTipas) {
        this.kuroTipas = kuroTipas;
    }

    public Automobilis parseCSV(String string){
        Automobilis automobilis = new Automobilis();
        String[] vertes = string.split(",");
        automobilis.setMarke(vertes[0]);
        automobilis.setModelis(vertes[1]);
        try {
            automobilis.setmetai(Integer.parseInt(vertes[2]));
            automobilis.setKuroTipas(KuroTipas.valueOf(vertes[3]));
        }catch(InputMismatchException e){
            System.out.println("Ivyko klaida, Automobilis nera priskirtas");
            return null;
        }

        return automobilis;
    }

    @Override
    public String toString() {
        return  "Marke: " + this.marke + " **** " +
                "Modelis: " + this.modelis + " **** " +
                "Metai: " + this.metai + " **** " +
                "Kuro tipas: " + this.kuroTipas; }

    public String toCSVString(){
        return String.format("%s,%s,%d,%s", this.marke, this.modelis,this.metai,this.kuroTipas.name());

    }
}
