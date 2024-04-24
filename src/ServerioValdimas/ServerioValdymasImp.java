package ServerioValdimas;

import AutoKlases.Automobilis;
import AutoKlases.PakaitinisAutomobilis;
import Custom.Custom;

import java.util.List;
import java.util.Random;

public class ServerioValdymasImp implements ServerioValdymas {

    private static String TAISYKLOS_AUTO_PATH = "C:/Users/Sergejus/IdeaProjects/Paskaita_13_2024_04_24_ServerioSistema/src/Resources/PakaitiniaiAutomobiliai.csv";
    private static String KLIENTAI_JU_AUTO_PATH = "C:/Users/Sergejus/IdeaProjects/Paskaita_13_2024_04_24_ServerioSistema/src/Resources/KlientaiIrJuAuto.csv";
    private static String REMONTO_ISTORIJA_PATH = "C:/Users/Sergejus/IdeaProjects/Paskaita_13_2024_04_24_ServerioSistema/src/Resources/SuremontuotuAutomobiliuIstorija.csv";

    private List<Automobilis> remontuojamuAutomobiliuSarasas;

    public ServerioValdymasImp(){
    }

    public void paleistiUI(){


    }

    @Override
    public void registruotiNaujaAutomobiliRemontui(Automobilis automobilis) {
        remontuojamuAutomobiliuSarasas.add(automobilis);
    }

    @Override
    public Automobilis suteiktiPakaitini() {
        List<String> pakaitiniaiAutomobiliai = Custom.nuskaitytiFaila(TAISYKLOS_AUTO_PATH);

        if(pakaitiniaiAutomobiliai.isEmpty()){
            System.out.println("Laisvu automobiliu nera");
            return null;
        }

        Random random = new Random();

        int randomVerte;
        if(pakaitiniaiAutomobiliai.size() == 1) randomVerte = 0;
        else randomVerte = random.nextInt(0,pakaitiniaiAutomobiliai.size()-1);

        String automobilisString = pakaitiniaiAutomobiliai.get(randomVerte);

        Automobilis automobilis = new PakaitinisAutomobilis();
        automobilis.parseCSV(automobilisString);

        Custom.pasalintiEilute(randomVerte,TAISYKLOS_AUTO_PATH);

        if (automobilis == null){
            System.out.println("Ivyko klaida. Bandoma dar karta!");
            suteiktiPakaitini();
        }
        return automobilis;

    }

    @Override
    public List<Automobilis> gautiVisąRemontuojamuAutoSarasa() {
        return remontuojamuAutomobiliuSarasas;
    }

    @Override
    public void grazintiKlientuiSuremontuota(Automobilis automobilis) {

    }

    private void pridetiKlientoAutomobili(){

    }


}
