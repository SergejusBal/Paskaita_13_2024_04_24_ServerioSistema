package ServerioValdimas;

import AutoKlases.Automobilis;
import AutoKlases.KuroTipas;
import AutoKlases.PakaitinisAutomobilis;
import AutoKlases.RemontuotinasAutomobilis;
import Custom.Custom;
import Klientai.Klientas;
import Klientai.VersloKlientas;

import java.util.*;

public class ServerioValdymasImp implements ServerioValdymas {

    private static String TAISYKLOS_AUTO_PATH = "C:/Users/Serge/IdeaProjects/Paskaita_13_2024_04_24_ServerioSistema/src/Resources/PakaitiniaiAutomobiliai.csv";
    private static String KLIENTAI_JU_AUTO_PATH = "C:/Users/Serge/IdeaProjects/Paskaita_13_2024_04_24_ServerioSistema/src/Resources/KlientaiIrJuAuto.csv";
    private static String REMONTO_ISTORIJA_PATH = "C:/Users/Serge/IdeaProjects/Paskaita_13_2024_04_24_ServerioSistema/src/Resources/SuremontuotuAutomobiliuIstorija.csv";

    private Map<Klientas, Automobilis> remontuojamuAutomobiliuSarasas;

    public ServerioValdymasImp(){
        remontuojamuAutomobiliuSarasas = new HashMap<>();
    }

    public void paleistiUI(){

        Klientas klientas = gautiKleinta();



//
//
//        System.out.println("Ar norite taisyti automobili? (T/N)");
//        if(!Custom.TaipNeBooleanCon()) {
//            System.out.println("Viso gero!");
//            System.exit(0);
//        }
//        int index;
//        for(index = 0; index < klientas.getKlientoAutomobiliuSaraas().size(); index++ ){
//            System.out.println(((index + 1) + ". " + klientas.getKlientoAutomobiliuSaraas().get(index)));
//        }
//
//        System.out.println("Pasirinkite Automobilio eiles numeri remomtui:");
//        while(true){
//            int nuskVerte = Custom.nuskaitytiIntVerteCon();
//            if (nuskVerte <= (index + 1) && nuskVerte >= 1){
//                break;
//            }
//        }
//        System.out.println("Iveskite automobilio defekta:");
//        String defektas = Custom.nuskaitytiStringVerteCon();
//        Automobilis automobilis = klientas.getKlientoAutomobiliuSaraas().get(index-1);
//        ((RemontuotinasAutomobilis) automobilis).setDefektai(defektas);
//        registruotiNaujaAutomobiliRemontui(automobilis);
//        klientas.getKlientoAutomobiliuSaraas().remove(index-1);
//        System.out.println("Automobilis Uzregistruotas.");
//
//        Automobilis pakaitinisAutomobilis = suteiktiPakaitini();
//        klientas.setAutomobilis((PakaitinisAutomobilis) pakaitinisAutomobilis);
//
//        System.out.println("Suteiktas pakaitinis automobilis:");
//        System.out.println(pakaitinisAutomobilis);
//
//        while(true){
//            System.out.println("Ar norite paimti sutaisyta automobili? (T/N)");
//            if(Custom.TaipNeBooleanCon()){
//                break;
//            }
//        }
//
//        grazintiPakaitiniAuto(klientas.getAutomobilis());
//        //grazintiKlientuiSuremontuota();
//
//        System.out.println("Auto");


    }

    @Override
    public void registruotiNaujaAutomobiliRemontui(Klientas klientas, Automobilis automobilis) {
        remontuojamuAutomobiliuSarasas.put(klientas,automobilis);
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

        return automobilis;

    }

    @Override
    public Map<Klientas,Automobilis> gautiVisąRemontuojamuAutoSarasa() {
        return remontuojamuAutomobiliuSarasas;
    }

    @Override
    public Automobilis grazintiKlientuiSuremontuota(Klientas klientas) {
        return remontuojamuAutomobiliuSarasas.get(klientas);
    }

    public void irasytiAutoIAutoIstorija(Automobilis automobilis){
        Custom.irasytiEiluteIFaila(automobilis.toCSVString(),REMONTO_ISTORIJA_PATH);
    }

    public void grazintiPakaitiniAuto(Automobilis automobilis){
        Custom.irasytiEiluteIFaila(automobilis.toCSVString(),TAISYKLOS_AUTO_PATH);
    }

    private Klientas gautiKleinta(){
        List<String> KlientaiIrJuAuto = Custom.nuskaitytiFaila(KLIENTAI_JU_AUTO_PATH);

        System.out.println("Iveskite Kliento ID: ");
        int klientoID = Custom.nuskaitytiIntVerteCon();


        boolean rastasKlientas = false;
        Klientas klientas = null;

        for (String s : KlientaiIrJuAuto){
           String[] StringVertes = s.split(",");

           if (klientoID != Integer.parseInt(StringVertes[0])) continue;


           if (StringVertes.length == 8 && !rastasKlientas){
               klientas = new Klientas();
               rastasKlientas = true;
           }

           else if (StringVertes.length == 10 && !rastasKlientas){
               klientas = new VersloKlientas();
               rastasKlientas = true;
           }


           if (klientas instanceof VersloKlientas){
               klientas.setId(Integer.parseInt(StringVertes[0]));
               klientas.setVardas(StringVertes[1]);
               klientas.setPavarde(StringVertes[2]);
               klientas.setEmail(StringVertes[3]);
               klientas.setKlientoAutomobiliuSaraas(new Automobilis(StringVertes[4],StringVertes[5],Integer.parseInt(StringVertes[6]), KuroTipas.valueOf(StringVertes[7])));
               ((VersloKlientas)klientas).setImonesPavadinimas(StringVertes[8]);
               ((VersloKlientas)klientas).setPVMMoketojoKodas(StringVertes[9]);
           }
           else {
               klientas.setId(Integer.parseInt(StringVertes[0]));
               klientas.setVardas(StringVertes[1]);
               klientas.setPavarde(StringVertes[2]);
               klientas.setEmail(StringVertes[3]);
               klientas.setKlientoAutomobiliuSaraas(new Automobilis(StringVertes[4],StringVertes[5],Integer.parseInt(StringVertes[6]), KuroTipas.valueOf(StringVertes[7])));
           }
        }
        return klientas;
    }


}
