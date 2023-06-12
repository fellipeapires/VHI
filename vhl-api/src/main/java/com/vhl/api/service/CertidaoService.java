package com.vhl.api.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vhl.api.model.CertidaoEntity;
import com.vhl.api.repository.CertidaoRepository;
import com.vhl.api.repository.filter.CertidaoFilter;


@Service
public class CertidaoService {
	
	@Autowired
	CertidaoRepository certidaoRepository;
	
	public CertidaoEntity incluir(CertidaoEntity entity) {
		return this.certidaoRepository.save(entity);
	}

	public CertidaoEntity alterar(CertidaoEntity entity) {
		return this.certidaoRepository.save(entity);
	}

	public Optional<CertidaoEntity> buscarPorId(long id) {
		return this.certidaoRepository.findById(id);
	}

	public Page<CertidaoEntity> pesquisar(CertidaoFilter filter, Pageable pageable) {
		return this.certidaoRepository.pesquisar(filter, pageable);
	}
}
