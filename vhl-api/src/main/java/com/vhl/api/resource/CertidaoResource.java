package com.vhl.api.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vhl.api.model.CertidaoEntity;
import com.vhl.api.repository.filter.CertidaoFilter;
import com.vhl.api.service.CertidaoService;


@RestController
@RequestMapping("/certidao")
public class CertidaoResource {
	
	@Autowired
	CertidaoService certidaoService;
	
	@PostMapping("/incluir")
	public ResponseEntity<?> incluir(@RequestBody CertidaoEntity entity) {
		CertidaoEntity certidao = certidaoService.incluir(entity);
		return new ResponseEntity<CertidaoEntity>(certidao, HttpStatus.CREATED);
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody CertidaoEntity entity) {
		CertidaoEntity certidao = this.certidaoService.alterar(entity);
		return new ResponseEntity<CertidaoEntity>(certidao, HttpStatus.OK);
	}

	@GetMapping("/buscarporid/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") long id) {
		Optional<CertidaoEntity> certidao = this.certidaoService.buscarPorId(id);
		return certidao.isPresent() ? new ResponseEntity<Optional<CertidaoEntity>>(certidao, HttpStatus.OK)
				: new ResponseEntity<Optional<CertidaoEntity>>(certidao, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/pesquisar")
	public ResponseEntity<?> pesquisar(CertidaoFilter filter, Pageable pageable) {
		Page<CertidaoEntity> lista = this.certidaoService.pesquisar(filter, pageable);
		return new ResponseEntity<Page<CertidaoEntity>>(lista, HttpStatus.OK);
	}

}
