package AutoKlases;

import java.time.LocalDate;

public class RemontuotinasAutomobilis extends Automobilis {

    private String defektai;
    public RemontuotinasAutomobilis(){}
    public RemontuotinasAutomobilis(String marke, String modelis, int metai, KuroTipas kuroTipas, String defektai) {
        super(marke, modelis, metai, kuroTipas);
        this.defektai = defektai;
    }

    public String getDefektai() {
        return defektai;
    }

    public void setDefektai(String defektai) {
        this.defektai = defektai;
    }

    @Override
    public String toCSVString(){
        return String.format("%s,%s,%d,%s,%s", super.getMarke(), super.getModelis(),super.getLocalDate(),super.getKuroTipas().name(), this.defektai);
    }

}
