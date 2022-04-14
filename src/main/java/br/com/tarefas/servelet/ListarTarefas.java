package br.com.tarefas.servelet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.DAO.TarefaDAO;
import br.com.tarefas.conexao.Conexao;
import br.com.tarefas.model.Tarefa;



@WebServlet("/lista")
public class ListarTarefas extends HttpServlet {

       
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			TarefaDAO dao = new TarefaDAO();
			List<Tarefa> tarefa = dao.getTarefa();
			
			for(Tarefa c : tarefa) {
				System.out.println(c.getId());
			}
			
			request.setAttribute("tarefas", tarefa);
	
	
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
		disp.forward(request, response);
	}
	

	
	}


