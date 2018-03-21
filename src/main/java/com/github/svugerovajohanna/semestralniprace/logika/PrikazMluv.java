/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;

/*******************************************************************************
 * Třída Prikaz mluv implementuje prikaz pro jednoduchou textovou hru, 
 * pomocí kterého hráč "mluví" s postavami a ty mu tím předají nějakou vlastnost.
 * 
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class PrikazMluv implements IPrikaz
{
    private static final String NAZEV = "mluv";
    private HerniPlan plan;
    private Dovednosti dovednosti;
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
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
     * Konsturktor třídy.
     * 
     * @param plan, ve kterem se prikaz provede
     * @param dovednosti - seznam vlastnostní, které hráč má
     */
    public PrikazMluv(HerniPlan plan, Dovednosti dovednosti) {
        this.plan = plan;
        this.dovednosti = plan.getDovednosti();
    }


    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     *  Provádí příkaz "mluv". Provádí interakci s postavou, pokud se daná postava nachází 
     *  v aktuálním prostoru. Pokud ne, vypíše chybové hlášení. Pokud ano, postava předá hráči
     *  vlastnost, která se uloží do "dovednosti", vypíše, kterou vlastnost hráč získal a postava ze hry zmizí.
     *
     *@param parametry - jako  parametr obsahuje jméno postavy, se kterou chce hráč mluvit
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {

            return "S kým mám mluvit? Musíš zadat název postavy";
        }

        String jmeno = parametry[0];

        Prostor aktualniProstor = plan.getAktualniProstor();
        Postava vybrana = aktualniProstor.odeberPostavu(jmeno);
        if (vybrana == null) {
            return "Tahle postava tu není!";
        }
        else {
            if(dovednosti.pridejDovednost(vybrana.getVlastnost())){   

                return vybrana.getRecPred() + "\n" +
                vybrana.getRecPo() + "\n" +
                "Získal jsi dovednost: " + vybrana.getVlastnost().getNazevVlastnosti() +
                "\nPostava "+vybrana.getJmeno()+ " zmizí ze hry.";

            }
            else{
                return "Něco je špatně!";
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

    //\IP== PRIVATE AND AUXILIARY INSTANCE METHODS =================================


    //##############################################################################
    //\NT== NESTED DATA TYPES ======================================================
}
