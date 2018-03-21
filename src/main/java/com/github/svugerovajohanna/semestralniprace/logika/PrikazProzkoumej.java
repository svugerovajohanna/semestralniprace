/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;



/*******************************************************************************
 * Třída PrikazProzkoumej implementuje přikaz seber pro jednoduchou textovou hru.
 *
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class PrikazProzkoumej implements IPrikaz
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    private static final String NAZEV = "prozkoumej";
    private HerniPlan plan;
    //\CV== VARIABLE CLASS (STATIC) ATTRIBUTES (FIELDS) ============================


    //##############################################################################
    //\CI== STATIC INITIALIZER (CLASS CONSTRUCTOR) =================================
    //\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
    //\CM== OTHER NON-PRIVATE CLASS (STATIC) METHODS ===============================
    //\CP== PRIVATE AND AUXILIARY CLASS (STATIC) METHODS ===========================


    //##############################################################################
    //\IC== CONSTANT INSTANCE ATTRIBUTES (FIELDS) ==================================
    //\IV== VARIABLE INSTANCE ATTRIBUTES (FIELDS) ==================================


    //##############################################################################
    //\II== CONSTRUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Konstruktor třídy 
     * 
     * @param plan, ve kterém se bude příkaz používat
     */
    public PrikazProzkoumej(HerniPlan plan) {
        this.plan = plan;
    }


    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     *  Provádí příkaz "prozkoumej". Znovu vypíše v jaké místnsoti se hráč právě nachází,
     *  východy z místnosti a předměty a postavy v ní obsažené.
     *  Bez parametrů
     *
     *
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {

        Prostor aktualniProstor = plan.getAktualniProstor();

        return "Jsi v mistnosti/prostoru " + aktualniProstor.getPopis() + ".\n" 
        + aktualniProstor.popisVychodu()+ "\n"
        + aktualniProstor.popisVeci() + "\n"
        + aktualniProstor.popisOsob();
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
    //\IP== PRIVATE AND AUXILIARY INSTANCE METHODS =================================


    //##############################################################################
    //\NT== NESTED DATA TYPES ======================================================
}
