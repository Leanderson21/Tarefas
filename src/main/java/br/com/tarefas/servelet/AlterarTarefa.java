package br.com.tarefas.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.DAO.TarefaDAO;
import br.com.tarefas.model.Tarefa;


@WebServlet("/update")
public class AlterarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
	
		try {
		String nome = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String id = request.getParameter("id");
		
		int number = Integer.parseInt(id);
		
		System.out.println(number);
			
		Tarefa tarefa = new Tarefa();
		TarefaDAO dao = new TarefaDAO();
		
	
		tarefa.setTitulo(nome);
		tarefa.setDescricao(descricao);
		tarefa.setId(number);
		dao.update(tarefa);
		
		// Mensagem de alerta
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Formulário salvo com sucesso');");
		    out.println("location='lista-tarefas.jsp';");
		    out.println("</script>");
		
		}catch(Exception e) {
			e.printStackTrace();
	    // Mensagem de alerta
			   PrintWriter out = response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Erro ao tentar salvar os dados');");
			   out.println("location='lista-tarefas.jsp';");
			   out.println("</script>");
		}
	}

}
