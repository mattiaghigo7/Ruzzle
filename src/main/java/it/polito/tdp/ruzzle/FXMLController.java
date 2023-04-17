package it.polito.tdp.ruzzle;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import it.polito.tdp.ruzzle.model.Model;
import it.polito.tdp.ruzzle.model.Pos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model ; 
	
	//corrispondenza bottoni dell'interfaccia grafica <-> caselle della Board 
	private Map<Pos,Button> letters ;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnProva"
    private Button btnProva; // Value injected by FXMLLoader

    @FXML // fx:id="let00"
    private Button let00; // Value injected by FXMLLoader

    @FXML // fx:id="let01"
    private Button let01; // Value injected by FXMLLoader

    @FXML // fx:id="let02"
    private Button let02; // Value injected by FXMLLoader

    @FXML // fx:id="let03"
    private Button let03; // Value injected by FXMLLoader

    @FXML // fx:id="let10"
    private Button let10; // Value injected by FXMLLoader

    @FXML // fx:id="let11"
    private Button let11; // Value injected by FXMLLoader

    @FXML // fx:id="let12"
    private Button let12; // Value injected by FXMLLoader

    @FXML // fx:id="let13"
    private Button let13; // Value injected by FXMLLoader

    @FXML // fx:id="let20" 
    private Button let20; // Value injected by FXMLLoader

    @FXML // fx:id="let21"
    private Button let21; // Value injected by FXMLLoader

    @FXML // fx:id="let22"
    private Button let22; // Value injected by FXMLLoader

    @FXML // fx:id="let23"
    private Button let23; // Value injected by FXMLLoader

    @FXML // fx:id="let30"
    private Button let30; // Value injected by FXMLLoader

    @FXML // fx:id="let31"
    private Button let31; // Value injected by FXMLLoader

    @FXML // fx:id="let32"
    private Button let32; // Value injected by FXMLLoader

    @FXML // fx:id="let33"
    private Button let33; // Value injected by FXMLLoader

    @FXML // fx:id="txtStatus"
    private Label txtStatus; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtResul"
    private TextArea txtResult; // Value injected by FXMLLoader


    @FXML
    void handleProva(ActionEvent event) {
    	for (Pos p : letters.keySet()) {
    		letters.get(p).setDefaultButton(false);
    	}
    	String parola = txtParola.getText() ;
    	if(parola.length() <= 1) {
    		txtResult.setText("Devi inserire parole di almeno 2 lettere");
    		return;
    	}
    	parola = parola.toUpperCase();
    	//controllo che ci siano solo caratteri A-Z
    	if(!parola.matches("[A-Z]+")) {
    		txtResult.setText("Devi inserire solo caratteri alfabetici!");
    		return ;
    	}
    	
    	List<Pos> posizioni = this.model.trovaParola(parola);
    	if(posizioni!=null) {
    		for(Pos p : posizioni) {
    			letters.get(p).setDefaultButton(true);
    		}
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {
    	model.reset();
    	for (Pos p : letters.keySet()) {
    		letters.get(p).setDefaultButton(false);
    	}
    }
    
    @FXML
    void handleRisolvi(ActionEvent event) {
    	this.txtResult.clear();
    	List<String> paroleTrovate = model.trovaTutte();
    	this.txtResult.appendText("Ho trovato "+paroleTrovate.size()+" parole\n");
    	for (String parola : paroleTrovate) {
    		this.txtResult.appendText(parola+"\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let00 != null : "fx:id=\"let00\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let01 != null : "fx:id=\"let01\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let02 != null : "fx:id=\"let02\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let03 != null : "fx:id=\"let03\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let10 != null : "fx:id=\"let10\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let11 != null : "fx:id=\"let11\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let12 != null : "fx:id=\"let12\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let13 != null : "fx:id=\"let13\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let20 != null : "fx:id=\"let20\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let21 != null : "fx:id=\"let21\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let22 != null : "fx:id=\"let22\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let23 != null : "fx:id=\"let23\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let30 != null : "fx:id=\"let30\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let31 != null : "fx:id=\"let31\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let32 != null : "fx:id=\"let32\" was not injected: check your FXML file 'Scene.fxml'.";
        assert let33 != null : "fx:id=\"let33\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStatus != null : "fx:id=\"txtStatus\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m) {
    	this.model = m ;
    	
    	this.letters = new HashMap<>() ;
    	
    	this.letters.put(new Pos(0,0), let00) ;
    	this.letters.put(new Pos(0,1), let01) ;
    	this.letters.put(new Pos(0,2), let02) ;
    	this.letters.put(new Pos(0,3), let03) ;
    	
    	this.letters.put(new Pos(1,0), let10) ;
    	this.letters.put(new Pos(1,1), let11) ;
    	this.letters.put(new Pos(1,2), let12) ;
    	this.letters.put(new Pos(1,3), let13) ;

    	this.letters.put(new Pos(2,0), let20) ;
    	this.letters.put(new Pos(2,1), let21) ;
    	this.letters.put(new Pos(2,2), let22) ;
    	this.letters.put(new Pos(2,3), let23) ;
    	
    	this.letters.put(new Pos(3,0), let30) ;
    	this.letters.put(new Pos(3,1), let31) ;
    	this.letters.put(new Pos(3,2), let32) ;
    	this.letters.put(new Pos(3,3), let33) ;

    	//BINDNG: associo ad ogni bottone la StringProperty della relativa cella
    	for(Pos cell: m.getBoard().getPositions()) {
    		this.letters.get(cell).textProperty().bind(m.getBoard().getCellValueProperty(cell));
    	}
    	
    	this.txtStatus.textProperty().bind(m.statusTextProperty());
    	
    }
}
