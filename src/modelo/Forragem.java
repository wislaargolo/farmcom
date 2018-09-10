
package modelo;

public class Forragem {
    private int Id_forragem;
    private int Id_fazenda;
    private String Especie_forragem;
    private double Taxa_acumulo_forragem;

    public Forragem(int Id_forragem, int Id_fazenda, String Especie_forragem, double Taxa_acumulo_forragem) {
        this.Id_forragem = Id_forragem;
        this.Id_fazenda = Id_fazenda;
        this.Especie_forragem = Especie_forragem;
        this.Taxa_acumulo_forragem = Taxa_acumulo_forragem;
    }

    public Forragem(int Id_fazenda, String Especie_forragem, double Taxa_acumulo_forragem) {
        this.Id_fazenda = Id_fazenda;
        this.Especie_forragem = Especie_forragem;
        this.Taxa_acumulo_forragem = Taxa_acumulo_forragem;
    }
    
    public String toString(){
        return Especie_forragem;
    }

    public int getId_forragem() {
        return Id_forragem;
    }

    public void setId_forragem(int Id_forragem) {
        this.Id_forragem = Id_forragem;
    }

    public int getId_fazenda() {
        return Id_fazenda;
    }

    public void setId_fazenda(int Id_fazenda) {
        this.Id_fazenda = Id_fazenda;
    }

    public String getEspecie_forragem() {
        return Especie_forragem;
    }

    public void setEspecie_forragem(String Especie_forragem) {
        this.Especie_forragem = Especie_forragem;
    }

    public double getTaxa_acumulo_forragem() {
        return Taxa_acumulo_forragem;
    }

    public void setTaxa_acumulo_forragem(double Taxa_acumulo_forragem) {
        this.Taxa_acumulo_forragem = Taxa_acumulo_forragem;
    }
    
}