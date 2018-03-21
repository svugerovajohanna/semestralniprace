package com.github.svugerovajohanna.semestralniprace;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.github.svugerovajohanna.semestralniprace.logika.Hra;
import com.github.svugerovajohanna.semestralniprace.logika.Vlastnost;
import com.github.svugerovajohanna.semestralniprace.logika.Postava;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková, Johanna Švugerová
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

    private Vlastnost vlastnost1;
    private Vlastnost vlastnost2;

    private Postava postava1;
    private Postava postava2;
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
        hra1 = new Hra();

    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Dale testuje, jestli se předměty a postavy nachazí v místnoti.
     * 
     * Pro věci testuje, že pokud je použit příkaz seber <věc>, věc je dána do kapsy a zmizí z prostoru. Naopak přikazem vyhod je vyndána z kapsy a navrácena do prostoru.
     * Testuje, že nemůže být překročena kapacita kapsy.
     * 
     * Pro postavy testuje, že po provedení příkazu mluv <postava>, předá postava dovednost, která je následně uložena v dovednostech, a postava mizí ze hry.
     */
    @Test
    public void testPrubehHry() {
        assertEquals("vstupni_sin", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("stul"));
        assertEquals(true, hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("socha"));

        hra1.zpracujPrikaz("seber stul");
        assertEquals(false, hra1.getHerniPlan().getKapsa().obsahujeVec("stul")); //nelze sebrat vec co neni v prostoru

        hra1.zpracujPrikaz("seber socha");

        assertEquals(false, hra1.getHerniPlan().getKapsa().obsahujeVec("socha")); //test, ze vec se nepridala do kapsy
        assertEquals(true, hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("socha")); //test, ze vec nezmizela z prostoru

        hra1.zpracujPrikaz("jdi nebelvirska_loznice");

        assertEquals("nebelvirska_loznice", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(true, hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("neviditelny_plast"));

        hra1.zpracujPrikaz("seber neviditelny_plast");

        assertEquals(true, hra1.getHerniPlan().getKapsa().obsahujeVec("neviditelny_plast")); //vec se presunula do kapsy
        assertEquals(false, hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("neviditelny_plast")); //uz neni v prostoru

        hra1.zpracujPrikaz("vyhod neviditelny_plast");

        assertEquals(false, hra1.getHerniPlan().getKapsa().obsahujeVec("neviditelny_plast")); //vec uz neni v kapse
        assertEquals(true, hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("neviditelny_plast")); //vec se pridala zpatky do prostoru

        hra1.zpracujPrikaz("jdi vstupni_sin");

        assertEquals(false, hra1.konecHry()); // testuji, ze hra nedava konec, jindy, nez ma

        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber Nevillova_ponozka");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("seber knizka");
        hra1.zpracujPrikaz("jdi vstupni_sin");;
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("seber fletna");
        assertEquals(false, hra1.getHerniPlan().getKapsa().obsahujeVec("fletna")); //vec nemuzes pridat do kapsy, je plna kapacita a musi se neco vyhodit

        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi velka_sin");

        assertEquals(true, hra1.getHerniPlan().getAktualniProstor().jePostavaVProstoru("Ron"));
        assertEquals(false, hra1.getHerniPlan().getAktualniProstor().jeVecVProstoru("Brumbal"));

        hra1.zpracujPrikaz("mluv Brumbal");
        assertEquals(false, hra1.getHerniPlan().getDovednosti().obsahujeDovednost("umíš_tohle")); // test, ze neobsahuje dovednost od psotavy, co neni v prostorz

        hra1.zpracujPrikaz("mluv Ron");
        assertEquals(true, hra1.getHerniPlan().getDovednosti().obsahujeDovednost("umíš_hrát_šachy")); //dovednost byla ziskana
        assertEquals(false, hra1.getHerniPlan().getAktualniProstor().jePostavaVProstoru("Ron")); //postava zmizi z prostoru

        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje moznost hru vyhrat.
     * 
     */
    @Test
    public void testVyhra() {
        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("seber letajici_koste");
        hra1.zpracujPrikaz("jdi Hagridova_bouda");
        hra1.zpracujPrikaz("mluv Hagrid");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi famfrpalove_hriste");
        hra1.zpracujPrikaz("mluv profesorka_Hoochova");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi ucebna_kouzleni");
        hra1.zpracujPrikaz("mluv profesor_Kratiknot");
        hra1.zpracujPrikaz("jdi ucebna_bylinkarstvi");
        hra1.zpracujPrikaz("mluv profesorka_Prytova");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi velka_sin");
        hra1.zpracujPrikaz("mluv Ron");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("seber fletna");
        hra1.zpracujPrikaz("jdi chodba");
        hra1.zpracujPrikaz("jdi mistnost_s_Chloupkem");
        hra1.zpracujPrikaz("jdi mistnost_s_osidlem");
        hra1.zpracujPrikaz("jdi mistnost_s_klici");
        hra1.zpracujPrikaz("jdi mistnost_s_sachy");
        hra1.zpracujPrikaz("jdi mistnost_s_kamenem_mudrcu");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje jednu z nekolika moznosti, jak prohrat.
     * Harry nema neviditelny plast a jde do chodby, kam byl zakazany pristup.
     * 
     */
    @Test
    public void testProhra1() {
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("jdi chodba");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje jednu z nekolika moznosti, jak prohrat.
     * Harry nema jde do mistnosti s klici, ma koste, ale neumi letat.
     * 
     */
    @Test
    public void testProhra2() { 
        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("seber letajici_koste");
        hra1.zpracujPrikaz("jdi Hagridova_bouda");
        hra1.zpracujPrikaz("mluv Hagrid");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi ucebna_kouzleni");
        hra1.zpracujPrikaz("mluv profesor_Kratiknot");
        hra1.zpracujPrikaz("jdi ucebna_bylinkarstvi");
        hra1.zpracujPrikaz("mluv profesorka_Prytova");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi velka_sin");
        hra1.zpracujPrikaz("mluv Ron");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("seber fletna");
        hra1.zpracujPrikaz("jdi chodba");
        hra1.zpracujPrikaz("jdi mistnost_s_Chloupkem");
        hra1.zpracujPrikaz("jdi mistnost_s_osidlem");
        hra1.zpracujPrikaz("jdi mistnost_s_klici");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje jednu z nekolika moznosti, jak prohrat.
     * Harry se dostane do mistnosti s osidlem_ale nema znalosti z bylinkarstvi.
     * 
     */
    @Test
    public void testProhra3() {
        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("seber letajici_koste");
        hra1.zpracujPrikaz("jdi Hagridova_bouda");
        hra1.zpracujPrikaz("mluv Hagrid");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi famfrpalove_hriste");
        hra1.zpracujPrikaz("mluv profesorka_Hoochova");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi ucebna_kouzleni");
        hra1.zpracujPrikaz("mluv profesor_Kratiknot");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi velka_sin");
        hra1.zpracujPrikaz("mluv Ron");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("seber fletna");
        hra1.zpracujPrikaz("jdi chodba");
        hra1.zpracujPrikaz("jdi mistnost_s_Chloupkem");
        hra1.zpracujPrikaz("jdi mistnost_s_osidlem");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje jednu z nekolika moznosti, jak prohrat.
     * Harry neví, jak na Chloupka a Chloupek ho zabije.
     */
    @Test
    public void testProhra4() {
        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("seber letajici_koste");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi ucebna_kouzleni");
        hra1.zpracujPrikaz("mluv profesor_Kratiknot");
        hra1.zpracujPrikaz("jdi ucebna_bylinkarstvi");
        hra1.zpracujPrikaz("mluv profesorka_Prytova");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi velka_sin");
        hra1.zpracujPrikaz("mluv Ron");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("seber fletna");
        hra1.zpracujPrikaz("jdi chodba");
        hra1.zpracujPrikaz("jdi mistnost_s_Chloupkem");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje jednu z nekolika moznosti, jak prohrat.
     * Harry sice ví, jak na chloupka, ale nemá mu na co zahrát. Chloupek sežere Harryho.
     * 
     */
    @Test
    public void testProhra5() {
        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi Hagridova_bouda");
        hra1.zpracujPrikaz("mluv Hagrid");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi ucebna_kouzleni");
        hra1.zpracujPrikaz("mluv profesor_Kratiknot");
        hra1.zpracujPrikaz("jdi ucebna_bylinkarstvi");
        hra1.zpracujPrikaz("mluv profesorka_Prytova");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi velka_sin");
        hra1.zpracujPrikaz("mluv Ron");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("jdi chodba");
        hra1.zpracujPrikaz("jdi mistnost_s_Chloupkem");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje jednu z nekolika moznosti, jak prohrat.
     * Harry umí létat, ale nemá koště. Létající klíče se na něj vrhnou a ubodají ho.
     * 
     */
    @Test
    public void testProhra6() {  
        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi Hagridova_bouda");
        hra1.zpracujPrikaz("mluv Hagrid");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi famfrpalove_hriste");
        hra1.zpracujPrikaz("mluv profesorka_Hoochova");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi ucebna_kouzleni");
        hra1.zpracujPrikaz("mluv profesor_Kratiknot");
        hra1.zpracujPrikaz("jdi ucebna_bylinkarstvi");
        hra1.zpracujPrikaz("mluv profesorka_Prytova");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi velka_sin");
        hra1.zpracujPrikaz("mluv Ron");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("seber fletna");
        hra1.zpracujPrikaz("jdi chodba");
        hra1.zpracujPrikaz("jdi mistnost_s_Chloupkem");
        hra1.zpracujPrikaz("jdi mistnost_s_osidlem");
        hra1.zpracujPrikaz("jdi mistnost_s_klici");
        assertEquals(true, hra1.konecHry());
    }

    /***************************************************************************
     * Testuje jednu z nekolika moznosti, jak prohrat.
     * Harry neumí hrát kouzelnické šachy, zabijí ho u toho.
     * 
     */
    @Test
    public void testProhra7() {
        hra1.zpracujPrikaz("jdi nebelvirska_loznice");
        hra1.zpracujPrikaz("seber neviditelny_plast");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("seber letajici_koste");
        hra1.zpracujPrikaz("jdi Hagridova_bouda");
        hra1.zpracujPrikaz("mluv Hagrid");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi famfrpalove_hriste");
        hra1.zpracujPrikaz("mluv profesorka_Hoochova");
        hra1.zpracujPrikaz("jdi nadvori");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi ucebna_kouzleni");
        hra1.zpracujPrikaz("mluv profesor_Kratiknot");
        hra1.zpracujPrikaz("jdi ucebna_bylinkarstvi");
        hra1.zpracujPrikaz("mluv profesorka_Prytova");
        hra1.zpracujPrikaz("jdi ucebny");
        hra1.zpracujPrikaz("jdi vstupni_sin");
        hra1.zpracujPrikaz("jdi schodiste");
        hra1.zpracujPrikaz("seber fletna");
        hra1.zpracujPrikaz("jdi chodba");
        hra1.zpracujPrikaz("jdi mistnost_s_Chloupkem");
        hra1.zpracujPrikaz("jdi mistnost_s_osidlem");
        hra1.zpracujPrikaz("jdi mistnost_s_klici");
        hra1.zpracujPrikaz("jdi mistnost_s_sachy");
        assertEquals(true, hra1.konecHry());
    }

}

