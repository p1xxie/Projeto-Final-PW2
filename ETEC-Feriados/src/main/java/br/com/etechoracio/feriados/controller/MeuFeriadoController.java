package br.com.etechoracio.feriados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.feriados.dao.MeuFeriadoDAO;
import br.com.etechoracio.feriados.model.MeuFeriado;

@RestController
@RequestMapping("/feriado")
public class MeuFeriadoController {

	@Autowired
	private MeuFeriadoDAO dao;

	@GetMapping
	public List<MeuFeriado> listar() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MeuFeriado> buscar(@PathVariable Integer id) {
		Optional<MeuFeriado> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public void inserir(@RequestBody MeuFeriado f) {
		dao.save(f);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MeuFeriado> delete(@PathVariable Integer id) {
		Optional<MeuFeriado> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MeuFeriado> update(@PathVariable Integer id, 
					   @RequestBody MeuFeriado feriado) {
		Optional<MeuFeriado> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			feriado.setId(id);
			dao.save(feriado);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
