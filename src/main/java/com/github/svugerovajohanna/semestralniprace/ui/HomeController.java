package com.github.svugerovajohanna.semestralniprace.ui;

import com.github.svugerovajohanna.semestralniprace.logika.Hra;
import com.github.svugerovajohanna.semestralniprace.logika.IHra;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Filip Vencovsky, Johanna Švugerová
 *
 */
public class HomeController extends GridPane {
	
	@FXML private TextField vstupniText;
	@FXML private TextArea vystup;
	@FXML private MenuItem novaHra;
	@FXML private MenuItem konecHry;
	
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
	
	

	

}