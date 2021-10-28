package com.lead.dell.movies.Dto;

public class ErroForm {
	private String camp;
	private String erro;
	
	public ErroForm(String camp, String erro) {
		this.camp = camp;
		this.erro = erro;
	}

	public String getCamp() {
		return camp;
	}

	public String getErro() {
		return erro;
	}
	
}


