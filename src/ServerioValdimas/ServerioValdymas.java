package ServerioValdimas;

import AutoKlases.Automobilis;
import Klientai.Klientas;

import java.util.List;
import java.util.Map;

public interface ServerioValdymas {
    void registruotiNaujaAutomobiliRemontui(Klientas klientas, Automobilis automobilis);
    Automobilis suteiktiPakaitini();
    Map<Klientas, Automobilis> gautiVisąRemontuojamuAutoSarasa();
    Automobilis grazintiKlientuiSuremontuota(Klientas klientas);
}
