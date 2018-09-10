package algoritmogenetico;


public class Populacao {

	private Individuo[] individuos;

	public Populacao(int tamPop) {
		individuos = new Individuo[tamPop];
	}

	public void iniciarPopulacao() {
		for (int i = 0; i < individuos.length; i++) {
			individuos[i] = new Individuo();
		}
		ordenaPopulacao();
	}

	// TODO Otimizar metodo de ordenacao
	//Ordena do menor para o maior, ou seja, as melhores soluções são as que minimizam a sobra de forragem
	public void ordenaPopulacao() {
		Individuo temp;
		for (int i = 0; i < individuos.length - 1; i++) {
			for (int j = i; j < individuos.length; j++) {
				if (individuos[i].getAptidao() > individuos[j].getAptidao()) {
					temp = individuos[i];
					individuos[i] = individuos[j];
					individuos[j] = temp;
				}

			}
		}
	}

	public Individuo getIndividuo(int pos) {
		return individuos[pos];
	}
	
	// coloca um individuo na proxima posicao disponivel da populacao
	public void setIndividuo(Individuo individuo) {
		for (int i = 0; i < individuos.length; i++) {
			if (individuos[i] == null) {
				individuos[i] = individuo;
				break;
			}
		}
	}

	// numero de individuos existentes na populacao
	public int getNumIndividuos() {
		int num = 0;
		for (int i = 0; i < individuos.length; i++) {
			if (individuos[i] != null)
				num++;
			else
				break;
		}
		return num;
	}

	public int getTamPopulacao() {
		return individuos.length;
	}

}
