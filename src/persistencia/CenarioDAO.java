
package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cenario;


public class CenarioDAO {
    private Conexao con = new Conexao(); 
    private String RELATORIO = "SELECT * FROM CENARIO";
    private String INSERIR = "INSERT INTO CENARIO (ID_FAZENDA, ID_ANIMAL, ID_FORRAGEM, DATA_INICIO_CENARIO, QTD_DIAS_CENARIO, QTD_ANIMAIS_CENARIO, MASSA_INICIAL_CENARIO, PESO_INICIAL_ANIMAIS, PESO_FINAL_CENARIO, ACUMULO_CENARIO, CONSUMO_CENARIO, SALDO_CENARIO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private String ALTERAR = "UPDATE CENARIO SET ID_FAZENDA=?, ID_ANIMAL=?, ID_FORRAGEM=?, DATA_INICIO_CENARIO=?, QTD_DIAS_CENARIO=?, QTD_ANIMAIS_CENARIO=?, MASSA_INICIAL_CENARIO=?, PESO_INICIAL_ANIMAIS=?, PESO_FINAL_CENARIO=?, ACUMULO_CENARIO=?, CONSUMO_CENARIO=?, SALDO_CENARIO=? WHERE ID_CENARIO=?";
    private String EXCLUIR = "DELETE FROM CENARIO WHERE ID_CENARIO=?";
   
    public boolean excluir(Cenario c) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(EXCLUIR);
			preparaInstrucao.setInt(1, c.getId_cenario());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    public boolean alterar(Cenario c) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(ALTERAR);
                        preparaInstrucao.setInt(1, c.getId_fazenda()) ;
                        preparaInstrucao.setInt(2, c.getId_animal());
                        preparaInstrucao.setInt(3, c.getId_forragem());
                        preparaInstrucao.setDate(4, c.getData_inicio_cenario());
                        preparaInstrucao.setInt(5, c.getQtd_dias_cenario());
                        preparaInstrucao.setInt(6, c.getQtd_animais_cenario());
                        preparaInstrucao.setDouble(7, c.getMassa_inicial_cenario());
                        preparaInstrucao.setDouble(8, c.getPeso_inicial_animais());
                        preparaInstrucao.setDouble(9, c.getPeso_final_cenario());
                        preparaInstrucao.setDouble(10, c.getAcumulo_cenario());
                        preparaInstrucao.setDouble(11, c.getConsumo_cenario());
                        preparaInstrucao.setDouble(12, c.getSaldo_cenario());
                        preparaInstrucao.setInt(13, c.getId_cenario());
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
                        confere = false;
			System.out.println(e.getMessage());
		}
                return confere;
	}
    
    public ArrayList<Cenario> relatorio() {
		ArrayList<Cenario> lista = new ArrayList<>();
		try {
			con.conecta(); 
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(RELATORIO); 
			ResultSet rs = preparaInstrucao.executeQuery(); 
			while (rs.next()) { 
				Cenario c = new Cenario(rs.getInt("ID_CENARIO"),rs.getInt("ID_FAZENDA"), rs.getInt("ID_ANIMAL"), rs.getInt("ID_FORRAGEM"), rs.getDate("DATA_INICIO_CENARIO"), rs.getInt("QTD_DIAS_CENARIO"), rs.getInt("QTD_ANIMAIS_CENARIO"), rs.getDouble("MASSA_INICIAL_CENARIO"), rs.getDouble("PESO_FINAL_CENARIO"),rs.getDouble("PESO_INICIAL_ANIMAIS"), rs.getDouble("ACUMULO_CENARIO"), rs.getDouble("CONSUMO_CENARIO"), rs.getDouble("SALDO_CENARIO"));
				lista.add(c); 
			}
			con.desconecta();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
    
    public boolean inserir(Cenario c) {
        boolean confere = true;
		try {
			con.conecta(); // CONECTA
			PreparedStatement preparaInstrucao = con.getConexao().prepareStatement(INSERIR);
                        preparaInstrucao.setInt(1, c.getId_fazenda()) ;
                        preparaInstrucao.setInt(2, c.getId_animal());
                        preparaInstrucao.setInt(3, c.getId_forragem());
                        preparaInstrucao.setDate(4, c.getData_inicio_cenario());
                        preparaInstrucao.setInt(5, c.getQtd_dias_cenario());
                        preparaInstrucao.setInt(6, c.getQtd_animais_cenario());
                        preparaInstrucao.setDouble(7, c.getMassa_inicial_cenario());
                        preparaInstrucao.setDouble(8, c.getPeso_inicial_animais());
                        preparaInstrucao.setDouble(9, c.getPeso_final_cenario());
                        preparaInstrucao.setDouble(10, c.getAcumulo_cenario());
                        preparaInstrucao.setDouble(11, c.getConsumo_cenario());
                        preparaInstrucao.setDouble(12, c.getSaldo_cenario());
                       
			preparaInstrucao.execute(); // EXECUTA A INSTRUCAO
			con.desconecta(); // DESCONECTA
		} catch (Exception e) {
			confere = false;
                        System.out.println(e.getMessage());

		}
                return confere;
	}
    
}
