package com.vhl.api;


import java.time.LocalDateTime;
import java.time.ZoneId;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.vhl.api.model.CertidaoEntity;
import com.vhl.api.repository.filter.CertidaoFilter;
import com.vhl.api.service.CertidaoService;

@SpringBootTest
public class VhlApiApplicationTest {
	
	@Autowired
	CertidaoService service;
	
	@Test
	public void pesquisar() {
		CertidaoFilter filter = new CertidaoFilter();
		filter.setLocalArquivamento("LOCAL B");;
		
		Pageable pageable = Pageable.ofSize(1).withPage(1);
		Page<CertidaoEntity> page = this.service.pesquisar(filter, pageable);
		
		Assertions.assertThat(page.getContent().size()).isEqualTo(1);
	}
	
	@Test
	public void buscarPorId() {
		CertidaoEntity c = this.service.buscarPorId(3).get();
		Assertions.assertThat(c.getId()).isEqualTo(3);
	}
	
	@Test
	public void incluir() {
		CertidaoEntity c = new CertidaoEntity();
		c.setDataValidade(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		c.setFolhasExcedentes(10);
		c.setNumeroVia(2);
		c.setLocalArquivamento("LOCAL Z3");
		CertidaoEntity c2 = this.service.incluir(c);
		Assertions.assertThat(c2.getLocalArquivamento()).isEqualTo(c.getLocalArquivamento());
	}
	
	@Test
	public void alterar() {
		CertidaoEntity c = this.service.buscarPorId(3).get();
		c.setLocalArquivamento("LOCAL Z2");
		CertidaoEntity c2 = this.service.alterar(c);
		Assertions.assertThat(c2.getLocalArquivamento()).isEqualTo(c.getLocalArquivamento());
	}
	
}
