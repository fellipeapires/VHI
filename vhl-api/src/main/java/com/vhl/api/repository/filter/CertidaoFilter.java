package com.vhl.api.repository.filter;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CertidaoFilter {
	private Integer folhasExcedentes;
	private Integer numeroVia;
	private String localArquivamento;
}
