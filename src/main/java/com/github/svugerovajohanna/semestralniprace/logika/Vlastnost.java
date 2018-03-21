/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;



/*******************************************************************************
 *Třída Vlastnost - představuje vlastnost, kterou může hráč získat od nějaké postavy
 *
 * @author  Johanna Švugrová
 * @version školní rok 2016/2017
 */
public class Vlastnost
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    private String nazevVlastnosti;
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
     * Vytváří vlastnost se zadaným názvem
     * 
     * @param nazev vlastnosti
     * 
     */
    public Vlastnost(String nazevVlastnosti)
    {
        this.nazevVlastnosti = nazevVlastnosti;
    }


    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    /**
     * Vrací text uložený v proměné "nazevVlastnoti (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return nazevVlastnost, kterou postava předává
     */
    public String getNazevVlastnosti(){
        return nazevVlastnosti;
    }
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    //\IP== PRIVATE AND AUXILIARY INSTANCE METHODS =================================


    //##############################################################################
    //\NT== NESTED DATA TYPES ======================================================
}
