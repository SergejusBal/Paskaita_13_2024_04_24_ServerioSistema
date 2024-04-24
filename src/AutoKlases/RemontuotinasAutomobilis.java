package AutoKlases;

import java.time.LocalDate;

public class RemontuotinasAutomobilis extends Automobilis {

    private String defektai;
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
}
