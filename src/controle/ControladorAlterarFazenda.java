package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import modelo.Fazenda;
import persistencia.FazendaDAO;

public class ControladorAlterarFazenda  implements Initializable{
	static ControladorAlterarFazenda controller;
		
	FazendaDAO fazendaDAO = new FazendaDAO();
	
	Fazenda f;
	
    @FXML
    TextField nome, areaTotal;
    
    @FXML 
    Button voltar, alterar, cancelar; 
    
	
   @Override
    public void initialize(URL location, ResourceBundle resources) {
	   controller = this;
    }
    
   public void preencherForm(Fazenda f) {
	   this.f = f;
	   nome.setText(f.getNome_fazenda());
	   areaTotal.setText(Double.toString(f.getArea_fazenda()));
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
    
    @FXML
    private void alterar(){
       f.setNome_fazenda(nome.getText());
       f.setArea_fazenda(Double.parseDouble(areaTotal.getText()));
       fazendaDAO.alterar(f);
       limparTextFields();
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
