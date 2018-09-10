
package modelo;
import java.sql.Date;

public class Cenario {
    private int Id_cenario;
    private int Id_fazenda;
    private int Id_animal;
    private int Id_forragem;
    private Date Data_inicio_cenario;
    private int Qtd_dias_cenario;
    private int Qtd_animais_cenario;
    private double  Massa_inicial_cenario;
    private double Peso_inicial_animais;
    private double Peso_final_cenario;
    private double Acumulo_cenario;
    private double Consumo_cenario;
    private double Saldo_cenario;

    public Cenario(int Id_fazenda, int Id_animal, int Id_forragem, Date Data_inicio_cenario, int Qtd_dias_cenario, int Qtd_animais_cenario, double Massa_inicial_cenario, double peso_inicial) {
        this.Id_fazenda = Id_fazenda;
        this.Id_animal = Id_animal;
        this.Id_forragem = Id_forragem;
        this.Data_inicio_cenario = Data_inicio_cenario;
        this.Qtd_dias_cenario = Qtd_dias_cenario;
        this.Qtd_animais_cenario = Qtd_animais_cenario;
        this.Massa_inicial_cenario = Massa_inicial_cenario;
        this.Peso_inicial_animais = peso_inicial;
      
    }
    
   

	public Cenario(int Id_cenario, int Id_fazenda, int Id_animal, int Id_forragem, Date Data_inicio_cenario,
			int Qtd_dias_cenario, int Qtd_animais_cenario, double Massa_inicial_cenario, double Peso_final_cenario, double peso_inicial,
			double Acumulo_cenario, double Consumo_cenario, double Saldo_cenario) {
		this.Id_cenario = Id_cenario;
		this.Id_fazenda = Id_fazenda;
		this.Id_animal = Id_animal;
		this.Id_forragem = Id_forragem;
		this.Data_inicio_cenario = Data_inicio_cenario;
		this.Qtd_dias_cenario = Qtd_dias_cenario;
		this.Qtd_animais_cenario = Qtd_animais_cenario;
		this.Massa_inicial_cenario = Massa_inicial_cenario;
		this.Peso_final_cenario = Peso_final_cenario;
		this.Acumulo_cenario = Acumulo_cenario;
		this.Consumo_cenario = Consumo_cenario;
                this.Peso_inicial_animais = peso_inicial;
		this.Saldo_cenario = Saldo_cenario;
	}

    /**
     * @return the Id_cenario
     */
    public int getId_cenario() {
        return Id_cenario;
    }

    /**
     * @param Id_cenario the Id_cenario to set
     */
    public void setId_cenario(int Id_cenario) {
        this.Id_cenario = Id_cenario;
    }

    /**
     * @return the Id_fazenda
     */
    public int getId_fazenda() {
        return Id_fazenda;
    }

    /**
     * @param Id_fazenda the Id_fazenda to set
     */
    public void setId_fazenda(int Id_fazenda) {
        this.Id_fazenda = Id_fazenda;
    }

    /**
     * @return the Id_animal
     */
    public int getId_animal() {
        return Id_animal;
    }

    /**
     * @param Id_animal the Id_animal to set
     */
    public void setId_animal(int Id_animal) {
        this.Id_animal = Id_animal;
    }

    /**
     * @return the Id_forragem
     */
    public int getId_forragem() {
        return Id_forragem;
    }

    /**
     * @param Id_forragem the Id_forragem to set
     */
    public void setId_forragem(int Id_forragem) {
        this.Id_forragem = Id_forragem;
    }

    /**
     * @return the Data_inicio_cenario
     */
    public Date getData_inicio_cenario() {
        return Data_inicio_cenario;
    }

    /**
     * @param Data_inicio_cenario the Data_inicio_cenario to set
     */
    public void setData_inicio_cenario(Date Data_inicio_cenario) {
        this.Data_inicio_cenario = Data_inicio_cenario;
    }

    /**
     * @return the Qtd_dias_cenario
     */
    public int getQtd_dias_cenario() {
        return Qtd_dias_cenario;
    }

    /**
     * @param Qtd_dias_cenario the Qtd_dias_cenario to set
     */
    public void setQtd_dias_cenario(int Qtd_dias_cenario) {
        this.Qtd_dias_cenario = Qtd_dias_cenario;
    }

    /**
     * @return the Qtd_animais_cenario
     */
    public int getQtd_animais_cenario() {
        return Qtd_animais_cenario;
    }

    /**
     * @param Qtd_animais_cenario the Qtd_animais_cenario to set
     */
    public void setQtd_animais_cenario(int Qtd_animais_cenario) {
        this.Qtd_animais_cenario = Qtd_animais_cenario;
    }

    /**
     * @return the Massa_inicial_cenario
     */
    public double getMassa_inicial_cenario() {
        return Massa_inicial_cenario;
    }

    /**
     * @param Massa_inicial_cenario the Massa_inicial_cenario to set
     */
    public void setMassa_inicial_cenario(double Massa_inicial_cenario) {
        this.Massa_inicial_cenario = Massa_inicial_cenario;
    }

    /**
     * @return the Peso_final_cenario
     */
    public double getPeso_final_cenario() {
        return Peso_final_cenario;
    }

    /**
     * @param Peso_final_cenario the Peso_final_cenario to set
     */
    public void setPeso_final_cenario(double Peso_final_cenario) {
        this.Peso_final_cenario = Peso_final_cenario;
    }

    /**
     * @return the Acumulo_cenario
     */
    public double getAcumulo_cenario() {
        return Acumulo_cenario;
    }

    /**
     * @param Acumulo_cenario the Acumulo_cenario to set
     */
    public void setAcumulo_cenario(double Acumulo_cenario) {
        this.Acumulo_cenario = Acumulo_cenario;
    }

    /**
     * @return the Consumo_cenario
     */
    public double getConsumo_cenario() {
        return Consumo_cenario;
    }

    /**
     * @param Consumo_cenario the Consumo_cenario to set
     */
    public void setConsumo_cenario(double Consumo_cenario) {
        this.Consumo_cenario = Consumo_cenario;
    }

    /**
     * @return the Saldo_cenario
     */
    public double getSaldo_cenario() {
        return Saldo_cenario;
    }

    /**
     * @param Saldo_cenario the Saldo_cenario to set
     */
    public void setSaldo_cenario(double Saldo_cenario) {
        this.Saldo_cenario = Saldo_cenario;
    }



	public double getPeso_inicial_animais() {
		return Peso_inicial_animais;
	}



	public void setPeso_inicial_animais(double peso_inicial) {
		Peso_inicial_animais = peso_inicial;
	}


}
