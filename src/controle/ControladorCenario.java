package controle;



import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Animal;
import modelo.Cenario;
import modelo.Fazenda;
import modelo.Forragem;
import persistencia.AnimalDAO;
import persistencia.FazendaDAO;
import persistencia.ForragemDAO;

public class ControladorCenario implements Initializable{
    
    ObservableList<Animal> nomeA = FXCollections.observableArrayList();
    ObservableList<Fazenda> nomeFa = FXCollections.observableArrayList();
    ObservableList<Forragem> nomeFo = FXCollections.observableArrayList();
    
    AnimalDAO aDAO = new AnimalDAO();
    FazendaDAO faDAO = new FazendaDAO();
    ForragemDAO foDAO = new ForragemDAO();
    
    
    public static Cenario cenario;
    public static Animal animal;
    public static Forragem forragem;
    
    static ControladorCenario controller;
    Cenario c;
    
    @FXML 
    ComboBox<Fazenda> cbFazenda;
    
    @FXML
    ComboBox<Animal> cbAnimais;
    
    @FXML
    ComboBox<Forragem> cbForragem;
    
    @FXML
    DatePicker dataInicio;
    
    @FXML
    Button btGerar;
    
    @FXML
    TextField tfDias, tfQtdAnimais, tfMassaInicial, tfPesoInicial;
    
     public void preencherForm(Cenario c) {
	   this.c = c;
	   tfDias.setText(Integer.toString(c.getQtd_dias_cenario()));
	   tfQtdAnimais.setText(Integer.toString(c.getQtd_animais_cenario()));
           tfMassaInicial.setText(Double.toString(c.getMassa_inicial_cenario()));
           tfPesoInicial.setText(Double.toString(c.getPeso_inicial_animais()));
           cbFazenda.setValue(faDAO.buscarID(c.getId_fazenda())); 
           cbAnimais.setValue(aDAO.buscarID(c.getId_animal()));
           cbForragem.setValue(foDAO.buscarID(c.getId_forragem()));
           dataInicio.setValue(c.getData_inicio_cenario().toLocalDate());
   }

    @FXML
    private void gerar(){
    	int idFazenda = cbFazenda.getSelectionModel().getSelectedItem().getId_fazenda();
    	animal = cbAnimais.getSelectionModel().getSelectedItem();
    	forragem = cbForragem.getSelectionModel().getSelectedItem();
    	Date data = Date.valueOf(dataInicio.getValue());
    	int qtdDias = Integer.parseInt(tfDias.getText());
    	int qtdAnimais = Integer.parseInt(tfQtdAnimais.getText());
    	double massaInicial = Double.parseDouble(tfMassaInicial.getText());
    	double pesoInicial = Double.parseDouble(tfPesoInicial.getText());
    	cenario = new Cenario(idFazenda, animal.getId_animal(), forragem.getId_forragem(), data, qtdDias, qtdAnimais, massaInicial, pesoInicial );
        try {
			BorderPane analise = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/AnaliseCenario.fxml"));
			
                        ControladorPrincipal.controller.borderPrincipal.setCenter(analise);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}	
      
    }
    
    public void refreshCombobox(Fazenda f){
        nomeA.clear();
        nomeFo.clear();
        nomeA.addAll(aDAO.relatorio(f.getId_fazenda()));
        nomeFo.addAll(foDAO.relatorio(f.getId_fazenda()));
        cbAnimais.setItems(nomeA);
        cbForragem.setItems(nomeFo);
    }
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = this;  
        nomeFa.addAll(faDAO.relatorio());
        cbFazenda.setItems(nomeFa);
		
		cbFazenda.setOnAction(new EventHandler<ActionEvent>() { 

			@Override
			public void handle(ActionEvent arg0) {
				Fazenda f = cbFazenda.getSelectionModel().getSelectedItem();
				refreshCombobox(f);
			}
			
		});
    }
    
}
