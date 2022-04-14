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


@WebServlet("/tarefas")
public class TarefaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
	
		try {
		String nome = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String data_inicio = request.getParameter("data_inicio");
		String data_termino = request.getParameter("data_termino");
		
		
		Tarefa tarefa = new Tarefa();
		TarefaDAO dao = new TarefaDAO();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date data = formato.parse(data_inicio);
		Date data2 = formato.parse(data_termino);
		
		tarefa.setTitulo(nome);
		tarefa.setDescricao(descricao);
		tarefa.setData_inicio(data);
		tarefa.setData_termino(data2);
		dao.save(tarefa);
		
		// Mensagem de alerta
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Formulário salvo com sucesso');");
		    out.println("location='index.jsp';");
		    out.println("</script>");
		
		}catch(Exception e) {
			e.printStackTrace();
	    // Mensagem de alerta
			   PrintWriter out = response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Erro ao tentar salvar os dados');");
			   out.println("location='index.jsp';");
			   out.println("</script>");
		}
	}

}
