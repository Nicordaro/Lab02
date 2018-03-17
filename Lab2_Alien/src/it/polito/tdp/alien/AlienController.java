package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AlienController {
	private AlienDictionary ad = new AlienDictionary();
	
	private String toTranslate;
	private String translation;
	
	private String toAddAlien;
	private String toAddNative;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtAlien;

    @FXML
    private TextField txtNative;

    @FXML
    private Button btnAdd;


    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
	    	txtResult.clear();
	    	toTranslate = txtWord.getText();
	    	translation = ad.translateWord(toTranslate);
	    	if(toTranslate.contains("?")) {
	    		txtResult.appendText("La parola da tradurre è: "+toTranslate.toUpperCase()+" "+translation);
	    	}else {
	    	txtResult.appendText("La parola da tradurre è: "+toTranslate+". La sua traduzione è: "+translation+".\n");}
	    	txtWord.clear();
    }
    

    @FXML
    void doAdd(ActionEvent event) {
    	if(txtAlien.getText().length()==0 || txtNative.getText().length()==0) {
    		txtResult.clear();
    		txtResult.appendText("\nErrore, uno dei due campi è vuoto. Controllare di aver inserito entrambe le parole e riprovare.");
    		return;
    	}
    	else {
    		txtResult.clear();
    		String inseritaAl=txtAlien.getText();
    		String inseritaNat=txtNative.getText();
    		toAddAlien=txtAlien.getText().toLowerCase();
    		toAddNative=txtNative.getText().toLowerCase();
    		ad.addWord(toAddAlien, toAddNative);
    		txtResult.appendText("\nLa traduzione è stata inserita. "+inseritaAl.toUpperCase()+" corrisponde a "+inseritaNat.toUpperCase());
    		txtAlien.clear();
    		txtNative.clear();
    	}
    	

    }

    @FXML
    void initialize() {
    	   assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
           assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
           assert txtAlien != null : "fx:id=\"txtAlien\" was not injected: check your FXML file 'Alien.fxml'.";
           assert txtNative != null : "fx:id=\"txtNative\" was not injected: check your FXML file 'Alien.fxml'.";
           assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'Alien.fxml'.";
           assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
           assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
