/* UTF-8 codepage: Příliš žluťoučký kůň úpěl ďábelské ódy. ÷ × ¤
 * «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.svugerovajohanna.semestralniprace.logika;
import java.util.*;

/*******************************************************************************
 * Třída Kapsa - reprezentuje imaginární předmět ve hře, do kterého si hráč ukládá získané věci 
 * a je tvořená formou seznamu.
 *
 * Kapsa je omezená kapacitou, která je stanovená na 5 předmětů.
 * 
 * Obsahuje metody pro zkontrolování místa v kapse, pro přidaní předmětu do kapsy, 
 * pro zkoumání, jestli je zadaná věc součástí kapsy, pro odebrání předmětu 
 * a pro výpis předmětů, které jsou momentálně v kapse obsaženy.
 * 
 * 
 * @author  Johanna Švugerová
 * @version školní rok 2016/2017
 */
public class Kapsa
{
    //\CC== CONSTANT CLASS (STATIC) ATTRIBUTES (FIELDS) ============================
    private static final int MAX = 3;
    private Map <String, Vec> seznam;
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
     * Vytvoření seznamu jednotlivých předmětů, které má hráč právě u sebe.
     *
     * 
     */

    public Kapsa()
    {
        seznam = new HashMap< String, Vec >();
    }


    //\IA== ABSTRACT METHODS =======================================================
    //\IG== INSTANCE GETTERS AND SETTERS ===========================================
    //\IM== OTHER NON-PRIVATE INSTANCE METHODS =====================================
    /**
     * Zkoumá, jestli je v kapse volné místo.
     * 
     *
     * @return true, pokud je v kapse místo
     */
    public boolean volno(){
        return (seznam.size() < MAX);
    }

    /**
     * Přidává danou věc do kapsy.
     * 
     * Zkontroluje jestli má hráč v kapse místo a pokud ano, věc přidá.
     * 
     * @param vec, která má být přidána
     * @return textový řetez, který vypíše, jestli byla věc přidána
     */
    public String pridejDoKapsy (Vec vec){
        if (volno()){
            seznam.put(vec.getNazev(), vec);
            return "Harry si dal " + vec.getNazev() + " do kapsy.\n" + "Věc "+vec.getNazev()+ " zmizí ze hry";
        }
        else{
            return "Nemáš místo v kapse. Musíš něco odebrat!";
        }
    }

    /**
     * Zkoumá, jestli je věc v kapse už obsažená.
     * 
     * @param nazev věci, kterou zkoumáme
     * @return true, pokud je věc v kapse
     */
    public boolean obsahujeVec(String nazev){
        return (seznam.containsKey(nazev));
    }

    /**
     * Odebírá věc z kapsy.
     * 
     * Pokud je věc obsažená v kapse, vymaže ji z kapsy.
     * 
     * @param nazev věci, kterou chceme smazat
     * @return vyhazovana věc - vec třídy Vec, kterou jsme právě odebrali ze seznamu
     */
    public Vec odeberZKapsy(String nazev){
        Vec vyhazovana = null;

        if(obsahujeVec(nazev)){
            vyhazovana = seznam.remove(nazev);
        }
        return vyhazovana;
    }

    /**
     * Vypisuje obsah kapsy.
     * 
     * @return vraceny text - retezec, ktery obsahuje veci, ktere jsou obsazene v kapse, oddělené mezerou
     */
    public String kapsaObsahuje(){
        String vracenyText = "";
        for (String nazevVeci : seznam.keySet()) {
            vracenyText += " " + nazevVeci;
        }

        return vracenyText;
    }
    
   
    
    /**
     * Metoda vrací názvy věcí obsažených v kapse jako list
     * 
     * @return List věcí, které má Harry právě v kapse.
     */
    public Collection<String> getVeciVKapse() {
     	List<String> list = new ArrayList<>();
		for(Vec vec: seznam.values()){
     		list.add(vec.getNazev());
    	}
     	return list;
}
    //\IP== PRIVATE AND AUXILIARY INSTANCE METHODS =================================


    //##############################################################################
    //\NT== NESTED DATA TYPES ======================================================
}
