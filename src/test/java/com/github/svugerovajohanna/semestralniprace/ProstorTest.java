package com.github.svugerovajohanna.semestralniprace;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.github.svugerovajohanna.semestralniprace.logika.Prostor;
import com.github.svugerovajohanna.semestralniprace.logika.Vec;
import com.github.svugerovajohanna.semestralniprace.logika.Postava;
import com.github.svugerovajohanna.semestralniprace.logika.Vlastnost;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková, Johanna Švugerová
 * @version   pro skolní rok 2016/2017
 */
public class ProstorTest
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
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public  void testLzeProjit() {      
        Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě",1.0, 2.0);
        Prostor prostor2 = new Prostor("bufet", "bufet, kam si můžete zajít na svačinku", 1.5, 2.5);
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }

    /**
     * Testuje, zda je spravne nastaveno pridavani a odebirani veci do prostoru. 
     * Veci neodpovidaji vlastni hre.
     */
    @Test
    public void testVeci()
    {
        Prostor prostor1 = new Prostor("xxx", null, 1.1, 2.2);
        Vec vec1 = new Vec("a", true);
        Vec vec2 = new Vec("b", true);
        Vec vec3 = new Vec("a", true);
        assertEquals(true, prostor1.vlozVec(vec1));
        assertEquals(true, prostor1.vlozVec(vec2));
        assertEquals(false, prostor1.vlozVec(vec3));
        assertEquals(true, prostor1.jeVecVProstoru("a"));
        assertEquals(false, prostor1.jeVecVProstoru("c"));
        assertNotNull(prostor1.odeberVec("a"));
        assertNull(prostor1.odeberVec("c"));

    }

    /**
     * Testuje, zde je nastaveno spravne přidávání a odebíraní postav do prostorů.
     * Postavy neodpovídají hře, jsou pouze pro účel testování.
     */
    @Test
    public void Postav()
    {
        Prostor prostor1 = new Prostor("xxx", null, 3.3, 4.4);
        Vlastnost vlastnost1 = new Vlastnost("umíš_tohle");
        Vlastnost vlastnost2 = new Vlastnost("umíš_tatmto");
        Vlastnost vlastnost3 = new Vlastnost("neumis nic");
        Postava postava1 = new Postava("Pepa","bla", "bla", vlastnost1);
        Postava postava2 = new Postava("Petr","bla", "bla", vlastnost2);
        Postava postava3 = new Postava("Pepa","bla", "bla", vlastnost3);
        assertEquals(true, prostor1.vlozPostavu(postava1));
        assertEquals(true, prostor1.vlozPostavu(postava2));
        assertEquals(false, prostor1.vlozPostavu(postava3));
        assertNotNull(prostor1.odeberPostavu("Pepa"));

    }


    
}

