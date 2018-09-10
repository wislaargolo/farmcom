
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
import modelo.Fazenda;
import persistencia.FazendaDAO;

public class ControladorFazendas implements Initializable {
	static int idFazendaEdit;
	
	FazendaDAO fazendaDAO = new FazendaDAO();

	ObservableList<Fazenda> lista = FXCollections.observableArrayList();

	@FXML
	TableView<Fazenda> fazendas;

	@FXML
	TableColumn<Fazenda, Integer> idFazenda;

	@FXML
	TableColumn<Fazenda, String> nomeDaFazenda;

	@FXML
	TableColumn<Fazenda, Double> areaTotal;

	@FXML
	Button adicionar, alterar, remover;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refreshTabela();
		fazendas.setOnMouseClicked(event -> {
			if (event.getClickCount() > 1) {
				idFazendaEdit = fazendas.getSelectionModel().getSelectedItem().getId_fazenda();
				try {
					BorderPane editFazenda = (BorderPane) FXMLLoader
							.load(getClass().getResource("/visao/EditarFazenda.fxml"));
					ControladorPrincipal.controller.borderPrincipal.setCenter(editFazenda);	
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void refreshTabela() {
		lista.clear();
		lista.addAll(fazendaDAO.relatorio());
		fazendas.setItems(lista);
		idFazenda.setCellValueFactory(new PropertyValueFactory<Fazenda, Integer>("Id_fazenda"));
		nomeDaFazenda.setCellValueFactory(new PropertyValueFactory<Fazenda, String>("Nome_fazenda"));
		areaTotal.setCellValueFactory(new PropertyValueFactory<Fazenda, Double>("Area_fazenda"));
	}

	@FXML
	private void adicionar() {
		try {
			BorderPane Cadfazenda = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/CadastroFazenda.fxml"));
			ControladorPrincipal.controller.borderPrincipal.setCenter(Cadfazenda);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void remover() {
		fazendaDAO.excluir(fazendas.getSelectionModel().getSelectedItem());
		int indice = fazendas.getSelectionModel().getSelectedIndex();
		fazendas.getItems().remove(indice);
	}

	@FXML
	private void alterar() {
		try {
			BorderPane editar = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/AlterarFazenda.fxml"));
			Fazenda f = fazendas.getSelectionModel().getSelectedItem();
			ControladorAlterarFazenda.controller.preencherForm(f);
			ControladorPrincipal.controller.borderPrincipal.setCenter(editar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
