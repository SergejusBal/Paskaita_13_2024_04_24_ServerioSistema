package AutoKlases;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class PakaitinisAutomobilis extends Automobilis{

    private int rida;

    public  PakaitinisAutomobilis(){}
    public PakaitinisAutomobilis(String marke, String modelis, int metai, KuroTipas kuroTipas, int rida) {
        super(marke, modelis, metai, kuroTipas);
        this.rida = rida;
    }

    public int getRida() {
        return rida;
    }
    public void setRida(int rida) {
        this.rida = rida;
    }
    @Override
    public Automobilis parseCSV(String string){
        PakaitinisAutomobilis automobilis = new PakaitinisAutomobilis();
        String[] vertes = string.split(",");
        automobilis.setMarke(vertes[0]);
        automobilis.setModelis(vertes[1]);
        try {
            automobilis.setmetai(Integer.parseInt(vertes[2]));
            automobilis.setKuroTipas(KuroTipas.valueOf(vertes[3]));
            automobilis.setRida(Integer.parseInt(vertes[4]));
        }catch(InputMismatchException e){
            return null;
        }
        return automobilis;
    }
    @Override
    public String toCSVString(){
        return String.format("%s,%s,%d,%s,%d", super.getMarke(), super.getModelis(),super.getLocalDate(),super.getKuroTipas().name(), this.rida);
    }
}
