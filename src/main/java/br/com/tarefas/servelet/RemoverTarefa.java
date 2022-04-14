package br.com.tarefas.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.DAO.TarefaDAO;
import br.com.tarefas.conexao.Conexao;


@WebServlet("/removeTarefa")
public class RemoverTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		System.out.println(id);
		
	try {
		Connection conn = Conexao.getConnection();
		TarefaDAO dao = new TarefaDAO();
		dao.delete(Integer.parseInt(id));
		
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("location='lista-tarefas.jsp';");
		out.println("</script>");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		
	}
	
	

}
