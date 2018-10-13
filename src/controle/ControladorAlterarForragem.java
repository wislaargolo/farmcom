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
import modelo.Forragem;
import persistencia.ForragemDAO;

public class ControladorAlterarForragem  implements Initializable{
	static ControladorAlterarForragem controller;
		
	ForragemDAO forragemDAO = new ForragemDAO();
	
	Forragem f;
	
    @FXML
    TextField especie, taxaAcumulo;
    
    @FXML 
    Button btVoltar, btAlterar, btCancelar; 
    
	
   @Override
    public void initialize(URL location, ResourceBundle resources) {
	   controller = this;
    }
    
   public void preencherForm(Forragem f) {
	   this.f = f;
	   especie.setText(f.getEspecie_forragem());
	   taxaAcumulo.setText(Double.toString(f.getTaxa_acumulo_forragem()));
   }
   
    @FXML
    private void voltar(){
        try 
        {
            BorderPane forragem = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Forragem.fxml"));			
            ControladorPrincipal.controller.borderPrincipal.setCenter(forragem);
                        
	} catch (IOException e) 
        {
            e.printStackTrace();
	}	
    }
    
     public boolean isNumeric () {
    try {
        Double.parseDouble (taxaAcumulo.getText()); 
        return true;
    } catch (NumberFormatException ex) {
        return false;
    }
  }
     public boolean isString () {
    try {
        Integer.parseInt(especie.getText());
        return false;
    } catch (NumberFormatException ex) {
        return true;
    }
  }
    
    @FXML
    private void alterar()
    {
        if(especie.getText().isEmpty() || taxaAcumulo.getText().isEmpty()) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Atenção");
		alert.setHeaderText("Algum campo está em branco");
		alert.setContentText("Preencha os campos");
		alert.showAndWait();
        }else{
            if(isNumeric()==false || isString()==false){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Atenção");
		alert.setHeaderText("Erro de valor em algum campo");
		alert.setContentText("Preencha os campos com valores válidos");
		alert.showAndWait();
            }else{ 
                f.setEspecie_forragem(especie.getText());
                f.setTaxa_acumulo_forragem(Double.parseDouble(taxaAcumulo.getText()));
                forragemDAO.alterar(f);
                limparTextFields();
            }

        }
    }

    @FXML
    private void cancelar()
    {
    	limparTextFields();
    }

    private void limparTextFields() 
    {
    		especie.clear();
    		taxaAcumulo.clear();
    }
    
}
