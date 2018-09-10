
package controle;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.BalancoForrageiro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import modelo.Cenario;
import persistencia.CenarioDAO;

public class ControladorAnalise implements Initializable{

	BalancoForrageiro balanco;
        
        CenarioDAO cDAO = new CenarioDAO();
	
    @FXML 
    Button btEnviar,  btVoltar;
    
    @FXML
    TextField tfPesoFinal, tfAcumulo, tfSaldo, tfConsumoV;
    
    @FXML 
    NumberAxis xAxis = new NumberAxis();
    
    @FXML
    NumberAxis yAxis = new NumberAxis();
    
    @FXML 
    LineChart<Number,Number> graficoAnalise = 
                new LineChart<Number,Number>(xAxis,yAxis);
    
    @FXML
    private void enviar(){
       ControladorCenario.cenario.setPeso_final_cenario(Double.parseDouble(tfPesoFinal.getText()));
       ControladorCenario.cenario.setAcumulo_cenario(Double.parseDouble(tfAcumulo.getText()));
       ControladorCenario.cenario.setSaldo_cenario(Double.parseDouble(tfSaldo.getText()));
       ControladorCenario.cenario.setConsumo_cenario(Double.parseDouble(tfConsumoV.getText()));
       cDAO.inserir(ControladorCenario.cenario);
    }

   
    
    @FXML
    private void voltar(){
        try {
			BorderPane cenario = (BorderPane) FXMLLoader.load(getClass().getResource("/visao/CenarioProdutivo.fxml"));
			ControladorCenario.controller.preencherForm(ControladorCenario.cenario);
                        ControladorPrincipal.controller.borderPrincipal.setCenter(cenario);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	balanco = new BalancoForrageiro();
    	double[] pesoFinal = balanco.getPF();
    	double[] acumulo = balanco.getAF();
    	double[] consumo = balanco.getCv();
    	double[] saldo = balanco.getSF();
            DecimalFormat df = new DecimalFormat("0.##");
            for(int i=0; i<pesoFinal.length; i++){
             df.format(pesoFinal[i]);
            }    
    	tfPesoFinal.setText(Double.toString(pesoFinal[ControladorCenario.cenario.getQtd_dias_cenario()-1]));
    	tfAcumulo.setText(Double.toString(acumulo[ControladorCenario.cenario.getQtd_dias_cenario()-1]));
    	tfConsumoV.setText(Double.toString(consumo[ControladorCenario.cenario.getQtd_dias_cenario()-1]));
    	tfSaldo.setText(Double.toString(saldo[ControladorCenario.cenario.getQtd_dias_cenario()-1]));
        
        ObservableList<XYChart.Data<Number, Number>> data = FXCollections.<XYChart.Data<Number, Number>>observableArrayList();
            for (int i = 0; i < ControladorCenario.cenario.getQtd_dias_cenario(); i++)
                data.add(new XYChart.Data<>((i+1), saldo[i]));
            XYChart.Series series = new XYChart.Series(data);
            
        yAxis.setLabel("Saldo");
        xAxis.setLabel("Dias");
        graficoAnalise.setCreateSymbols(false);
        graficoAnalise.setLegendVisible(false);
        graficoAnalise.getData().add(series);

    	
    	//TODO montar o gráfico com os valores do vetor de saldo
    }
    
}
