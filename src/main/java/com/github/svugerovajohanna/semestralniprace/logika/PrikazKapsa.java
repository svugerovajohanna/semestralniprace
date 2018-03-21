/* UTF-8 codepage: Příliš žluťoučký ků�? úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-�?�
 */
package com.github.svugerovajohanna.semestralniprace.logika;



/*******************************************************************************
 * Třída Kapsa implementuje pro hru příkaz Kapsa, který vypíše obsah kapsy.
 *
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class PrikazKapsa implements IPrikaz
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    private static final String NAZEV = "kapsa";
    private HerniPlan plan;
    private Kapsa kapsa;

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
     * Konstuktor třídy.
     * 
     * @param plan ve kterém se provede příkaz kapsa
     * @param kapsa - seznam věcí, které u sebe má hráč
     */
    public PrikazKapsa(HerniPlan plan, Kapsa kapsa)
    {
        this.plan = plan;
        this.kapsa = plan.getKapsa();
    }


    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     * Provádí příkaz "kapsa". Vypíše obsah kapsy. Pokud je kapsa prázdná, vypíše
     * příslušný text.
     *
     *Bez parametrů.
     *
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {

        String vracenyText = kapsa.kapsaObsahuje();
        if(vracenyText == null){
            return "Kapsa je prázdná!";
        }
        return "Harryho kapsa obsahuje" + vracenyText;
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
