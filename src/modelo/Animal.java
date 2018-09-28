
package modelo;

public class Animal {
    
	private int Id_animal;
    private int Id_fazenda;
    private String Categoria_animal;
    private String Raca_animal;
    private String Sexo_animal;
    private double GMD_animal;
    private int Quantidade_animal;
    
    public Animal(int animal, int fazenda, String categoria, String raca, String sexo, double GMD, int qtdAnimal){
        Id_animal = animal;
        Id_fazenda = fazenda;
        Categoria_animal = categoria;
        Raca_animal = raca;
        Sexo_animal = sexo;
        GMD_animal = GMD;
        Quantidade_animal = qtdAnimal;
    }
    
     public Animal(int fazenda, String categoria, String raca, String sexo, double GMD, int qtdAnimal){
        Id_fazenda = fazenda;
        Categoria_animal = categoria;
        Raca_animal = raca;
        Sexo_animal = sexo;
        GMD_animal = GMD;
        Quantidade_animal = qtdAnimal;
    }

    public Animal(int Id_animal) {
        this.Id_animal = Id_animal;
    }
     
     
     
    public String toString(){
        return Categoria_animal;
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
     * @return the fazenda
     */
    public int getFazenda() {
        return Id_fazenda;
    }

    /**
     * @param fazenda the fazenda to set
     */
    public void setFazenda(int fazenda) {
        this.Id_fazenda = fazenda;
    }

    /**
     * @return the Categoria_animal
     */
    public String getCategoria_animal() {
        return Categoria_animal;
    }

    /**
     * @param Categoria_animal the Categoria_animal to set
     */
    public void setCategoria_animal(String Categoria_animal) {
        this.Categoria_animal = Categoria_animal;
    }

    /**
     * @return the Raca_animal
     */
    public String getRaca_animal() {
        return Raca_animal;
    }

    /**
     * @param Raca_animal the Raca_animal to set
     */
    public void setRaca_animal(String Raca_animal) {
        this.Raca_animal = Raca_animal;
    }

    /**
     * @return the Sexo_animal
     */
    public String getSexo_animal() {
        return Sexo_animal;
    }

    /**
     * @param Sexo_animal the Sexo_animal to set
     */
    public void setSexo_animal(String Sexo_animal) {
        this.Sexo_animal = Sexo_animal;
    }

    /**
     * @return the GMD_animal
     */
    public double getGMD_animal() {
        return GMD_animal;
    }

    /**
     * @param GMD_animal the GMD_animal to set
     */
    public void setGMD_animal(double GMD_animal) {
        this.GMD_animal = GMD_animal;
    }

    /**
     * @return the Quantidade_animal
     */
    public int getQuantidade_animal() {
        return Quantidade_animal;
    }

    /**
     * @param Quantidade_animal the Quantidade_animal to set
     */
    public void setQuantidade_animal(int Quantidade_animal) {
        this.Quantidade_animal = Quantidade_animal;
    }
    
}