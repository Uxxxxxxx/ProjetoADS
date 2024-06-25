package com.projeto.ads.Enum;

public enum Periodo {
	PRIMEIRO("1"),
	SEGUNDO("2"),
	TERCEIRO("3"),
	QUARTO("4");
	
	private String periodo;
	private Periodo(String periodo) {
		this.periodo= periodo;
	}
	public String getPeriodo() {
		return this.periodo;
	}

}
