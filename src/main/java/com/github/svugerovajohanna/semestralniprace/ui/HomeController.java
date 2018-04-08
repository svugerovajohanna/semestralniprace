package com.github.svugerovajohanna.semestralniprace.ui;

import java.util.Observable;
import java.util.Observer;

import com.github.svugerovajohanna.semestralniprace.logika.Hra;
import com.github.svugerovajohanna.semestralniprace.logika.IHra;
import com.github.svugerovajohanna.semestralniprace.logika.Vec;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Filip Vencovsky, Johanna Švugerová
 *
 */
@SuppressWarnings("deprecation")
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField vstupniText;
	@FXML private TextArea vystup;
	@FXML private MenuItem novaHra;
	@FXML private MenuItem konecHry;
	@FXML private ListView<String> seznamVychodu;
	@FXML private ListView<String> seznamVeci;
	@FXML private ListView<String> seznamPostav;
	@FXML private ListView<String> dovednosti;
	@FXML private ListView<String> kapsa;
	@FXML private ImageView uzivatel;
	@FXML private ImageView kratiknot;
	@FXML private ImageView hoochova;
	@FXML private ImageView prytova;
	@FXML private ImageView ron;
	@FXML private ImageView hagrid;
	
	private final Image OBR_PLAST = new Image(getClass().getResourceAsStream("plast.png"), 50, 50, false, false);
	private final Image OBR_KOSTE = new Image(getClass().getResourceAsStream("koste.png"), 50, 50, false, false);
	private final Image OBR_PONOZKA = new Image(getClass().getResourceAsStream("ponozka.png"), 50, 50, false, false);
	private final Image OBR_FLETNA = new Image(getClass().getResourceAsStream("fletna.png"), 50, 50, false, false);
	private final Image OBR_KLOBOUK = new Image(getClass().getResourceAsStream("moudry_klobouk.png"), 50, 50, false, false);
	private final Image OBR_KAMEN = new Image(getClass().getResourceAsStream("kamen.png"), 50, 50, false, false);
	private final Image OBR_KNIHA = new Image(getClass().getResourceAsStream("kniha2.png"), 50, 50, false, false);
	
	private Image [] listOfImages = {OBR_PLAST, OBR_KOSTE, OBR_PONOZKA, OBR_FLETNA, OBR_KLOBOUK, OBR_KAMEN, OBR_KNIHA};
	
	private IHra hra;
	
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(IHra hra) {
		kratiknot.setVisible(false);
		prytova.setVisible(false);
		ron.setVisible(false);
		hoochova.setVisible(false);
		hagrid.setVisible(false);
		vystup.setText(hra.vratUvitani());
		vystup.setEditable(false);
		this.hra = hra;
		seznamVeci.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeciNazev());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychodyNazev());
		seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPostavaNazev());
		dovednosti.getItems().addAll(hra.getHerniPlan().getDovednosti().seznamDovednosti());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		hra.getHerniPlan().addObserver(this);
		
	}

	/**
	 * metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho
	 */
	@FXML public void odesliPrikaz() {
		String vystupPrikazu = hra.zpracujPrikaz(vstupniText.getText());
		vystup.appendText("\n----------\n"+vstupniText.getText()+"\n----------\n");
		vystup.appendText(vystupPrikazu);
		vstupniText.setText("");
		if(hra.getHerniPlan().getAktualniProstor().jePostavaVProstoru("Ron")) {
			ron.setVisible(true);
		}
		else {
			kratiknot.setVisible(false);
			prytova.setVisible(false);
			ron.setVisible(false);
			hoochova.setVisible(false);
			hagrid.setVisible(false);
			
			if(hra.getHerniPlan().getAktualniProstor().jePostavaVProstoru("Hagrid")) {
				hagrid.setVisible(true);
			}
			else {
				kratiknot.setVisible(false);
				prytova.setVisible(false);
				ron.setVisible(false);
				hoochova.setVisible(false);
				hagrid.setVisible(false);
				
				if(hra.getHerniPlan().getAktualniProstor().jePostavaVProstoru("profesorka_Prytova")) {
					prytova.setVisible(true);
				}
				else {
					kratiknot.setVisible(false);
					prytova.setVisible(false);
					ron.setVisible(false);
					hoochova.setVisible(false);
					hagrid.setVisible(false);
					
					if(hra.getHerniPlan().getAktualniProstor().jePostavaVProstoru("profesor_Kratiknot")) {
						kratiknot.setVisible(true);
					}
					else {
						kratiknot.setVisible(false);
						prytova.setVisible(false);
						ron.setVisible(false);
						hoochova.setVisible(false);
						hagrid.setVisible(false);
						
						if(hra.getHerniPlan().getAktualniProstor().jePostavaVProstoru("profesorka_Hoochova")) {
							hoochova.setVisible(true);
						}
						else {
							kratiknot.setVisible(false);
							prytova.setVisible(false);
							ron.setVisible(false);
							hoochova.setVisible(false);
							hagrid.setVisible(false);
							
							if(hra.konecHry()) {
								vystup.appendText("\n----------\n"+hra.vratEpilog()+"\nKonec hry.\n----------\n");
								vstupniText.setDisable(true);
							}
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * metoda spouští novou hru pomocí stisku tlačítka v menu
	 */
	@FXML public void novaHra() {
		inicializuj(new Hra());
		vstupniText.setDisable(false);
		
	}
	
	/**
	 * metoda ukončuje hru pomocí stisku tlačítka v menu
	 */
	@FXML public void konecHry() {
		((Hra) hra).setKonecHry(true);
		vystup.appendText("\n----------\nUkončili jste hru pomocí tlačítka \"Konec hry\".\n----------\n"+hra.vratEpilog()+"\n----------\n");
		vstupniText.setDisable(true);
	}
	
	/**
	 * metoda zobrazí textovou nápovědu po stisknutí tlačítka "nápověda"
	 */
	@FXML public void napoveda() {
		vystup.appendText("\n----------\nZobrazil jsi nápovědu:\n----------\n"+hra.zpracujPrikaz("nápověda")+"\n----------\n");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ObservableList<String> vychodyList = FXCollections.observableArrayList();
		ObservableList<String> veciList = FXCollections.observableArrayList();
		ObservableList<String> postavyList = FXCollections.observableArrayList();
		ObservableList<String> dovednostiList = FXCollections.observableArrayList();
		 vychodyList.addAll(hra.getHerniPlan().getAktualniProstor().getVychodyNazev());
		 veciList.addAll(hra.getHerniPlan().getAktualniProstor().getVeciNazev());
		 postavyList.addAll(hra.getHerniPlan().getAktualniProstor().getPostavaNazev());
		 dovednostiList.addAll(hra.getHerniPlan().getDovednosti().seznamDovednosti());
		 seznamVychodu.getItems().clear();
		 seznamVychodu.setItems(vychodyList);
		 uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		 uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		 seznamVeci.getItems().clear();
		 seznamVeci.setItems(veciList);
		 seznamPostav.getItems().clear();
		 seznamPostav.setItems(postavyList);
		 dovednosti.getItems().clear();
		 dovednosti.setItems(dovednostiList);
		 
		 ObservableList<String> obsahKapsy = FXCollections.observableArrayList();
		 obsahKapsy.addAll(hra.getHerniPlan().getKapsa().getVeciVKapse());
		 //kapsa.getItems().clear();
		 kapsa.setItems(obsahKapsy);
	
		 kapsa.setCellFactory(param -> new ListCell<String>(){
			 private ImageView obrazek = new ImageView();
			 
			 @Override
			 public void updateItem(String vecicka, boolean empty) {
				 super.updateItem(vecicka, empty);
				 if(empty) {
					 setText(null);
					 setGraphic(null);
				 }
				 else {
					 if(vecicka.equals("neviditelny_plast")) {
						 obrazek.setImage(listOfImages[0]);
					 }
					 else if(vecicka.equals("letajici_koste")) {
						 obrazek.setImage(listOfImages[1]);
					 }
					 else if (vecicka.equals("Nevillova_ponozka")) {
						 obrazek.setImage(listOfImages[2]);
					 }
					 else if(vecicka.equals("fletna")) {
						 obrazek.setImage(listOfImages[3]);
					 }
					 else if(vecicka.equals("moudry_klobouk")) {
						 obrazek.setImage(listOfImages[4]);
					 }
					 else if(vecicka.equals("kaminek")) {
						 obrazek.setImage(listOfImages[5]);
					 }
					 else if(vecicka.equals("knizka")) {
						 obrazek.setImage(listOfImages[6]);
					 }
					 setText(vecicka);
					 setGraphic(obrazek);
					
				 }
			 }
		 });
		
	}
	
	}
		