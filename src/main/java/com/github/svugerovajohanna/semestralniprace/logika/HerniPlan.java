package com.github.svugerovajohanna.semestralniprace.logika;

import java.util.Observable;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan extends Observable {

    private Prostor aktualniProstor;
    private Prostor vyherniProstor;
    private Kapsa kapsa;
    private Dovednosti dovednosti;
    private Hra hra;

    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Také využívá kapsu (inventář hráče) a seznam jeho dovedností.
     *  Jako výchozí aktuální prostor nastaví vstupní_siň.
     */
    public HerniPlan() {
        zalozProstoryHry();
        kapsa = new Kapsa();
        dovednosti = new Dovednosti();
        this.hra = hra;

    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví vstupní_síň.
     *  Vytváří jednotlivé věci a postavy a vkládá je do prostorů.
     *  
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor ucBylinkarstvi = new Prostor("ucebna_bylinkarstvi","učebna bylinkářství",50.0,36.5);
        Prostor ucKouzleni = new Prostor("ucebna_kouzleni", "učebna kouzlení",50.0, 90.0);
        //Prostor ucLektvaru = new Prostor("učebna_lektvarů","učebna lektvarů.\nPrávě zde probíhá hodina s profesorem Snapeem");
        Prostor ucebny = new Prostor("ucebny","učebny, který vede do jednotlivých učeben", 155.0, 90.0);
        Prostor vstupniSin = new Prostor("vstupni_sin","Vstupní síň.\nOdtud můžeš jít ven nebo prozkoumat hrad", 250.0, 90.0);
        Prostor nebelvirLoznice = new Prostor("nebelvirska_loznice","nebelvírská ložnice",175.0, 36.5);
        Prostor velkaSin = new Prostor("velka_sin","Velká síň.\nTady probíhají všechny společenské akce.\nVelká síň má strop, který je začarovaný tak, aby vypadal jako opravodové nebe.",87.0, 143.0);
        Prostor schodiste = new Prostor("schodiste","schodiště, které vede do prvního patra",220.0, 143.0);
        Prostor chodba = new Prostor("chodba","chodba.\nPozor - sem bylo zákázano vstupovat", "Naštěští sis nasadil svůj neviditelný plášť a nikdo tě neviděl.",225.0, 201.0);
        Prostor mistnostChloupek = new Prostor("mistnost_s_Chloupkem",", kde je tříhlavý pes a na nečem stojí.\nVypadá to, jako padací dveře", "Zahrál jsi chloupkovi na flétnu a on usnul.\nOdsunul jsi jeho tlapy z padacích dveří na podlaze a skočil dovnitř.",95.0, 201.0);
        Prostor mistnostOsidlo = new Prostor("mistnost_s_osidlem",", který je celý zaplněný rostlinou zvanou Ďáblovo osidlo", "Díky znalostem z hodin bylinkářství víš, že na osidlo platí světlo.\nZ hůlky jsi vyslal ostrý proud světla a osidlo zmizelo.", 95.0, 353.0);
        Prostor mistnostKlic = new Prostor("mistnost_s_klici",", po které poletují různé klíče", "Sednul jsi na koště, chytil správný klíč, odemknul dveře a dostal se dál.", 200.0, 353.0);
        Prostor mistnostSachy = new Prostor("mistnost_s_sachy",", kterou tvoří obrovské šachové pole","Vyhrál jsi šachový turnaj, můžeš jít dál!",305.0, 353.0);
        Prostor nadvori = new Prostor("nadvori","nádvoří", 360.0, 90.0);
        Prostor bouda = new Prostor("Hagridova_bouda","bouda, kde bydlí klíčník a šafář Bradavic Rubius Hagrid", 480.0, 90.0);
        Prostor hriste = new Prostor("famfrpalove_hriste","famfrpálové hříště.\nZde se hraje famrfrpál a cvičí se letání", 360.0, 187.0);
        Prostor mistnostKamen = new Prostor("mistnost_s_kamenem_mudrcu",", kde je schovaný kámen mudrců", 425.0, 353.0);

        // přiřazují se průchody mezi prostory (sousedící prostory)
        ucBylinkarstvi.setVychod(ucKouzleni);
        ucBylinkarstvi.setVychod(ucebny);
        ucKouzleni.setVychod(ucBylinkarstvi);
        //ucKouzleni.setVychod(ucLektvaru);
        ucKouzleni.setVychod(ucebny);
        //ucLektvaru.setVychod(ucKouzleni);
        //ucLektvaru.setVychod(ucebny);
        ucebny.setVychod(ucBylinkarstvi);
        ucebny.setVychod(ucKouzleni);
        //ucebny.setVychod(ucLektvaru);
        ucebny.setVychod(vstupniSin);
        vstupniSin.setVychod(ucebny);
        vstupniSin.setVychod(nebelvirLoznice);
        vstupniSin.setVychod(velkaSin);
        vstupniSin.setVychod(schodiste);
        vstupniSin.setVychod(nadvori);
        velkaSin.setVychod(vstupniSin);
        schodiste.setVychod(vstupniSin);
        schodiste.setVychod(chodba);
        chodba.setVychod(mistnostChloupek);
        chodba.setVychod(schodiste);
        mistnostChloupek.setVychod(mistnostOsidlo);
        mistnostOsidlo.setVychod(mistnostKlic);
        mistnostKlic.setVychod(mistnostSachy);
        mistnostSachy.setVychod(mistnostKamen);
        nebelvirLoznice.setVychod(vstupniSin);
        nadvori.setVychod(bouda);
        nadvori.setVychod(hriste);
        nadvori.setVychod(vstupniSin);
        hriste.setVychod(nadvori);
        bouda.setVychod(nadvori);

        // ještě vložit nesebratelné věci
        Vec plast = new Vec("neviditelny_plast",true);
        Vec fletna = new Vec("fletna",true);
        Vec koste = new Vec("letajici_koste",true);
        Vec ponozka = new Vec("Nevillova_ponozka",true);
        Vec socha = new Vec("socha",false);
        Vec strom = new Vec("strom",false);
        Vec knizka = new Vec("knizka",true);
        Vec kreslo = new Vec("kreslo",false);
        Vec postel = new Vec("postel",false);
        Vec stul = new Vec("stul",false);
        Vec klobouk = new Vec("moudry_klobouk",true);
        Vec kaminek = new Vec("kaminek",true);
        Vec obraz  = new Vec("obraz",false);

        nebelvirLoznice.vlozVec(plast);
        schodiste.vlozVec(fletna);
        nadvori.vlozVec(koste);
        nebelvirLoznice.vlozVec(ponozka);
        vstupniSin.vlozVec(socha);
        nadvori.vlozVec(strom);
        ucebny.vlozVec(knizka);
        nebelvirLoznice.vlozVec(postel);
        velkaSin.vlozVec(kreslo);
        ucKouzleni.vlozVec(stul);
        velkaSin.vlozVec(klobouk);
        hriste.vlozVec(kaminek);
        schodiste.vlozVec(obraz);

        Vlastnost chloupek = new Vlastnost("víš_jak_na_Chloupka");
        Vlastnost rostliny = new Vlastnost("víš_důležité_věci_o_rostlinách");
        Vlastnost kouzleni = new Vlastnost("umíš_alahomora");
        Vlastnost sachy = new Vlastnost("umíš_hrát_šachy");
        Vlastnost letani = new Vlastnost("umíš_létat");

        Postava hagrid = new Postava("Hagrid", "Hagrid sedí před svoji boudou a hraje na píšťalku.","Hagrid ti nechtěne prozradil, že na tříhlavého psa Chloupka platí, když mu zahraješ na nějaký nástroj a on pak usne.", chloupek);
        Postava prytova = new Postava("profesorka_Prytova", "Právě zde probíhá hodina s profesorkou Prýtovou." ,"Profesorka Prýtová tě naučila důležité vědomosti o rostlinách, určitě se ti to bude hodit!", rostliny);
        Postava kratiknot = new Postava("profesor_Kratiknot", "Právě zde probíhá hodina kouzelných formulí s profesorem Kratiknotem." ,"Právě ses naučil zaklínadlo Alahomora, které dokáže otevřít zamčené dveře.", kouzleni);
        Postava hoochova = new Postava("profesorka_Hoochova", "Probíhá tu hodina létání","Profesorka Hoochová tě naučila létat.", letani); 
        Postava ron = new Postava("Ron","Právě je zde Ron a hraje kouzelnické šachy.","Ron tě naučil hrát kouzelnické šachy.", sachy);

        bouda.vlozPostavu(hagrid);
        ucBylinkarstvi.vlozPostavu(prytova);
        ucKouzleni.vlozPostavu(kratiknot);
        velkaSin.vlozPostavu(ron);
        hriste.vlozPostavu(hoochova);

        aktualniProstor = vstupniSin;  // hra začíná ve vstupní síni.  
        vyherniProstor = mistnostKamen;
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory.
     *  Poté zkontroluje podmínky pro průchod do daného prostoru. 
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
        setChanged();
        notifyObservers();

    }

    /**
     *  Metoda zjišťuje jestli jsou v předem daných prostorech splněny jejich podmínky 
     *  (hřáč má v kapse určitou věc a nebo umí danou dovednost)
     *  Pokud nejsou, vypíše odpovídající text a ukončí hru.
     *  
     *  Pokud hráč projde všemi prostory, nastane výhra a hra je náležite ukončena se správnou hláškou.
     *
     */
    public String proverPruchod(Prostor aktualniProstor) {

        if( (aktualniProstor.getNazev().equals("chodba") ) && !(kapsa.obsahujeVec("neviditelny_plast"))) {
            
            return aktualniProstor.dlouhyPopis() + "\nNemáš neviditelný plášť!\nNachytala tě paní Norisová, kočka školníka Filche.\nTen tě nahlásl řediteli Brumbálovi, který tě vyloučil z Bradavic.\nHra končí, prohrál jsi!";

        }
        else {
            if( (aktualniProstor.getNazev().equals("mistnost_s_Chloupkem")) && !(dovednosti.obsahujeDovednost("víš_jak_na_Chloupka"))) {
                
                return aktualniProstor.dlouhyPopis() + "\nV místnosti je tříhlavý pes a ty nevíš, jak na něj!\nChloupek sežral Harryho.\nProhrál jsi, hra končí.";

            }
            else {
                if((aktualniProstor.getNazev().equals("mistnost_s_Chloupkem")) && !(kapsa.obsahujeVec("fletna"))) {
                    
                    return aktualniProstor.dlouhyPopis() + "\nSice víš jak na Chloupka, ale nemáš mu na co zahrát!\nChloupek sežral Harryho.\nProhrál jsi, hra končí.";

                }
                else {
                    if((aktualniProstor.getNazev().equals("mistnost_s_osidlem")) && !(dovednosti.obsahujeDovednost("víš_důležité_věci_o_rostlinách"))) {

                        return aktualniProstor.dlouhyPopis() + "\nOsidlo tě uškrtilo.\nProhrál jsi, hra končí.";

                    }
                    else {
                        if((aktualniProstor.getNazev().equals("mistnost_s_klici")) && !(dovednosti.obsahujeDovednost("umíš_létat"))) {
    
                            return aktualniProstor.dlouhyPopis() + "\nNeumíš létat.\nKlíče se najednou rozletěli proti Harrymu a zabili ho.\nProhrál jsi, hra končí.";

                        } 
                        else {
                            if((aktualniProstor.getNazev().equals("mistnost_s_klici")) && !(kapsa.obsahujeVec("letajici_koste"))) {
        
                                return aktualniProstor.dlouhyPopis() + "\nSice umíš létat, ale nemáš kostě!\nKlíče se najednou rozletěli proti Harrymu a zabili ho.\nProhrál jsi, hra končí.";

                            } 
                            else {
                                if((aktualniProstor.getNazev().equals("mistnost_s_sachy")) && !(dovednosti.obsahujeDovednost("umíš_hrát_šachy"))) {
            
                                    return aktualniProstor.dlouhyPopis() + "\nNeumíš hrát šachy.\nKouzelnícké šachy jsou brutální, prohrál jsi a soupeř tě zabil.\nHra končí.";

                                }
                                else {
                                    if(jeVyhra()) {
                                        return "Vyhrál jsi, gratulujeme!\nZachránil jsi kámen mudrců před profesorem Quirellem, který ho chtěl pro Pána zla. ";
                                        //hra.zpracujPrikaz("konec");
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     *  Metoda určuje, zda je daný prostor výherní.
     *
     *@param true, pokud ano
     */
    public boolean jeVyhra(){
        return aktualniProstor == vyherniProstor;
    }

    /**
     *  Metoda vrací aktuální kapsu.
     *
     *@param kapsa, kde jsou obsažené věci, co hráč vlastní
     */
    public Kapsa getKapsa() {
        return kapsa;
    }

    /**
     *  Metoda vrací seznam aktuálních dovedností. 
     *
     *@param dovednosti - seznam s dovednostmi hráče
     */
    public Dovednosti getDovednosti() {
        return dovednosti;
    }
}
