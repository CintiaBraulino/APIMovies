package com.lead.dell.movies.Dto;

public class ErroFormDto {
	
	private String camp;
	private String erro;
	
	public ErroFormDto(String camp, String erro) {
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
