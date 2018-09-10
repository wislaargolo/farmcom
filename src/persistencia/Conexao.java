package persistencia;

import java.sql.*; //importa todas as classes da api java.sql

/**
 * CLASSE QUE CONFIGURA A CONEXAO COM O BANCO DE DADOS 
 *
 */
public class Conexao {
	//ATRIBUTOS DA CLASSE
	private String usuario;			//nome do usuario do banco
	private String senha;			//senha do banco  
	private String caminho;			//caminho para o banco
	private String driverjdbc;		//driver jdbc
	private Connection conexao;		//objeto do tipo Connection

	//METODO CONSTRUTOR
	public Conexao() {
		this.caminho = "jdbc:h2:~/farmcomBD;INIT=runscript from '~/create.sql'";
		this.usuario = "admin"; 
		this.senha = "admin"; 
		this.driverjdbc = "org.h2.Driver";
	}
	
	//METODO QUE EFETUA A CONEXAO COM O BANCO DE DADOS
	public void conecta() {
		try {
			Class.forName(driverjdbc); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
			conexao = DriverManager.getConnection(caminho, usuario,senha); //Cria a conexao
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	//METODO QUE DESCONECTA O BANCO DE DADOS
	public void desconecta() {
		try {
			conexao.close();//fecha a conexao
		} catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}
	
	
}
