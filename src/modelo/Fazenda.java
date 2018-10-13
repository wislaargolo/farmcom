
package modelo;

import java.text.DecimalFormat;

public class Fazenda {
    private int Id_fazenda;
    private String Nome_fazenda;
    private double Area_fazenda;
    

    public Fazenda(int Id_fazenda, String Nome_fazenda, double Area_fazenda) {
        this.Id_fazenda = Id_fazenda;
        this.Nome_fazenda = Nome_fazenda;
        this.Area_fazenda = Area_fazenda;
    }

    public Fazenda(String Nome_fazenda, double Area_fazenda) {
        this.Nome_fazenda = Nome_fazenda;
        this.Area_fazenda = Area_fazenda;
    }

    public Fazenda(int Id_fazenda) {
        this.Id_fazenda = Id_fazenda;
    }
    
    
    
    public String toString(){
        return Nome_fazenda;
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
     * @return the Nome_fazenda
     */
    public String getNome_fazenda() {
        return Nome_fazenda;
    }

    /**
     * @param Nome_fazenda the Nome_fazenda to set
     */
    public void setNome_fazenda(String Nome_fazenda) {
        this.Nome_fazenda = Nome_fazenda;
    }

    /**
     * @return the Area_fazenda
     */
    public double getArea_fazenda() {
        DecimalFormat formato = new DecimalFormat("0.##");      
        Area_fazenda = Double.parseDouble(formato.format(Area_fazenda).replaceAll(",", "."));
        return Area_fazenda;
    }

    /**
     * @param Area_fazenda the Area_fazenda to set
     */
    public void setArea_fazenda(double Area_fazenda) {
        this.Area_fazenda = Area_fazenda;
    }
    
    
}