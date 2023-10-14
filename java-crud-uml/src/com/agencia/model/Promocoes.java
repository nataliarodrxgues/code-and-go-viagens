package com.agencia.model;

public class Promocoes {
	
	private int id_promo;
	private String PromoViagens;
	private String PromoPacotes;
	private String CodigoViagens;
	private String CodigoPacotes;
	private String CodigoReserva;
	
	public Promocoes() {
		super();
		
	}

	public Promocoes(String promoViagens, String promoPacotes, String codigoViagens, String codigoPacotes,
			String codigoReserva) {
		super();
		this.PromoViagens = promoViagens;
		this.PromoPacotes = promoPacotes;
		this.CodigoViagens = codigoViagens;
		this.CodigoPacotes = codigoPacotes;
		this.CodigoReserva = codigoReserva;
	}

	public int getId_promo() {
		return id_promo;
	}

	public void setId_promo(int id_promo) {
		this.id_promo = id_promo;
	}

	public String getPromoViagens() {
		return PromoViagens;
	}

	public void setPromoViagens(String promoViagens) {
		this.PromoViagens = promoViagens;
	}

	public String getPromoPacotes() {
		return PromoPacotes;
	}

	public void setPromoPacotes(String promoPacotes) {
		this.PromoPacotes = promoPacotes;
	}

	public String getCodigoViagens() {
		return CodigoViagens;
	}

	public void setCodigoViagens(String codigoViagens) {
		this.CodigoViagens = codigoViagens;
	}

	public String getCodigoPacotes() {
		return CodigoPacotes;
	}

	public void setCodigoPacotes(String codigoPacotes) {
		this.CodigoPacotes = codigoPacotes;
	}

	public String getCodigoReserva() {
		return CodigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.CodigoReserva = codigoReserva;
	}

	@Override
	public String toString() {
		return "Promocoes [id_promo=" + id_promo + ", promoViagens=" + PromoViagens + ", promoPacotes=" + PromoPacotes
				+ ", codigoViagens=" + CodigoViagens + ", codigoPacotes=" + CodigoPacotes + ", codigoReserva="
				+ CodigoReserva + "]";
	}




}
	