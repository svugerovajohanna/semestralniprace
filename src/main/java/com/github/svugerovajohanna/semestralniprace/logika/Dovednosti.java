/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;
import java.util.*;

/*******************************************************************************
 * Třída Dovednosti - představuje seznam dovedností hráče a opreace s ním.
 * 
 * Sleduje nepřekročení kapacity seznamu(kapacita seznamu dovedností je nastavena na 10),
 * má možnost přidat dovednost do seznamu, 
 * obsahuje metodu kontrolující, zda je v seznamu dovednost již obsažena,
 * má možnost dovednot ze seznamu odebrat a umí tento seznam i vypsat.
 * 
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class Dovednosti
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    private static final int MAX = 10;
    private Map<String, Vlastnost> dovednosti;
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

    /**
     * Vytvoření seznamu dovedností.
     *
     * 
     */
    public Dovednosti()
    {
        dovednosti = new HashMap< String, Vlastnost >();
    }

    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     * Kontroluje, jestli je v seznamu stále místo. (Jestli by nebyla překročená maximalní kapacita)
     * 
     * 
     * @return false, pokud je kapacita plná a do seznamu nejde vložit / true, pokud je v seznamu stále volno
     */
    public boolean volno(){
        return (dovednosti.size() < MAX);
    }

    /**
     * Vklada dovednost do seznamu dovedností
     * 
     * @param vlasnost, kterou chceme do seznamu přidat
     * @return true, pokud je v seznamu volno a podařilo se nám vlastnost do seznamu přidat
     */
    public boolean pridejDovednost (Vlastnost vlastnost){
        if (volno()){
            dovednosti.put(vlastnost.getNazevVlastnosti(), vlastnost);
            return true;
        }
        return false;
    }

    /**
     * Zkoumá, jestli je dovednost už v seznamu obsažená.
     * 
     * @param nazev hledané dovednosti
     * @return true, pokud je dovednost v seznamu
     */
    public boolean obsahujeDovednost(String nazev){
        return (dovednosti.containsKey(nazev));
    }

    /**
     * Vklada postavu do seznamu postav
     * 
     * @param postava z třídy Postava, kterou chceme přidat
     * @return false, pokud je postava už v seznamu obsažena (nelze vložit) / true - postavu se povedlo vložit do seznamu postav
     */
    public String seznamDovednosti(){
        String vracenyText = "";
        for (String nazevVlastnosti : dovednosti.keySet()) {
            vracenyText += " " + nazevVlastnosti;
        }

        return vracenyText;
    }
    //\IP== PRIVATE AND AUXILIARY INSTANCE METHODS =================================

    //##############################################################################
    //\NT== NESTED DATA TYPES ======================================================
}
