
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Fazenda;

public class FazendaDAO {
    private Conexao con = new Conexao(); 
    private String RELATORIO = "SELECT * FROM FAZENDA";
    private String INSERIR = "INSERT INTO FAZENDA (NOME_FAZENDA, AREA_FAZENDA) VALUES (?,?)";
    private String ALTERAR = "UPDATE FAZENDA SET NOME_FAZENDA=?, AREA_FAZENDA=? WHERE ID_FAZENDA = ?";
    private String EXCLUIR = "DELETE FROM FAZENDA WHERE ID_FAZENDA = ?";
    private String BUSCARID = "SELECT * FROM FAZENDA WHERE ID_FAZENDA = ?";
    
    public Fazenda buscarID(int id) {
        Fazenda f=null;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(BUSCARID);
			preparaInstrucao.setInt(1, id);
			ResultSet rs = preparaInstrucao.executeQuery(); 
			if (rs.next()) { 
				Fazenda c = new Fazenda(rs.getInt("ID_FAZENDA"),
						rs.getString("NOME_FAZENDA"),rs.getFloat("AREA_FAZENDA"));
			}
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
                return f;
	}
    
    public boolean excluir(Fazenda a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(EXCLUIR);
			preparaInstrucao.setInt(1, a.getId_fazenda());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    public boolean alterar(Fazenda a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(ALTERAR);
			preparaInstrucao.setString(1, a.getNome_fazenda());
			preparaInstrucao.setDouble(2, a.getArea_fazenda());
			preparaInstrucao.setInt(3, a.getId_fazenda());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    
    public boolean inserir(Fazenda a) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(INSERIR);
			preparaInstrucao.setString(1, a.getNome_fazenda());
			preparaInstrucao.setDouble(2, a.getArea_fazenda());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    public ArrayList<Fazenda> relatorio() {
		ArrayList<Fazenda> lista = new ArrayList<>();
		try {
			con.conecta(); 
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(RELATORIO); 
			ResultSet rs = preparaInstrucao.executeQuery(); 
			while (rs.next()) { 
				Fazenda c = new Fazenda(rs.getInt("ID_FAZENDA"),
						rs.getString("NOME_FAZENDA"),rs.getFloat("AREA_FAZENDA"));
				lista.add(c); 
			}
			con.desconecta();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
