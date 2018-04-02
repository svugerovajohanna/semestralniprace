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
	 * metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho
	 */
	
	public void inicializuj(IHra hra) {
		vystup.setText(hra.vratUvitani());
		vystup.setEditable(false);
		this.hra = hra;
		
	}

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
	
	@FXML public void novaHra() {
		inicializuj(new Hra());
	}
	
	@FXML public void konecHry() {
		((Hra) hra).setKonecHry(true);
		vystup.appendText("\n----------\n"+hra.vratEpilog()+"\nUkončili jste hru pomocí tlačítka \"Konec hry\".\n----------\n");
		vstupniText.setDisable(true);
	}
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	

}