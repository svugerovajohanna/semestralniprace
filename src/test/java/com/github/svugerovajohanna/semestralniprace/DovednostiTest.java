/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.github.svugerovajohanna.semestralniprace.logika.Vlastnost;
import com.github.svugerovajohanna.semestralniprace.logika.Dovednosti;


import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída DovednostiTest slouží ke komplexnímu otestování třídy Dovednosti.
 *  
 *
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class DovednostiTest
{

    //== Datové atributy (statické i instancí)======================================
    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda je volné místo v dovednostech, zda jde dovednost přidat do senamu
     * a jestli zadaná dovenost je obsazena v seznamu;
     * 
     */
    @Test
    public  void testFungujeSpravne() {  
        Dovednosti dovednosti = new Dovednosti();
        assertEquals(true, dovednosti.volno()); // kapsa je na zacatku prazdna

        Vlastnost vlastnost1 = new Vlastnost("1");
        Vlastnost vlastnost2 = new Vlastnost("2");
        Vlastnost vlastnost3 = new Vlastnost("3");
        Vlastnost vlastnost4 = new Vlastnost("4");
        Vlastnost vlastnost5 = new Vlastnost("5");
        Vlastnost vlastnost6 = new Vlastnost("6");
        Vlastnost vlastnost7 = new Vlastnost("7");
        Vlastnost vlastnost8 = new Vlastnost("8");
        Vlastnost vlastnost9 = new Vlastnost("9");
        Vlastnost vlastnost10 = new Vlastnost("10");
        Vlastnost vlastnost11 = new Vlastnost("11");
        Vlastnost vlastnost12 = new Vlastnost("1");

        assertEquals(true, dovednosti.pridejDovednost(vlastnost1));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost2));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost3));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost4));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost5));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost6));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost7));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost8));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost9));
        assertEquals(false, dovednosti.pridejDovednost(vlastnost12));
        assertEquals(true, dovednosti.pridejDovednost(vlastnost10));
        assertEquals(false, dovednosti.volno()); //naplnena kapacita
        assertEquals(false, dovednosti.pridejDovednost(vlastnost11));

        assertEquals(true, dovednosti.obsahujeDovednost("1"));
        assertEquals(false, dovednosti.obsahujeDovednost("11"));

    }
    
    
}