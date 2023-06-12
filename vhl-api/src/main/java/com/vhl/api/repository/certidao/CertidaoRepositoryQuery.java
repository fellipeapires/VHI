package com.vhl.api.repository.certidao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vhl.api.model.CertidaoEntity;
import com.vhl.api.repository.filter.CertidaoFilter;


public interface CertidaoRepositoryQuery {
	public Page<CertidaoEntity> pesquisar(CertidaoFilter filter, Pageable pageable);
}
