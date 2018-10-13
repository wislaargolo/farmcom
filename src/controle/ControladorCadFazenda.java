package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import modelo.Fazenda;
import persistencia.FazendaDAO;

public class ControladorCadFazenda  implements Initializable{

	FazendaDAO fazendaDAO = new FazendaDAO();
	
    @FXML
    TextField nome, areaTotal;
    
    @FXML 
    Button voltar, adicionar, cancelar; 
    
	
   @Override
    public void initialize(URL location, ResourceBundle resources) {
	   
    }
    
    @FXML
    private void voltar(){
        try {
			BorderPane fazendas = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Fazendas.fxml"));
			
                        ControladorPrincipal.controller.borderPrincipal.setCenter(fazendas);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    public boolean isNumeric () {
    try {
        Double.parseDouble (areaTotal.getText()); 
        return true;
    } catch (NumberFormatException ex) {
        return false;
    }
}
    
    @FXML
    private void adicionar(){
        if(nome.getText().isEmpty() || areaTotal.getText().isEmpty()) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Atenção");
		alert.setHeaderText("Algum campo está em branco");
		alert.setContentText("Preencha os campos");
		alert.showAndWait();
        }else{
            if(isNumeric()==false){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Atenção");
		alert.setHeaderText("Erro no campo 'Área da Fazenda'");
		alert.setContentText("Preencha 'Área da Fazenda' com um valor válido");
		alert.showAndWait();
            }else{
                Fazenda f = new Fazenda(nome.getText(), Double.parseDouble (areaTotal.getText()));
                fazendaDAO.inserir(f);
                limparTextFields();
            }
        }
    }

    @FXML
    private void cancelar(){
    	limparTextFields();
    }

    private void limparTextFields() {
    		nome.clear();
    		areaTotal.clear();
    }
    
}
