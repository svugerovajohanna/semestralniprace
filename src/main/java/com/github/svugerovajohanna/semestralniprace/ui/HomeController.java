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
import javafx.scene.control.ListView;
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
	@FXML private ImageView uzivatel;
	
	
	private IHra hra;
	
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(IHra hra) {
		vystup.setText(hra.vratUvitani());
		vystup.setEditable(false);
		this.hra = hra;
		seznamVeci.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeciNazev());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychodyNazev());
		seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPostavaNazev());
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
		if(hra.konecHry()) {
			vystup.appendText("\n----------\n"+hra.vratEpilog()+"\nKonec hry.\n----------\n");
			vstupniText.setDisable(true);
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
		 vychodyList.addAll(hra.getHerniPlan().getAktualniProstor().getVychodyNazev());
		 veciList.addAll(hra.getHerniPlan().getAktualniProstor().getVeciNazev());
		 postavyList.addAll(hra.getHerniPlan().getAktualniProstor().getPostavaNazev());
		 seznamVychodu.getItems().clear();
		 seznamVychodu.setItems(vychodyList);
		 uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		 uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
		 seznamVeci.getItems().clear();
		 seznamVeci.setItems(veciList);
		 seznamPostav.getItems().clear();
		 seznamPostav.setItems(postavyList);
		
	}
	
	

	

}