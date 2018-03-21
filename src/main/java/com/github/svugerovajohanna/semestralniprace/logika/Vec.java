/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.svugerovajohanna.semestralniprace.logika;


/*******************************************************************************
 * Třída Vec - popisuje jednotlivé věci vyskytující se ve hře. 
 * 
 * Třída reprezentuje věc, která se nachází v nějakém z prostorů. 
 * Věc může nebo nemusí být přenositelná.
 * Podle toho ji hráč může nebo nemůže sebrat (příkazem seber <vec>)
 * a vložit do kapsy (= inventáře sebraných věcí).
 *
 * @author    Johanna Švugerová
 * @version   pro školní rok 2016/2017
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private boolean prenositelnost;
    //== Konstruktory a tovární metody =============================================

    /**
     * Vytvoření věci se zadaným názvem a vlastností přenositelnosti/nepřenositelnosti.
     * 
     * @param nazev věci
     * @param prenositelnost - hodnoty true/false
     */
    public Vec(String nazev, boolean prenositelnost) {
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Vrací text uložený v proměnné "název" (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název věci
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Nastaví novou hodnotu do proměnné "název", která určuje název věci.
     *
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Vrací hodnotu uloženou v proměnné "prenositelna" (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return true, pokud je vec prenositelna / false, pokud není
     */
    public boolean jePrenositelna() {
        return prenositelnost;
    }
    //== Soukromé metody (instancí i třídy) ========================================

}
