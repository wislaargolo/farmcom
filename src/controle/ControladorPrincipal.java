package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ControladorPrincipal implements Initializable{
	static ControladorPrincipal controller;
	
	@FXML
	Button btInicio, btFazenda, btCenario, btSimulacao;
	
	@FXML
	BorderPane borderPrincipal;
	
	@FXML
	AnchorPane anchorPrincipal;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		controller = this;
	}
	
	@FXML
	private void inicio() {
		borderPrincipal.setCenter(anchorPrincipal);
	}
	
	@FXML
	private void fazenda() {
		try 
                {
                    BorderPane fazenda = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/EditarFazenda.fxml"));
                    borderPrincipal.setCenter(fazenda);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	private void cenario() {
		try {
			BorderPane cenario = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Cenarios.fxml"));
            borderPrincipal.setCenter(cenario);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	private void simulacao() 
        {
		try {
			BorderPane simulacao = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Simulacoes.fxml"));
            borderPrincipal.setCenter(simulacao);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
