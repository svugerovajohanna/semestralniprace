/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;


/*******************************************************************************
 * Třída Postava - představuje postavu ve hře, která je umístěna v nějakém prostoru herního plánu.
 * 
 * Postava předává hráči dovednost pomocí příkazu mluv, poté zmizí z herního plánu.
 * 
 * Třída Postava obsahuje metody pro získání jména postavy, 
 * textu, který se zobrazí předím, co postava předá dovednost,
 * textu, který se zobrazí potom, co předá dovednost,
 * a jména vlastnosti, kterou předává.
 * 
 * 
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class Postava
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    private String jmeno;
    private String recPred;
    private String recPo;
    private Vlastnost vlastnost;

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
     * 
     * Vytváří postavu se zadaným jménem, s texty, 
     * které se budou zobrazovat před a po předání vlastnosti
     * a samotnou vlastnost
     * 
     * @param jmeno postavy
     * @param recPred, která se zobrazí před předáním
     * @param recPo, která se zobrazí po předání
     * @param vlastnost, kterou bude postaba předávát
     * 
     */
    public Postava(String jmeno, String recPred, String recPo, Vlastnost vlastnost)
    {
        this.jmeno = jmeno;
        this.recPred = recPred;
        this.recPo = recPo;
        this.vlastnost = vlastnost;
    }

    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     * Vrací text uložený v proměné "jmeno" (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return jmeno postavy
     */
    public String getJmeno(){
        return jmeno; 
    }
    
    public void setJmeno(){
        this.jmeno = jmeno;
    }

    /**
     * Vrací text uložený v proměné "recPred" (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return redPrec, což je text, který se zobrazí předtím, než postava předá dovednost
     */
    public String getRecPred(){
        return recPred;
    }

    /**
     * Vrací text uložený v proměné "recPo" (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return redPo, což je text, který se zobrazí potom, co postava předá dovednost
     */
    public String getRecPo(){
        return recPo;
    }

    /**
     * Vrací text uložený v proměné "vlastnost (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return vlastnost, kterou postava předává
     */
    public Vlastnost getVlastnost(){
        return vlastnost;
    }
    //\IP== PRIVATE AND AUXILIARY INSTANCE METHODS =================================

    //##############################################################################
    //\NT== NESTED DATA TYPES ======================================================
}
