package com.github.svugerovajohanna.semestralniprace.logika;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 * V prostoru můžou být umístěné věci a postavy.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Johanna Švugerová
 * @version pro školní rok 2016/2017
 */
public class Prostor {

    private String nazev;
    private String popis;
    private String potom;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
    private Map<String, Vec> veci;
    private Map<String, Postava> postavy;
    
    private double x;
    private double y;
    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru
     */
    public Prostor(String nazev, String popis, double x, double y) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
        veci = new HashMap<>();
        postavy = new HashMap<>();
        this.x = x;
        this.y = y;
    }

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem" rozšířeného o parametr "potom"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     * @param potom Text, který se zobrazí v určitých prostorech, jestli jsou splněné podmínky, které se k prostoru vážou.
     */
    public Prostor(String nazev, String popis, String potom,double x, double y) {
        this.nazev = nazev;
        this.popis = popis;
        this.x = x;
        this.y = y;
        this.potom = potom;
        vychody = new HashSet<>();
        veci = new HashMap<>();
        postavy = new HashMap<>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
    @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

        return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     * 
     * 
     *
     * @return Dlouhý popis prostoru + seznam východů + seznam věcí v místnosti + seznam postav
     * 
     * U místnostní dál v příběhu (posledních 5 místností)
     * se už nezobrazuje seznam věcí a postav, protože se zde žádně věcí a postavy nevyskytují.
     */
    public String dlouhyPopis() {
        String vrat = "Jsi v mistnosti/prostoru "+ popis + ".\n" + popisVychodu() ;
        switch(nazev){
            case "chodba": return vrat;
            case "místnost_s_Chloupkem": return vrat; 
            case "místnost_s_osidlem": return vrat; 
            case "místnost_s_klíči": return vrat; 
            case "místnost_s_šachy": return vrat; 
            case "místnost_s_kamenem_mudrců": return "\n";
            default: return vrat + "\n"
            + popisVeci() + "\n"
            + popisOsob();

        }

    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    public String popisVychodu() {
        String vracenyText = "Východy:";

        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }

        return vracenyText;
    }

    /**
     * Vrací textový řetězec, který popisuje věci, které se nachází v místnosti, například:
     * "Věci: židle ".
     *
     * @return seznam věcí, které se v místnosti nachází
     */
    public String popisVeci(){
        String vracenyText = "Věci:";

        for (String nazevVeci : veci.keySet()) {
            vracenyText += " " + nazevVeci;
        }

        return vracenyText;
    }

    /**
     * Vrací textový řetězec, který popisuje postavy, které se nachází v místnosti, například:
     * "Postavy: Budulínek".
     *
     * @return seznam postav, které se v místnosti nacházejí
     */
    public String popisOsob(){
        String vracenyText = "Postavy:";

        for(String jmeno : postavy.keySet()){
            vracenyText += " " + jmeno;
        }

        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
            .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
            .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }
    
    /**
     * Metoda vrací kolekci nazvů východů z aktuálníh prostoru.
     * 
     * @return Kolekce názvů prostorů (východů), se kterými daný prostor sousedí.
     */
    
    public Collection<String> getVychodyNazev() {
    	     	List<String> list = new ArrayList<>();
    	     	for(Prostor prostor:vychody){
    	     		list.add(prostor.getNazev());
    	    	}
    	     	return list;
      }

    /**
     * Metoda která vkláda do seznamu věcí. 
     *
     *@param neco z tridy Vec, kterou chceme vložit do seznamu
     *@return false, pokud daná věc už v místnosti je / true, pokud vložení proběhne v pořádku
     */
    public boolean vlozVec(Vec neco){
        if(veci.containsKey(neco.getNazev())){
            return false;
        }
        else{
            veci.put(neco.getNazev(),neco);
            return true;
        }
    }

    /**
     * Metoda zjištuje, jestli se zadaná věc nachází v seznamu věcí.
     * 
     * @param nazev věci, kterou chceme prověřit
     * @return true, pokud věc je obsažená v seznamu / false, pokud není
     */
    public boolean jeVecVProstoru(String nazev){
        return veci.containsKey(nazev);
    }

    /**
     * Metoda, která odebírá věc ze seznamu věcí;
     * 
     * @param nazev věci, kterou chceme odebrat
     * @return true - věc byla odebrána / false - věc nebyla odebrána
     */
    public Vec odeberVec(String nazev){
        return veci.remove(nazev);
    }
    
    /**
     * metoda vrací seznam věcí v místnosti
     * @return kolekce věcí
     */
    public Collection<Vec> getVeci() {
    		return Collections.unmodifiableCollection(veci.values());
    }

    /**
     * Vklada postavu do seznamu postav
     * 
     * @param postava z třídy Postava, kterou chceme přidat
     * @return false, pokud je postava už v seznamu obsažena (nelze vložit) / true - postavu se povedlo vložit do seznamu postav
     */
    public boolean vlozPostavu(Postava jmeno){
        if(postavy.containsKey(jmeno.getJmeno())){
            return false;
        }
        else{
            postavy.put(jmeno.getJmeno(), jmeno);
            return true;
        }
    }

    /**
     * Zjištuje, jestli se zadaná postava nachází v seznamu postav.
     * 
     * @param jmeno postavy, kterou chceme prověřit
     * @return true, pokud věc je postava v seznamu / false, pokud není
     */
    public boolean jePostavaVProstoru(String jmeno){
        return postavy.containsKey(jmeno);
    }

    /**
     * Odebírá postavu ze seznamu postav.
     * 
     * @param jmeno postavy, kterou chceme odebrat
     * @return true, pokud se věc podařila odebrat / false, pokud ne
     */
    public Postava odeberPostavu(String jmeno){
        return postavy.remove(jmeno);
    }

    /**
     * Vrací popis prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return popis prostoru
     */
    public String getPopis(){
        return popis;
    }

    /**
     * Vrací text uložený v proměné "potom" (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return potom - text, který se zobrazí v určitých místnostech po splnění podmínek k nim vázaným
     */
    public String getPotom(){
        return potom;
    }
    
    /**
     * Metoda vrací souřednici x daného prostoru.
     * 
     * @return Desetinné čislo značící souřaci x prostoru.
     */
    public double getX() {
    		return x;
    }
    
    /**
     * Metoda nastavuje souřednici x daného prostoru.
     * 
     * @return Metoda je setter, nic nevrací.
     */
    public void setX(double x) {
		this.x = x;
    }
    
    /**
     * Metoda vrací souřednici y daného prostoru.
     * 
     * @return Desetinné čislo značící souřaci y prostoru.
     */
    public double getY() {
		return y;
    }
    
    /**
     * Metoda nastavuje souřednici y daného prostoru.
     * 
     * @return Metoda je setter, nic nevrací.
     */
    public void setY(double y) {
		this.y = y;
    }


}
