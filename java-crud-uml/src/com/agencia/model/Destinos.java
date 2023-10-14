package com.agencia.model;

public class Destinos {
	
	private int id_Destino;
	private String NomeDestino;
	private String codigoDestino;
	private String codigoReserva;
	

	public Destinos() {
		super();
		
	}


	public Destinos(int id_Destino, String nomeDestino, String codigoDestino, String codigoReserva) {
		super();
		this.id_Destino = id_Destino;
		this.NomeDestino = nomeDestino;
		this.codigoDestino = codigoDestino;
		this.codigoReserva = codigoReserva;
	}


	public int getId_Destino() {
		return id_Destino;
	}


	public void setId_Destino(int id_Destino) {
		this.id_Destino = id_Destino;
	}


	public String getNomeDestino() {
		return NomeDestino;
	}


	public void setNomeDestino(String nomeDestino) {
		NomeDestino = nomeDestino;
	}


	public String getCodigoDestino() {
		return codigoDestino;
	}


	public void setCodigoDestino(String codigoDestino) {
		this.codigoDestino = codigoDestino;
	}


	public String getCodigoReserva() {
		return codigoReserva;
	}


	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}


	@Override
	public String toString() {
		return "Destinos [id_Destino=" + id_Destino + ", NomeDestino=" + NomeDestino + ", codigoDestino="
				+ codigoDestino + ", codigoReserva=" + codigoReserva + "]";
	}

}

