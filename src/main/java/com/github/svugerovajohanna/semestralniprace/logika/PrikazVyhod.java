/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;



/*******************************************************************************
 * Třida PrikazVyhod implemetuje prikaz vyhod pro jednoduchou textovou hru.
 * Příkaz vyhodí zadaný předmět z kapsy a umístí ho zpět do aktuálního prostoru
 *
 * @author  Johanna Švugerová
 * @version školí rok 2016/2017
 */
public class PrikazVyhod implements IPrikaz
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    private static final String NAZEV = "vyhod";
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
     * Konstruktor vytvářející třídu
     * 
     * @param plan, ve kterém se provádí příkaz vyhod
     * @kapsa, ze které se věci vyhazují
     */
    public PrikazVyhod(HerniPlan plan, Kapsa kapsa) {
        this.plan = plan;
        this.kapsa = plan.getKapsa();
    }


    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     *  Provádí příkaz "vyhod".Zkouší jestli je zadaný předmět v kapse, pokud ano 
     *  vyhodí ho z kapsy a umístí do prostoru, kde se hráč aktuálně nachází 
     *  a vypíše se hlášení o úspěšném provedení.
     *  Pokud daná věc v kapse není, vypíše se chybové hlášení.
     *  
     *@param parametry - jako  parametr obsahuje název věci, kterou chce hráč vyhodit
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {

            return "Co mám vyhodit z kapsy? Musíš zadat název věci";
        }

        String nazevVeci = parametry[0];

        Prostor aktualniProstor = plan.getAktualniProstor();
        Vec vyhazovana = kapsa.odeberZKapsy(nazevVeci); 
        if (vyhazovana == null) {
            return "Tuhle věc v kapse nemáš!";
        }
        else {

            aktualniProstor.vlozVec(vyhazovana);
            return "Harry vyhodil "+vyhazovana.getNazev()+ " z kapsy\na je právě v "
            +aktualniProstor.getPopis();

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

    //\IP== PRIVATE AND AUXILIARY INSTANCE METHODS =================================


    //##############################################################################
    //\NT== NESTED DATA TYPES ======================================================
}
