
package controle;

import javafx.fxml.Initializable;
import modelo.Cenario;
import persistencia.CenarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class ControladorCenarios implements Initializable{
    CenarioDAO cDAO = new CenarioDAO();
    ObservableList<Cenario> lista = FXCollections.observableArrayList();
    
    @FXML
    TableView<Cenario> cenarios;
    
    @FXML
    TableColumn <Cenario, String> fazenda;
    
    @FXML
    TableColumn<Cenario, String> animal;
    
    @FXML
    TableColumn <Cenario, String> forragem;
    
    @FXML
    TableColumn <Cenario, Integer> qtdDias;
    
    @FXML
    TableColumn <Cenario, Integer> qtdAnimais;
    
     @FXML
    TableColumn <Cenario, Double> massa;
     
    @FXML
    TableColumn <Cenario, Double> peso;
    
    @FXML
    TableColumn <Cenario, Double> saldo;
    
    @FXML
    Button  adicionar, remover; 


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshTabela();
    }

    private void refreshTabela() {
    		lista.clear();
                ArrayList<Cenario> temp = cDAO.relatorio();
                for(Cenario c : temp){
                    c.dados();
                }
                lista.addAll(temp);
                
    		cenarios.setItems(lista);
                fazenda.setCellValueFactory(new PropertyValueFactory<Cenario, String>("Nome_fazenda"));
    		animal.setCellValueFactory(new PropertyValueFactory<Cenario, String>("Raca_animal"));
    		forragem.setCellValueFactory(new PropertyValueFactory<Cenario, String>("especieForragem"));
    		qtdDias.setCellValueFactory(new PropertyValueFactory<Cenario, Integer>("Qtd_dias_cenario"));
                qtdAnimais.setCellValueFactory(new PropertyValueFactory<Cenario, Integer>("Qtd_animais_cenario"));
                saldo.setCellValueFactory(new PropertyValueFactory<Cenario, Double>("Saldo_cenario"));
                massa.setCellValueFactory(new PropertyValueFactory<Cenario, Double>("Massa_inicial_cenario"));
                peso.setCellValueFactory(new PropertyValueFactory<Cenario, Double>("Peso_inicial_animais"));        
    }
    
    
    @FXML
    private void adicionar(){
       try {
			BorderPane adicionar = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/CenarioProdutivo.fxml"));
			ControladorPrincipal.controller.borderPrincipal.setCenter(adicionar);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void remover(){
        cDAO.excluir(cenarios.getSelectionModel().getSelectedItem());
        int indice = cenarios.getSelectionModel().getSelectedIndex();
		cenarios.getItems().remove(indice);
     
    }
    
    
}
