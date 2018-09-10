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
import modelo.Forragem;
import persistencia.ForragemDAO;

public class ControladorForragem implements Initializable
{
    
    ForragemDAO forragemDAO = new ForragemDAO();
	
	ObservableList<Forragem> lista = FXCollections.observableArrayList();
    
    
    @FXML
    Button btAdicionar, btRemover, btAlterar, btVoltar;
    
    @FXML
    TableView<Forragem> tvForragens;
    
    @FXML
    TableColumn<Forragem, String> tcEspecie;
    
    @FXML
    TableColumn<Forragem, Double> tcAcumulo;
    

    private void refreshTabela()
    {
        lista.clear();
        lista.addAll(forragemDAO.relatorio(ControladorFazendas.idFazendaEdit));
        tvForragens.setItems(lista);
        tcEspecie.setCellValueFactory(new PropertyValueFactory<Forragem, String>("Especie_forragem"));
        tcAcumulo.setCellValueFactory(new PropertyValueFactory<Forragem, Double>("Taxa_acumulo_forragem"));       
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        refreshTabela();
    }
    
    @FXML
    private void voltar(){
        try {
			BorderPane editar = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/EditarFazenda.fxml"));
			ControladorPrincipal.controller.borderPrincipal.setCenter(editar);
                        
		} catch (IOException e) 
                {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void adicionar()
    {
       try {
		BorderPane cadastroForragem = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/CadastroForragem.fxml"));
		ControladorPrincipal.controller.borderPrincipal.setCenter(cadastroForragem);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void remover(){
        forragemDAO.excluir(tvForragens.getSelectionModel().getSelectedItem());
        int indice = tvForragens.getSelectionModel().getSelectedIndex();
		tvForragens.getItems().remove(indice);
    }
    
    @FXML
    private void alterar(){
        try {
		BorderPane alterar = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/AlterarForragem.fxml"));
                Forragem f = tvForragens.getSelectionModel().getSelectedItem();
	   		ControladorAlterarForragem.controller.preencherForm(f);
		ControladorPrincipal.controller.borderPrincipal.setCenter(alterar);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    
}
