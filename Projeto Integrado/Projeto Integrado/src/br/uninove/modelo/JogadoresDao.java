package br.uninove.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class JogadoresDao {
	
	public static void cadastrar(Jogadores jog) {

		Connection con = Conexao.receberConexao();

		String sql = "Insert into time(nm_time,posicao,salario,camisa,contrato) VALUES (?,?,?,?,?)";
		String sql2= "Insert into jogadores(nome,rg,idade,tamanho,peso,nm_time) VALUES(?,?,?,?,?,?)";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, jog.getTimes().getNm_time());
			preparador.setString(2, String.valueOf(jog.getTimes().getPosicao()));
			preparador.setDouble(3, jog.getTimes().getSalario());
			preparador.setInt(4,  jog.getTimes().getCamisa());
			preparador.setDouble(5,  jog.getTimes().getContrato());
			
			preparador.execute();
			preparador.close();
			
			PreparedStatement preparador2 = con.prepareStatement(sql2);
			preparador2.setString(1, jog.getNome());
			preparador2.setString(2, jog.getRg());
			preparador2.setInt(3, jog.getIdade());
			preparador2.setDouble(4,  jog.getTamanho());
			preparador2.setDouble(5, jog.getPeso());
			preparador2.setString(6, jog.getTimes().getNm_time());
			
			preparador2.execute();
			preparador2.close();
			

			System.out.println("Jogador Cadastrado com Sucesso!");

		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println("Erro ao cadastrar o jogador");
		}

	}

	
	
	public static ArrayList<Jogadores> mostrarTodos() {

		
		
		Connection con = Conexao.receberConexao();
		ArrayList<Jogadores> jog_list = new ArrayList<Jogadores>();
		
		String sql = "SELECT * FROM jogadores AS j INNER JOIN time AS t ON j.nm_time = t.nm_time";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while (resultado.next()) {
				
				Jogadores jog = new Jogadores();
				Time times = new Time();
				
				
				
				jog.setNome(resultado.getString("nome"));
				jog.setIdade(resultado.getInt("idade"));
				jog.setPeso(resultado.getDouble("peso"));
				jog.setRg(resultado.getString("rg"));
				jog.setTamanho(resultado.getDouble("tamanho"));
				
				times.setNm_time(resultado.getString("nm_time"));
				times.setPosicao(resultado.getString("posicao").charAt(0));
				times.setSalario(resultado.getDouble("salario"));
				times.setCamisa(resultado.getInt("camisa"));
				times.setContrato(resultado.getDouble("contrato"));
				
				jog.setTimes(times);
						

				
				jog_list.add(jog);		
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jog_list;
	}


	
	public static Jogadores buscarRg(String rg) {
		
		
		Jogadores jog = null;
		Connection con = Conexao.receberConexao();
		
		String sql = "SELECT * FROM jogadores AS j INNER JOIN time AS t ON j.nm_time = t.nm_time where rg=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			
			preparador.setString(1, rg);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				
				Time times = new Time();
				
				jog = new Jogadores();
				
				jog.setNome(resultado.getString("nome"));
				jog.setIdade(resultado.getInt("idade"));
				jog.setPeso(resultado.getDouble("peso"));
				jog.setRg(resultado.getString("rg"));
				jog.setTamanho(resultado.getDouble("tamanho"));
				
				times.setNm_time(resultado.getString("nm_time"));
				times.setPosicao(resultado.getString("posicao").charAt(0));
				times.setSalario(resultado.getDouble("salario"));
				times.setCamisa(resultado.getInt("camisa"));
				times.setContrato(resultado.getDouble("contrato"));
				
				jog.setTimes(times);
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return jog;
		
	}
	
	public static void Alterar(Jogadores jog) {
		
		Connection con = Conexao.receberConexao();
		String sql = "UPDATE jogadores AS j INNER JOIN time AS t ON j.nm_time=t.nm_time SET j.nome=?, t.nm_time=?, j.nm_time=?, j.idade=?, j.peso=?,j.tamanho=?,"
				+ "t.camisa=?,t.salario=?,t.posicao=?,t.contrato=? where j.rg =? ";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, jog.getNome());
			preparador.setString(2, jog.getTimes().getNm_time());
			preparador.setString(3, jog.getTimes().getNm_time());
			preparador.setInt(4, jog.getIdade());
			preparador.setDouble(5, jog.getPeso());
			preparador.setDouble(6,  jog.getTamanho());
			preparador.setInt(7,  jog.getTimes().getCamisa());
			preparador.setDouble(8, jog.getTimes().getSalario());
			preparador.setString(9, String.valueOf(jog.getTimes().getPosicao()));
			preparador.setDouble(10,  jog.getTimes().getContrato());
			preparador.setString(11, jog.getRg());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	public static void Remover(String rg) {
		
		Connection con = Conexao.receberConexao();
		String sql = "DELETE from jogadores,time USING jogadores INNER JOIN time WHERE jogadores.nm_time = time.nm_time  AND jogadores.rg = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, rg);
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
}
