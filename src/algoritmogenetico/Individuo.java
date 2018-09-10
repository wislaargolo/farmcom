package algoritmogenetico;

import java.util.Arrays;
import java.util.Random;

public class Individuo{
	private Random random = new Random();
	
	private int idIndividuo;
	private int qtdDias;
	private int numeroAnimais;
	private double aptidao;

	
	
	public Individuo() {
		
		do {
			this.setNumeroAnimais();
			this.setQtdDias();
			avaliar();
		} while (aptidao < 0);
	}

	// cria um individuo com os genes definidos
	public Individuo(double[] genes) {
		this.setNumeroAnimais(genes[0]);
		this.setQtdDias((int) genes[1]);

		// se for mutar, cria um gene aleatorio
		if (random.nextDouble() <= Genetico.getTaxaDeMutacao()) {
			int posAleatoria = random.nextInt(genes.length);
			int cont = 0;
			do {
				if (posAleatoria == 0) {
					this.setNumeroAnimais();
				} else if (posAleatoria == 1) {
					this.setQtdDias();
				}
				avaliar();
				if (aptidao >= 0)
					break;
				//se realizar a mutacao 10 vezes e nao conseguir uma solucao valida, volta ao original
				else if (cont++ > 10) {
					if (posAleatoria == 0) {
						this.setNumeroAnimais(genes[0]);
					} else if (posAleatoria == 1) {
						this.setQtdDias((int) genes[1]);
					}
					break;
				}
			} while (true);
		}
		avaliar();
	}

	public void setNumeroAnimais(double numeroAnimais) {
		this.numeroAnimais = (int) numeroAnimais;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}

	public void setNumeroAnimais() {
		this.numeroAnimais = 1 + random.nextInt(Genetico.qtdMaxAnimais);
	}

	private void setQtdDias() {
		this.qtdDias = 1 + random.nextInt(Genetico.qtdMaxDias);

	}

	public double getAptidao() {
		return aptidao;
	}

	public double[] getGenes() {
		return new double[] { numeroAnimais, qtdDias };
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public int getNumeroAnimais() {
		return numeroAnimais;
	}
	
	public void setIdIndividuo(int idIndividuo) {
		this.idIndividuo = idIndividuo;
	}

	public int getIdIndividuo() {
		return idIndividuo;
	}

	/**
	 * Executa o planejamento forrageiro para a quantidade de dias definido
	 * Calcula o consumo diario para cada animal e para todos os animais Calcula
	 * o saldo da forragem ao final do dia Calcula o peso do animal ao final do
	 * dia
	 */
	public void avaliar() {
		double massaForragem = Genetico.massaForragemInicial;
		double pesoMedio = Genetico.pesoMedioInicial;
		double consumoVoluntario = 0;

		for (int i = 1; i <= qtdDias; i++) {
			consumoVoluntario = (0.311 + (0.0197 * pesoMedio + (0.682 * Genetico.ganhoPesoDiario)));
			consumoVoluntario *= numeroAnimais;
			massaForragem += Genetico.taxaMediaDeAcumulo - consumoVoluntario; // saldo
			pesoMedio += Genetico.ganhoPesoDiario;
		}
		this.aptidao = massaForragem;
	}

	
	
	@Override
	public String toString() {
		return "Cromossomo " + Arrays.toString(getGenes()) + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aptidao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numeroAnimais;
		result = prime * result + qtdDias;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individuo other = (Individuo) obj;
		if (Double.doubleToLongBits(aptidao) != Double.doubleToLongBits(other.aptidao))
			return false;
		if (numeroAnimais != other.numeroAnimais)
			return false;
		if (qtdDias != other.qtdDias)
			return false;
		return true;
	}
}
