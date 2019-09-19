package br.uninove.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection receberConexao(){
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_jogadores","root","");
		} catch (SQLException | ClassNotFoundException e){
			
			e.printStackTrace();
		}
		return con;
		
		}
}
