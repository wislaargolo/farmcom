
package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Animal;

public class AnimalDAO {
    private Conexao con = new Conexao(); 
    private String RELATORIO = "SELECT * FROM ANIMAL WHERE ID_FAZENDA = ?";
    private String INSERIR = "INSERT INTO ANIMAL (ID_FAZENDA, CATEGORIA_ANIMAL, RACA_ANIMAL, SEXO_ANIMAL, GMD_ANIMAL, QUANTIDADE_ANIMAL) VALUES (?,?,?,?,?,?)";
    private String ALTERAR = "UPDATE ANIMAL SET ID_FAZENDA=?, CATEGORIA_ANIMAL=?, RACA_ANIMAL=?, SEXO_ANIMAL=?, GMD_ANIMAL=?, QUANTIDADE_ANIMAL=? WHERE ID_ANIMAL=?";
    private String EXCLUIR = "DELETE FROM ANIMAL WHERE ID_ANIMAL = ?";
    private String BUSCARID = "SELECT * FROM ANIMAL WHERE ID_ANIMAL = ?";
   
    public Animal buscarID(int id) {
        Animal f=null;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(BUSCARID);
			preparaInstrucao.setInt(1, id);
			ResultSet rs = preparaInstrucao.executeQuery(); 
			if (rs.next()) { 
				Animal c = new Animal(rs.getInt("ID_ANIMAL"), rs.getInt("ID_FAZENDA"),
						rs.getString("CATEGORIA_ANIMAL"),rs.getString("RACA_ANIMAL"), rs.getString("SEXO_ANIMAL"),
                                                rs.getDouble("GMD_ANIMAL"), rs.getInt("QUANTIDADE_ANIMAL"));
			}
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
                return f;
	}
    

    public ArrayList<Animal> relatorio(int idFazenda) {
		ArrayList<Animal> lista = new ArrayList<>();
		try {
			con.conecta(); 
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(RELATORIO);
			preparaInstrucao.setInt(1,  idFazenda);
			ResultSet rs = preparaInstrucao.executeQuery(); 
			while (rs.next()) { 
				Animal c = new Animal(rs.getInt("ID_ANIMAL"), rs.getInt("ID_FAZENDA"),
						rs.getString("CATEGORIA_ANIMAL"),rs.getString("RACA_ANIMAL"), rs.getString("SEXO_ANIMAL"),
                                                rs.getDouble("GMD_ANIMAL"), rs.getInt("QUANTIDADE_ANIMAL"));
				lista.add(c); 
			}
			con.desconecta();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
    
     public boolean inserir(Animal a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(INSERIR);
			preparaInstrucao.setInt(1, a.getFazenda());
			preparaInstrucao.setString(2, a.getCategoria_animal());
			preparaInstrucao.setString(3, a.getRaca_animal());
                        preparaInstrucao.setString(4, a.getSexo_animal());
                        preparaInstrucao.setDouble(5, a.getGMD_animal());
                        preparaInstrucao.setInt(6, a.getQuantidade_animal());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
     
       public boolean alterar(Animal a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(ALTERAR);
			preparaInstrucao.setInt(1, a.getFazenda());
			preparaInstrucao.setString(2, a.getCategoria_animal());
			preparaInstrucao.setString(3, a.getRaca_animal());
                        preparaInstrucao.setString(4, a.getSexo_animal());
                        preparaInstrucao.setDouble(5, a.getGMD_animal());
                        preparaInstrucao.setInt(6, a.getQuantidade_animal());
                        preparaInstrucao.setInt(7, a.getId_animal());
                        
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
       public boolean excluir(Animal a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(EXCLUIR);
			preparaInstrucao.setInt(1, a.getId_animal());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
}
