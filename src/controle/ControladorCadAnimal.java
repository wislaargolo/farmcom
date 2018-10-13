package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import modelo.Animal;
import persistencia.AnimalDAO;

public class ControladorCadAnimal implements Initializable
{
    AnimalDAO aDAO = new AnimalDAO();

    @FXML 
    TextField categoria, raça, gmd, quantidade;
    
    @FXML 
    Button voltar, adicionar, cancelar; 
    
    @FXML
    ComboBox<String> sexo;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList <String> options = 
                FXCollections.observableArrayList(
                    "M",
                    "F"
                );

        sexo.setItems(options);
    }
    
    @FXML
    private void voltar(){
       try {
			BorderPane animais = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/Animais.fxml"));
			ControladorPrincipal.controller.borderPrincipal.setCenter(animais);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
     public boolean isNumeric () {
    try {
        Double.parseDouble (gmd.getText()); 
        Integer.parseInt(quantidade.getText());
        return true;
    } catch (NumberFormatException ex) {
        return false;
    }
  }
     
    public boolean isString () {
    try {
        Integer.parseInt(categoria.getText());
        Integer.parseInt(raça.getText());
        return false;
    } catch (NumberFormatException ex) {
        return true;
    }
  }
    
    @FXML
     private void adicionar(){
          if(categoria.getText().isEmpty() || raça.getText().isEmpty() || sexo.getValue()==null || gmd.getText().isEmpty() || quantidade.getText().isEmpty()) {
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
                Animal a = new Animal(ControladorFazendas.idFazendaEdit, categoria.getText(), raça.getText(), sexo.getValue(), Double.parseDouble(gmd.getText()), Integer.parseInt(quantidade.getText()));
                aDAO.inserir(a);
                limparTextFields();
            }
        }
    }

    @FXML
    private void cancelar(){
       limparTextFields();
    }
    
    private void limparTextFields() {
    		categoria.clear();
    		raça.clear();
                gmd.clear();
                quantidade.clear();
                sexo.getSelectionModel().clearSelection(); 
    }

    
}
