package com.github.svugerovajohanna.semestralniprace;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.svugerovajohanna.semestralniprace.logika.Hra;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazDovednosti;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazKapsa;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazKonec;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazMluv;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazProzkoumej;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazSeber;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazVyhod;
import com.github.svugerovajohanna.semestralniprace.logika.PrikazJdi;
import com.github.svugerovajohanna.semestralniprace.logika.SeznamPrikazu;



/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy  
 * SeznamPrikazu
 * 
 * @author    Luboš Pavlíček, Johanna Švugerová
 * @version   pro školní rok 2016/2017
 */
public class SeznamPrikazuTest
{
    private Hra hra;
    private PrikazKonec prKonec;
    private PrikazJdi prJdi;
    private PrikazSeber prSeber;
    private PrikazVyhod prVyhod;
    private PrikazMluv prMluv;
    private PrikazProzkoumej prProzkoumej;
    private PrikazKapsa prKapsa;
    private PrikazDovednosti prDovednosti;
    
    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra = new Hra();
        prKonec = new PrikazKonec(hra);
        prJdi = new PrikazJdi(hra.getHerniPlan(), hra);
        prSeber = new PrikazSeber(hra.getHerniPlan(), hra.getHerniPlan().getKapsa());
        prVyhod = new PrikazVyhod(hra.getHerniPlan(), hra.getHerniPlan().getKapsa());
        prMluv = new PrikazMluv(hra.getHerniPlan(), hra.getHerniPlan().getDovednosti());
        prProzkoumej = new PrikazProzkoumej(hra.getHerniPlan());
        prKapsa = new PrikazKapsa(hra.getHerniPlan(), hra.getHerniPlan().getKapsa());
        prDovednosti = new PrikazDovednosti(hra.getHerniPlan(), hra.getHerniPlan().getDovednosti());
    }

     /***************************************************************************
     * 
     * Testuje vkládání příkazů
     */
    @Test
    public void testVlozeniVybrani() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prSeber);
        seznPrikazu.vlozPrikaz(prVyhod);
        seznPrikazu.vlozPrikaz(prMluv);
        seznPrikazu.vlozPrikaz(prProzkoumej);
        seznPrikazu.vlozPrikaz(prKapsa);
        seznPrikazu.vlozPrikaz(prDovednosti);
        assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
        assertEquals(prJdi, seznPrikazu.vratPrikaz("jdi"));
        assertEquals(prSeber, seznPrikazu.vratPrikaz("seber"));
        assertEquals(prVyhod, seznPrikazu.vratPrikaz("vyhod"));
        assertEquals(prMluv, seznPrikazu.vratPrikaz("mluv"));
        assertEquals(prProzkoumej, seznPrikazu.vratPrikaz("prozkoumej"));
        assertEquals(prKapsa, seznPrikazu.vratPrikaz("kapsa"));
        assertEquals(prDovednosti, seznPrikazu.vratPrikaz("dovednosti"));
        assertEquals(null, seznPrikazu.vratPrikaz("nápověda"));
    }
    
     /***************************************************************************
     * 
     * Testuje jestli je příkaz platný.
     */
    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prSeber);
        seznPrikazu.vlozPrikaz(prVyhod);
        seznPrikazu.vlozPrikaz(prMluv);
        seznPrikazu.vlozPrikaz(prProzkoumej);
        seznPrikazu.vlozPrikaz(prKapsa);
        seznPrikazu.vlozPrikaz(prDovednosti);
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("konec"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("jdi"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("nápověda"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }
    
    
     /***************************************************************************
     * 
     * Testuje jestli seznam příkazů vrací jejich názvy.
     */
    @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("jdi"));
        assertEquals(false, nazvy.contains("nápověda"));
        assertEquals(false, nazvy.contains("Konec"));
    }
    
}
