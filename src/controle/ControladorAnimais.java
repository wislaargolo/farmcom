package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import modelo.Animal;
import persistencia.AnimalDAO;


public class ControladorAnimais implements Initializable{
    
    AnimalDAO aDAO = new AnimalDAO();
    ObservableList<Animal> lista = FXCollections.observableArrayList();
    
    @FXML
    TableView<Animal> animais;
    
    @FXML
    TableColumn <Animal, String> categoria;
    
    @FXML
    TableColumn<Animal, String> raca;
    
    @FXML
    TableColumn <Animal, String> sexo;
    
    @FXML
    TableColumn <Animal, Double> gmd;
    
    @FXML
    TableColumn <Animal, Integer> quantidade;
    
    @FXML
    Button voltar, adicionar, alterar, remover; 


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshTabela();
    }

    private void refreshTabela() {
    		lista.clear();
    		lista.addAll(aDAO.relatorio(ControladorFazendas.idFazendaEdit));
    		animais.setItems(lista);
                categoria.setCellValueFactory(new PropertyValueFactory<Animal, String>("Categoria_animal"));
    		raca.setCellValueFactory(new PropertyValueFactory<Animal, String>("Raca_animal"));
    		sexo.setCellValueFactory(new PropertyValueFactory<Animal, String>("Sexo_animal"));
    		gmd.setCellValueFactory(new PropertyValueFactory<Animal, Double>("GMD_animal"));
                quantidade.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("Quantidade_animal"));
    }
    
    @FXML
    private void voltar(){
        try {
			BorderPane editar = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/EditarFazenda.fxml"));
			ControladorPrincipal.controller.borderPrincipal.setCenter(editar);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void adicionar(){
       try {
			BorderPane adicionar = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/CadastroAnimal.fxml"));
			ControladorPrincipal.controller.borderPrincipal.setCenter(adicionar);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void remover(){
        aDAO.excluir(animais.getSelectionModel().getSelectedItem());
        int indice = animais.getSelectionModel().getSelectedIndex();
		animais.getItems().remove(indice);
     
    }
    
    @FXML
    private void alterar(){
       try {
			BorderPane editar = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/AlterarAnimal.fxml"));
			Animal a = animais.getSelectionModel().getSelectedItem();
	   		ControladorAlterarAnimal.controller.preencherForm(a);
			ControladorPrincipal.controller.borderPrincipal.setCenter(editar);
                        } catch (IOException e) {
			e.printStackTrace();
		}
    }

   
    
}
