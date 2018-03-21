/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;

/*******************************************************************************
 * Třída PrikazDovednosti implementuje příkaz dovednosti pro jednoduchou textovou hru.
 * Příkaz vypíše, jaké má hráč momentálně dovednosti.
 *
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class PrikazDovednosti implements IPrikaz
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    public static final String NAZEV = "dovednosti";
    public HerniPlan plan;
    public Dovednosti dovednosti;
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
     * Konstruktor třídy.
     *
     *@param plan, ve kterém je příkaz proveden
     *@param dovednosti - seznam dovedností, které hráč získal
     */
    public PrikazDovednosti(HerniPlan plan, Dovednosti dovednosti)
    {
        this.plan = plan;
        this.dovednosti = plan.getDovednosti();
    }


    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     *  Provádí příkaz "dovednosti". Příkaz vypíše, jaké dovednosti hráč získal
     *  a vypíše je na obrazovku. Pokud je seznam dovednosti prázdný, dá o tom hráči zprávu.
     *
     *Bez parametrů.
     *
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        String vracenyText = dovednosti.seznamDovednosti();
        if(vracenyText.equals("")){
            return "Harry zatím nic neumí.";
        }
        return "Tvoje dovednosti jsou:" + vracenyText;
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
