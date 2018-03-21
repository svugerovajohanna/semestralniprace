package com.github.svugerovajohanna.semestralniprace.logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
public class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Dovednosti dovednosti;
    private Kapsa kapsa;
    private Hra hra;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     *  @param hra, která práve probíhá
     */    
    public PrikazJdi(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.kapsa = plan.getKapsa();
        this.dovednosti = plan.getDovednosti();
        this.hra = hra;

    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);
        String text = null;

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        }
        else {
            if((sousedniProstor.getNazev().equals("mistnost_s_Chloupkem")) && !(plan.getDovednosti().obsahujeDovednost("umíš_alahomora")) )  {
                return "Dvěře jsou zamčené, neumíš je odemknout!";
            }
            else{
                plan.setAktualniProstor(sousedniProstor);
                text = plan.proverPruchod(sousedniProstor);
                if(text != null){
                    hra.setKonecHry(true);
                    return text;
                }
                else{
                    if(sousedniProstor.getPotom()!= null){
                        return sousedniProstor.dlouhyPopis()+ "\n" + sousedniProstor.getPotom();

                    }
                    return sousedniProstor.dlouhyPopis();
                }
            }
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
