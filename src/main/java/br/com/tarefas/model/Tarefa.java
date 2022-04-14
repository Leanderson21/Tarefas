package br.com.tarefas.model;

import java.util.Date;

public class Tarefa {

	//Atributos
	private int id;
	private String titulo;
	private String descricao;
	private Date data_inicio;
	private Date data_termino;
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_termino() {
		return data_termino;
	}
	public void setData_termino(Date data_termino) {
		this.data_termino = data_termino;
	}

	
	
	
}
