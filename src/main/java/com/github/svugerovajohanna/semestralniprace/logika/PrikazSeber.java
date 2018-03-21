/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.svugerovajohanna.semestralniprace.logika;

/*******************************************************************************
 * Třída PrikazSeber implementuje pro hru příkaz seber.
 * Tato třída je součást jednoduché textové hry.
 * Příkaz sebere zadanou věc z aktuálního prostoru, vloží ji do kapsy a vymaže z aktuálního prostoru.
 * 
 *
 * @author    Johanna Švugerová
 * @version   školní rok 2016/2017
 */
public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Kapsa kapsa;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře sbírat předměty
     *  @param kapsa, do které se budou ukládat sebrané příkazy
     */    
    public PrikazSeber(HerniPlan plan, Kapsa kapsa) {
        this.plan = plan;
        this.kapsa = plan.getKapsa();
    }

    /**
     *  Provádí příkaz "seber". Zkouší se sebrat zadaný předmět ze zadaného prostoru. Pokud 
     *  je předmět v daném prostoru, předmět se vloží do kapsy a smaže z aktuálního prosotru.
     *  Pokud zadaný předmět v místnost není nebo je překročená kapacita kapsy, vypíše se chybové hlášení
     *
     *@param parametry - jako  parametr obsahuje jméno věci, která se má sebrat
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {

            return "Co mám sebrat? Musíš zadat název věci";
        }

        String nazevVeci = parametry[0];

        Prostor aktualniProstor = plan.getAktualniProstor();
        //potrebujes i batoh
        Vec sbirana = aktualniProstor.odeberVec(nazevVeci);
        if (sbirana == null) {
            return "To tu není!";
        }
        else {
            if(sbirana.jePrenositelna()){
                return kapsa.pridejDoKapsy(sbirana);
            }
            else{
                aktualniProstor.vlozVec(sbirana);
                return "To nezvedneš"; 
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
