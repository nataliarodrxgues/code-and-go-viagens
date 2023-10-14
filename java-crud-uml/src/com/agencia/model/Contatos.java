package com.agencia.model;

public class Contatos {

	private int id_Contato;
	private String Assunto;
	private String NomeContato;
	private String emailContato;
	private String Mensagem;

	public Contatos() {
		super();
		
	}

	public Contatos(String assunto, String nomeContato, String emailContato, String mensagem) {
		super();
		this.Assunto = assunto;
		this.NomeContato = nomeContato;
		this.emailContato = emailContato;
		this.Mensagem = mensagem;
	}

	public int getId_Contato() {
		return id_Contato;
	}

	public void setId_Contato(int id_Contato) {
		this.id_Contato = id_Contato;
	}

	public String getAssunto() {
		return Assunto;
	}

	public void setAssunto(String assunto) {
		Assunto = assunto;
	}

	public String getNomeContato() {
		return NomeContato;
	}

	public void setNomeContato(String nomeContato) {
		NomeContato = nomeContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getMensagem() {
		return Mensagem;
	}

	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Contatos [id_Contato=" + id_Contato + ", Assunto=" + Assunto + ", NomeContato=" + NomeContato
				+ ", emailContato=" + emailContato + ", Mensagem=" + Mensagem + "]";
	}
}
