package br.com.tarefas.DAO;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.tarefas.conexao.Conexao;
import br.com.tarefas.model.Tarefa;

public class TarefaDAO {


	public void save(Tarefa tarefa) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO tarefas(titulo,descricao,data_inicio,data_termino) VALUES(?,?,?,?)";
		
		try {
			
			conn =  (Connection) Conexao.getConnection();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, ((Tarefa) tarefa).getTitulo());
				pstm.setString(2, ((Tarefa) tarefa).getDescricao());
				pstm.setDate(3, new Date(tarefa.getData_inicio().getTime()));
				pstm.setDate(4, new Date(tarefa.getData_termino().getTime()));
				
				pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(conn != null ) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<Tarefa> getTarefa(){

		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		Connection conn = null;
		
		String sql = "SELECT * FROM tarefas";
		
		PreparedStatement pstm = null;
		
		ResultSet rst = null;
		

		try {
			conn = (Connection) Conexao.getConnection();
			pstm = conn.prepareStatement(sql);
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setTitulo(rst.getString("titulo"));
				tarefa.setDescricao(rst.getString("descricao"));
				tarefa.setData_inicio(rst.getDate("data_inicio"));
				tarefa.setData_termino(rst.getDate("data_termino"));
				tarefa.setId(rst.getInt("id"));
				tarefas.add(tarefa);
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally{
			
			try{
				if(rst != null) {
					rst.close();
				}
					if(conn != null) {
						conn.close();
					}
						if(pstm != null) {
							pstm.close();
						}
			}catch(Exception e){
				e.printStackTrace();
				}
			}
			return tarefas;
	}

	public List<Tarefa> getTarefaById(int id) {
		
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		Connection conn = null;
		
		String sql = "SELECT * FROM tarefas WHERE id=?";
		
		PreparedStatement pstm = null;
		
		ResultSet rst = null;
		

		try {
			conn = (Connection) Conexao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setTitulo(rst.getString("titulo"));
				tarefa.setDescricao(rst.getString("descricao"));
				tarefa.setData_inicio(rst.getDate("data_inicio"));
				tarefa.setData_termino(rst.getDate("data_termino"));
				tarefa.setId(rst.getInt("id"));
				tarefas.add(tarefa);
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally{
			
			try{
				if(rst != null) {
					rst.close();
				}
					if(conn != null) {
						conn.close();
					}
						if(pstm != null) {
							pstm.close();
						}
			}catch(Exception e){
				e.printStackTrace();
				}
			}
			return tarefas;

	}
	
	public void update(Tarefa tarefa) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "UPDATE tarefas SET titulo = ? , descricao = ?, data_inicio = ? , data_termino = ? WHERE id = ?";
		
		
		try {
			conn = (Connection) Conexao.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, tarefa.getTitulo());
			pstm.setString(2, tarefa.getDescricao());
			pstm.setDate(3, (Date) tarefa.getData_inicio());
			pstm.setDate(4, (Date) tarefa.getData_termino());
			pstm.setInt(5, tarefa.getId());
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(conn != null) {
					conn.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void delete(int id) {
		
		
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "DELETE FROM tarefas WHERE id= ? ";
		
		try {
			
			conn = (Connection)Conexao.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(conn != null) {
					conn.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	
	}
	
	
}
