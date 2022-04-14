package br.com.tarefas.Aplication;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.tarefas.DAO.TarefaDAO;
import br.com.tarefas.conexao.Conexao;
import br.com.tarefas.model.Tarefa;

public class TarefasAplication {

	public static void main(String[] args) throws ClassNotFoundException, ParseException {
		
		

		TarefaDAO dao = new TarefaDAO();
		Tarefa tarefa = new Tarefa();
		
		String id = "40";
		
		int con = Integer.parseInt(id);
		
		System.out.println(con);

		
		
		tarefa.setTitulo("sssss");
		tarefa.setDescricao("ssssss");
		tarefa.setId(Integer.parseInt(id));
		dao.update(tarefa);
		
		
		
		

	}

}
