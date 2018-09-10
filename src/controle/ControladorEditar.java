package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class ControladorEditar implements Initializable{
    @FXML
    Button btAnimaisFazenda, btForragemFazenda, btVoltar;
    
    
    @FXML
    private void voltar(){
        try {
			BorderPane fazendas = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Fazendas.fxml"));
			
                        ControladorPrincipal.controller.borderPrincipal.setCenter(fazendas);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    @FXML
    private void mostrarAnimais(){
       try {
			BorderPane animais = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Animais.fxml"));
			
                        ControladorPrincipal.controller.borderPrincipal.setCenter(animais);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    @FXML
    private void mostrarForragem(){
       try {
			BorderPane forragem = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Forragem.fxml"));
			
                        ControladorPrincipal.controller.borderPrincipal.setCenter(forragem);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
    }
    
}
