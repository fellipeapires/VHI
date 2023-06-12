package com.vhl.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vhl.api.model.CertidaoEntity;
import com.vhl.api.repository.certidao.CertidaoRepositoryQuery;


public interface CertidaoRepository extends JpaRepository<CertidaoEntity, Long>, CertidaoRepositoryQuery {
	
}
