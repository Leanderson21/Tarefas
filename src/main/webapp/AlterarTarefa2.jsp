<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, br.com.tarefas.DAO.TarefaDAO, br.com.tarefas.model.Tarefa, br.com.tarefas.conexao.Conexao, java.util.*" %>    
 
<!DOCTYPE html>
<html>
<head>
  	<title>Gerenciador de Tarefas</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/style.css">
  </head>
<body>

<!--Menu principal-->
<div class="wrapper d-flex align-items-stretch">
			<nav id="sidebar">
				<div class="custom-menu">
					<button type="button" id="sidebarCollapse" class="btn btn-primary">
	          <i class="fa fa-bars"></i>
	          <span class="sr-only">Toggle Menu</span>
	        </button>
        </div>
			<div class="p-4">
	        	<ul class="list-unstyled components mb-5">
	          		<li class="active">
	            		<a href="lista-tarefas.jsp"><span class="fa fa-home mr-3"></span> Home</a>
	          		</li>
	          		<li>
	              		<a href="index.jsp"><span class="	fa fa-plus-circle mr-3"></span> Nova tarefa</a>
	          		</li>
	          		<li>
              			<a href="lista-tarefas.jsp"><span class="fa fa-list mr-3 "></span> Minhas tarefas</a>
	          		</li>
		        </ul>
		      </div>
	    	</nav>	

  <!-- Page Content  --> 
     <div id="content" class="p-4 p-md-5 pt-5">

  <!--Tirulo da tarefa--> 
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item active" aria-current="page"> <span class="fa fa-pencil mr-3"></span>Editar tarefa</li>
		  </ol>
		</nav>
		
<% 
String id = request.getParameter("id");
TarefaDAO dao = new TarefaDAO();
List<Tarefa> tarefas = dao.getTarefaById(Integer.parseInt(id));
for(Tarefa c : tarefas){
%>
 
   <form action="update?id=<%= c.getId()%>" method="post">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="">Titulo</label>
		  <input type="text"  name ="titulo" value ="<%= c.getTitulo() %>" class="form-control2" id="exampleFormControlInput1" >
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="">Descrição</label>
		  <textarea class="form-control2"  name="descricao" id="exampleFormControlTextarea1" rows="3"><%= c.getDescricao() %></textarea>
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="">Data de inicio</label>
		  <input type="date"  name="data_inicio" class="form-control2" value ="<%= c.getData_inicio() %>"  >
		</div>
		
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="">Data Final</label>
		 <input type="date" name="data_termino" class="form-control2" value ="<%= c.getData_termino() %>"  >
		</div>
		
		<button type="submit" class="btn btn-success mt-3" >Atualizar</button>
		
        </form>
		<%} %>
		
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>