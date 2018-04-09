package com.github.svugerovajohanna.semestralniprace.ui;

import java.util.Observable;
import java.util.Observer;

import com.github.svugerovajohanna.semestralniprace.logika.Hra;
import com.github.svugerovajohanna.semestralniprace.logika.IHra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionModel;
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
	@FXML private ComboBox<String> vych;
	@FXML private ComboBox<String> prik;
	
	private final Image OBR_PLAST = new Image(getClass().getResourceAsStream("plast.png"), 50, 50, false, false);
	private final Image OBR_KOSTE = new Image(getClass().getResourceAsStream("koste.png"), 50, 50, false, false);
	private final Image OBR_PONOZKA = new Image(getClass().getResourceAsStream("ponozka.png"), 50, 50, false, false);
	private final Image OBR_FLETNA = new Image(getClass().getResourceAsStream("fletna.png"), 50, 50, false, false);
	private final Image OBR_KLOBOUK = new Image(getClass().getResourceAsStream("moudry_klobouk.png"), 50, 50, false, false);
	private final Image OBR_KAMEN = new Image(getClass().getResourceAsStream("kamen.png"), 50, 50, false, false);
	private final Image OBR_KNIHA = new Image(getClass().getResourceAsStream("kniha2.png"), 50, 50, false, false);
	private final Image 	OBR_STROM = new Image(getClass().getResourceAsStream("strom.png"), 50, 50, false, false);
	private final Image OBR_KRESLO = new Image(getClass().getResourceAsStream("kreslo.png"), 50, 50, false, false);
	private final Image OBR_POSTEL = new Image(getClass().getResourceAsStream("postel.png"), 50, 50, false, false);
	private final Image OBR_OBRAZ = new Image(getClass().getResourceAsStream("obraz.png"), 50, 50, false, false);
	private final Image OBR_SOCHA = new Image(getClass().getResourceAsStream("socha.png"), 50, 50, false, false);
	private final Image OBR_STUL = new Image(getClass().getResourceAsStream("stul.png"), 50, 50, false, false);
	
	
	
	private Image [] listOfImages = {OBR_PLAST, OBR_KOSTE, OBR_PONOZKA, OBR_FLETNA, OBR_KLOBOUK, OBR_KAMEN, OBR_KNIHA, OBR_STROM, OBR_KRESLO, OBR_POSTEL, OBR_OBRAZ, OBR_SOCHA, OBR_STUL};
	
	private IHra hra;
	private String prikaz;
	
	
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(IHra hra) {
		vych.setDisable(true);
		kratiknot.setVisible(false);
		prytova.setVisible(false);
		ron.setVisible(false);
		hoochova.setVisible(false);
		hagrid.setVisible(false);
		vystup.setText(hra.vratUvitani());
		vystup.setEditable(false);
		this.hra = hra;
		seznamVeci.getItems().clear();
		seznamVeci.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeciNazev());
		
		 seznamVeci.setCellFactory(param -> new ListCell <String>() {
			 private ImageView obrazek = new ImageView();
			 @Override
			 public void updateItem(String vec, boolean empty) {
				 super.updateItem(vec, empty);
				 if(empty) {
					 setText(null);
					 setGraphic(null);
				 }
				 else {
					 if(vec.equals("neviditelny_plast")) {
						 obrazek.setImage(listOfImages[0]);
					 }
					 else if(vec.equals("letajici_koste")) {
						 obrazek.setImage(listOfImages[1]);
					 }
					 else if (vec.equals("Nevillova_ponozka")) {
						 obrazek.setImage(listOfImages[2]);
					 }
					 else if(vec.equals("fletna")) {
						 obrazek.setImage(listOfImages[3]);
					 }
					 else if(vec.equals("moudry_klobouk")) {
						 obrazek.setImage(listOfImages[4]);
					 }
					 else if(vec.equals("kaminek")) {
						 obrazek.setImage(listOfImages[5]);
					 }
					 else if(vec.equals("knizka")) {
						 obrazek.setImage(listOfImages[6]);
					 }
					 else if(vec.equals("strom")) {
						 obrazek.setImage(listOfImages[7]);
						 
					 }
					 else if(vec.equals("kreslo")){
						obrazek.setImage(listOfImages[8]);
					 }
					 else if(vec.equals("postel")) {
						 obrazek.setImage(listOfImages[9]);
					 }
					 else if(vec.equals("obraz")) {
						 obrazek.setImage(listOfImages[10]);
					 }
					 else if(vec.equals("socha")) {
						 obrazek.setImage(listOfImages[11]);
					 }
					 else if(vec.equals("stul")) {
						 obrazek.setImage(listOfImages[12]);
					 }
					 setText(vec);
					 setGraphic(obrazek);
				 }
			 }
			 
		 });
		 
		seznamVychodu.getItems().clear();
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychodyNazev());
		seznamPostav.getItems().clear();
		seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPostavaNazev());
		dovednosti.getItems().clear();
		dovednosti.getItems().addAll(hra.getHerniPlan().getDovednosti().seznamDovednosti());
		kapsa.getItems().clear();
		kapsa.getItems().addAll(hra.getHerniPlan().getKapsa().getVeciVKapse());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		hra.getHerniPlan().addObserver(this);
		
	}

	/**
	 * metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho
	 */
	@FXML public void odesliPrikaz() {
		String vstupPrikazu = vstupniText.getText();
		if(prikaz != null ){
			prikaz += " " + vstupPrikazu;
			vstupPrikazu = prikaz;
		}
		String vystupPrikazu = hra.zpracujPrikaz(vstupPrikazu);
		prik.getSelectionModel().clearSelection();
		vystup.appendText("\n----------\n"+ vstupPrikazu +"\n----------\n");
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
	
	@FXML public void prirucka() {
		Stage stage = new Stage ();
		stage.setTitle("Uživatelská příručka");
		
		WebView webView = new WebView();
		webView.getEngine().load(getClass().getResource("prirucka.html").toExternalForm());
		stage.setScene(new Scene(webView, 800, 600));
		stage.show();
		
	}
	
	@FXML public void comboPrikaz() {
		vstupniText.clear();
		if(prik.getValue() != null) {
			prikaz = prik.getSelectionModel().getSelectedItem().toString();
			if(prikaz.equals("jdi")) {
			vych.setDisable(false);
			prik.setDisable(true);	
			}
			else if (prik.getValue() != null){
				String vystupPrikazu = hra.zpracujPrikaz(prikaz);
				vystup.appendText("\n----------\n"+ prikaz+"\n----------\n");
				vystup.appendText(vystupPrikazu);
				prikaz = null;
			}
		}
		
		
	}
	
	@FXML public void comboVychod() {
		prikaz += " " + vych.getSelectionModel().getSelectedItem().toString();
		vystup.appendText("\n----------\n"+prikaz+"\n----------\n");
		vystup.appendText(hra.zpracujPrikaz(prikaz));
		prik.getSelectionModel().clearSelection();
		vstupniText.clear();
		prik.setDisable(false);
		vych.setDisable(true);
		prikaz = null;
		
		

		
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
		 
		 seznamPostav.setCellFactory(param -> new ListCell<String>(){
			 private ImageView obrazek = new ImageView();
			 
			 @Override
			 public void updateItem(String post, boolean empty) {
				 super.updateItem(post, empty);
				 if(empty) {
					 setText(null);
					 setGraphic(null);
				 }
				 else {
					 if(post.equals("Hagrid")) {
						 obrazek.setImage(hagrid.getImage());
						 
					 }
					 else if(post.equals("profesorka_Prytova")){
						 obrazek.setImage(prytova.getImage());
					 }
					 else if(post.equals("profesorka_Hoochova")) {
						 obrazek.setImage(hoochova.getImage());
					 }
					 else if(post.equals("profesor_Kratiknot")) {
						 obrazek.setImage(kratiknot.getImage());
					 }
					 else if(post.equals("Ron")) {
						 obrazek.setImage(ron.getImage());
					 }
					 obrazek.setFitHeight(61);
					 obrazek.setFitWidth(47);
					 setText(post);
					 setGraphic(obrazek);
				 }
			 
			 }}); 
		 
		 dovednosti.getItems().clear();
		 dovednosti.setItems(dovednostiList);
		 
		 ObservableList<String> obsahKapsy = FXCollections.observableArrayList();
		 obsahKapsy.addAll(hra.getHerniPlan().getKapsa().getVeciVKapse());
		 kapsa.getItems().clear();
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
		