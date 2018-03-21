/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.github.svugerovajohanna.semestralniprace.logika.Kapsa;
import com.github.svugerovajohanna.semestralniprace.logika.Vec;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída KapsaTest slouží ke komplexnímu otestování třídy Kapsa.
 *  
 *
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class KapsaTest
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
     * Testuje, zda je v kapse volné místo, kontroluje, jestli je daná věc v kapse obsažena
     * a zda jde věc přidat či odebrat.
     * 
     * Věci neodpovídají vlastní hře.
     */
    @Test
    public  void testFungujeSpravne() {  
        Kapsa kapsa = new Kapsa();
        assertEquals(true, kapsa.volno()); // kapsa je na zacatku prazdna
        
        Vec vec1 = new Vec("a", true);
        Vec vec2 = new Vec("b", true);
        Vec vec3 = new Vec("c", true);
        Vec vec4 = new Vec("d", true);
        
        kapsa.pridejDoKapsy(vec1);
        kapsa.pridejDoKapsy(vec2);
        kapsa.pridejDoKapsy(vec3);
        kapsa.pridejDoKapsy(vec3);
        
        assertEquals(true, kapsa.obsahujeVec("a"));
        assertEquals(true, kapsa.obsahujeVec("b"));
        assertEquals(true, kapsa.obsahujeVec("c"));
        assertEquals(false, kapsa.volno());
        assertEquals(false, kapsa.obsahujeVec("d")); //zkousi kapacitu
        
        assertEquals(vec1, kapsa.odeberZKapsy("a")); //jde odebrat vec z kapsy
        assertEquals(null, kapsa.odeberZKapsy("f")); //nelze odebrat vec, co v kapse neni
      
        
        
    }

    

    
}
