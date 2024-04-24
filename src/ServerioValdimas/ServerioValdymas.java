package ServerioValdimas;

import AutoKlases.Automobilis;

import java.util.List;

public interface ServerioValdymas {
    void registruotiNaujaAutomobiliRemontui(Automobilis automobilis);
    Automobilis suteiktiPakaitini();
    List<Automobilis> gautiVisąRemontuojamuAutoSarasa();
    Automobilis grazintiKlientuiSuremontuota(Automobilis automobilis);
}
