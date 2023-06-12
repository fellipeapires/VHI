package com.vhl.api.repository.certidao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.vhl.api.model.CertidaoEntity;
import com.vhl.api.model.CertidaoEntity_;
import com.vhl.api.repository.filter.CertidaoFilter;

public class CertidaoRepositoryImpl implements CertidaoRepositoryQuery{
	
	@Autowired
	private EntityManager manager;

	@Override
	public Page<CertidaoEntity> pesquisar(CertidaoFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CertidaoEntity> criteria = builder.createQuery(CertidaoEntity.class);
		Root<CertidaoEntity> root = criteria.from(CertidaoEntity.class);

		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		criteria.orderBy(builder.asc(root.get(CertidaoEntity_.localArquivamento)));			
		
		TypedQuery<CertidaoEntity> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}

	private Predicate[] criarRestricoes(CertidaoFilter filter, CriteriaBuilder builder, Root<CertidaoEntity> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (filter.getFolhasExcedentes() != null) {
			predicates.add(builder.equal(root.get(CertidaoEntity_.localArquivamento), filter.getLocalArquivamento()));
		}
		if (filter.getFolhasExcedentes() != null) {
			predicates.add(builder.equal(root.get(CertidaoEntity_.folhasExcedentes), filter.getFolhasExcedentes()));
		}
		if (filter.getNumeroVia() != null) {
			predicates.add(builder.equal(root.get(CertidaoEntity_.numeroVia), filter.getNumeroVia()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(CertidaoFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<CertidaoEntity> root = criteria.from(CertidaoEntity.class);

		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
