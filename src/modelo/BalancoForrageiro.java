
package modelo;

import controle.ControladorCenario;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class BalancoForrageiro {
	private int numdias;
	private double[] cv, PF, AF, SF;

	public BalancoForrageiro() {
		this.numdias = ControladorCenario.cenario.getQtd_dias_cenario();
		cv = new double[numdias];
		PF = new double[numdias];
		AF = new double[numdias];
		SF = new double[numdias];
		PesoFinal(ControladorCenario.cenario.getPeso_inicial_animais(), ControladorCenario.animal.getGMD_animal());
		AcumuloForragem(ControladorCenario.cenario.getMassa_inicial_cenario(), ControladorCenario.forragem.getTaxa_acumulo_forragem());
		Consumo(ControladorCenario.cenario.getQtd_animais_cenario(), ControladorCenario.animal.getGMD_animal());
		SaldoForragem(ControladorCenario.cenario.getMassa_inicial_cenario(), ControladorCenario.forragem.getTaxa_acumulo_forragem());
          
	}

	private void PesoFinal(double pesoInicial, double gmd) {
		PF[0] = pesoInicial;
		for (int i = 1; i < numdias; i++) {
			PF[i] = PF[i - 1] + gmd;
		}
            
	}

	private void Consumo(int numanimais, double gmd) {

		for (int i = 0; i < numdias; i++) {
			cv[i] = 0.311 + ((0.0197 * PF[i]) + (0.682 * gmd));
			cv[i] *= numanimais;
		}
		
	}

	private void AcumuloForragem(double qtdForragem, double txAcumulo) {
		AF[0] = qtdForragem + txAcumulo;
		for (int i = 1; i < numdias; i++) {
			AF[i] = AF[i - 1] + txAcumulo;
		}

	}

	private void SaldoForragem(double qtdForragem, double txAcumulo) {
		SF[0] = qtdForragem + txAcumulo - cv[0];
		for (int i = 1; i < numdias; i++) {
			SF[i] = SF[i - 1] + txAcumulo - cv[i];
		}

	}

	public int getNumdias() {
		return numdias;
	}

	public void setNumdias(int numdias) {
		this.numdias = numdias;
	}

	public double[] getCv() {
		return cv;
	}

	public void setCv(double[] cv) {
		this.cv = cv;
	}

	public double[] getPF() {
		return PF;
	}

	public void setPF(double[] pF) {
		PF = pF;
	}

	public double[] getAF() {
		return AF;
	}

	public void setAF(double[] aF) {
		AF = aF;
	}

	public double[] getSF() {
		return SF;
	}

	public void setSF(double[] sF) {
		SF = sF;
	}
	
	

}
