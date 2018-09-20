
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Forragem;

public class ForragemDAO {
     private Conexao con = new Conexao(); 
    private String RELATORIO = "SELECT * FROM FORRAGEM WHERE ID_FAZENDA = ?";
    private String INSERIR = "INSERT INTO FORRAGEM (ID_FAZENDA, ESPECIE_FORRAGEM, TAXA_ACUMULO_FORRAGEM) VALUES (?,?,?)";
    private String ALTERAR = "UPDATE FORRAGEM SET ID_FAZENDA=?, ESPECIE_FORRAGEM=?, TAXA_ACUMULO_FORRAGEM=? WHERE ID_FORRAGEM=?";
    private String EXCLUIR = "DELETE FROM FORRAGEM WHERE ID_FORRAGEM=?";
    private String BUSCARID = "SELECT * FROM FORRAGEM WHERE ID_FORRAGEM = ?";
   
    public Forragem buscarID(int id) {
        Forragem f=null;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(BUSCARID);
			preparaInstrucao.setInt(1, id);
			ResultSet rs = preparaInstrucao.executeQuery(); 
			if (rs.next()) { 
				f = new Forragem(rs.getInt("ID_FORRAGEM"), rs.getInt("ID_FAZENDA"),
						rs.getString("ESPECIE_FORRAGEM"),rs.getFloat("TAXA_ACUMULO_FORRAGEM"));
			}
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
                return f;
	}
    
    public boolean excluir(Forragem a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(EXCLUIR);
			preparaInstrucao.setInt(1, a.getId_forragem());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    public boolean alterar(Forragem a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(ALTERAR);
			preparaInstrucao.setInt(1, a.getId_fazenda());
			preparaInstrucao.setString(2, a.getEspecie_forragem());
			preparaInstrucao.setDouble(3, a.getTaxa_acumulo_forragem());
                        preparaInstrucao.setInt(4, a.getId_forragem());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    
    public boolean inserir(Forragem a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(INSERIR);
			preparaInstrucao.setInt(1, a.getId_fazenda());
			preparaInstrucao.setString(2, a.getEspecie_forragem());
			preparaInstrucao.setDouble(3, a.getTaxa_acumulo_forragem());
       
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    
    public ArrayList<Forragem> relatorio(int idFazenda) {
		ArrayList<Forragem> lista = new ArrayList<>();
		try {
			con.conecta(); 
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(RELATORIO); 
			preparaInstrucao.setInt(1,  idFazenda);
			ResultSet rs = preparaInstrucao.executeQuery(); 
			while (rs.next()) { 
				Forragem c = new Forragem(rs.getInt("ID_FORRAGEM"), rs.getInt("ID_FAZENDA"),
						rs.getString("ESPECIE_FORRAGEM"),rs.getFloat("TAXA_ACUMULO_FORRAGEM"));
				lista.add(c); 
			}
			con.desconecta();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
