package com.projeto.ads.Enum;

public enum Curso {
	ADS ("Análise e Desenvolvimento de Sistemas"),
	CD ("Ciência de Dados"),
	GTI("Gestão da Tecnologia da Informação"),
	MARKETING ("Marketing"),
	RH("Recursos Humanos");
	
	private String descricao;
	private Curso(String descricao) {
		this.descricao=descricao;
	}
	public String getDescricao() {
		return this.descricao;
	}
}
