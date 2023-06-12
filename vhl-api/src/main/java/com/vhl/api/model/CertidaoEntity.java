package com.vhl.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "VHI_CERTIDAO")
public class CertidaoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CERTIDAO")
	private Long id;

	@NotNull
	@Column(name = "DS_LOCAL_ARQUIVAMENTO")
	private String localArquivamento;

	@NotNull
	@Column(name = "QTD_FOLHAS_EXCEDENTES")
	private Integer folhasExcedentes;
	
	@NotNull
	@Column(name = "NR_VIA")
	private Integer numeroVia;
	
	@NotNull
	@Column(name = "DT_VALIDADE")
	private LocalDateTime dataValidade;

}
