package algoritmogenetico;

import java.util.Random;

public class Genetico {
	private Random r = new Random();
	private static final double taxaDeCrossover = 0.9;
	private static final double taxaDeMutacao = 0.5;
	private final boolean elitismo = true;
	private final int tamPopulacao = 100;
	private final static int numMaxGeracoes = 1000;

	static double massaForragemInicial;
	static double taxaMediaDeAcumulo;
	static double pesoMedioInicial;
	static double ganhoPesoDiario;

	static int qtdMaxAnimais;
	static int qtdMaxDias;
	
	private Populacao populacao = new Populacao(tamPopulacao);

	public Populacao gerarNovaGeracao(Populacao populacao, boolean elitismo) {

		Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());

		if (elitismo) {
			novaPopulacao.setIndividuo(populacao.getIndividuo(0));
		}

		// insere novos individuos na nova populacao, ate atingir o tamanho maximo
		while (novaPopulacao.getNumIndividuos() < novaPopulacao.getTamPopulacao()) {
			// seleciona os 2 pais por torneio
			Individuo[] pais = selecaoTorneioBinario(populacao);

			Individuo[] filhos = new Individuo[2];

			// verifica ha taxa de crossover, se sim realiza o crossover, se
			// nao, mantem os pais selecionados para a proxima geracao
			if (r.nextDouble() <= taxaDeCrossover) {
				filhos = crossover(pais);
			} else {
				filhos[0] = new Individuo(pais[0].getGenes());
				filhos[1] = new Individuo(pais[1].getGenes());
			}

			// adiciona os filhos na nova geracao
			// Caso soh tenha mais uma vaga
			if (novaPopulacao.getTamPopulacao() - novaPopulacao.getNumIndividuos() >= 2) {
				novaPopulacao.setIndividuo(filhos[0]);
				novaPopulacao.setIndividuo(filhos[1]);
			} else if (filhos[0].getAptidao() > filhos[1].getAptidao()) {
				novaPopulacao.setIndividuo(filhos[0]);
			} else {
				novaPopulacao.setIndividuo(filhos[1]);
			}
		}
		novaPopulacao.ordenaPopulacao();
		return novaPopulacao;
	}

	public Individuo[] selecaoTorneioBinario(Populacao populacao) {
		Individuo[] pais = new Individuo[2];
		int a, b;
		for (int i = 0; i < 2; i++) {
			a = r.nextInt(populacao.getTamPopulacao());
			b = r.nextInt(populacao.getTamPopulacao());
			if (a < b)
				pais[i] = populacao.getIndividuo(a);
			else
				pais[i] = populacao.getIndividuo(b);
		}
		return pais;
	}

	public Individuo[] crossover(Individuo[] pais) {

		Individuo[] filhos = new Individuo[2];

		double[] geneFilho1 = pais[0].getGenes();
		double[] geneFilho2 = pais[1].getGenes();

		// realiza o corte (troca)
		double aux = geneFilho1[0];
		geneFilho1[0] = geneFilho2[0];
		geneFilho2[0] = aux;

		filhos[0] = new Individuo(geneFilho1);
		filhos[1] = new Individuo(geneFilho2);
		
		//Se aptidao ficar negativa, volta ao original
		if(filhos[0].getAptidao() < 0 || filhos[1].getAptidao() < 0){
			filhos[0] = pais[0];
			filhos[1] = pais[1];
		}

		return filhos;
	}

	public static double getTaxaDeCrossover() {
		return taxaDeCrossover;
	}

	public static double getTaxaDeMutacao() {
		return taxaDeMutacao;
	}

	public Individuo executaAG(double massaForragemInicial, double taxaMediaDeAcumulo, double pesoMedioInicial,
			double ganhoPesoDiario, int qtdMaxAnimais, int qtdMaxDias) {
		
		Genetico.massaForragemInicial = massaForragemInicial;
		Genetico.taxaMediaDeAcumulo = taxaMediaDeAcumulo;
		Genetico.pesoMedioInicial = pesoMedioInicial;
		Genetico.ganhoPesoDiario = ganhoPesoDiario;
		Genetico.qtdMaxAnimais = qtdMaxAnimais;
		Genetico.qtdMaxDias = qtdMaxDias;
		
		populacao.iniciarPopulacao();
		
		int geracao = 0;
		int contEstagnar = 0;
		double anterior = -1;

		do {
			populacao = gerarNovaGeracao(populacao, elitismo);

			//Verifica estagnacao
			if (geracao == 0 || populacao.getIndividuo(0).getAptidao() != anterior) {
				anterior = populacao.getIndividuo(0).getAptidao();
				contEstagnar = 1;
			} else {
				contEstagnar++;
			}

			if (contEstagnar > 50)
				break;

			if (geracao++ >= numMaxGeracoes)
				break;

		} while (populacao.getIndividuo(0).getAptidao() > 0);
		
		return populacao.getIndividuo(0);
	}
}
