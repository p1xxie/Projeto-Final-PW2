package br.com.etechoracio.feriados.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.etechoracio.feriados.enums.MeuFeriadoEnum;

@Entity
@Table(name = "cadastrar")
public class MeuFeriado {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "dsc_feriado")
	private String descricao;

	@Column(name = "data_feriado")
	private Date data;

	
	

	@Enumerated(EnumType.STRING)
	@Column(name = "tp_fer")
	private MeuFeriadoEnum tipo;




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public Date getData() {
		return data;
	}




	public void setData(Date data) {
		this.data = data;
	}




	public MeuFeriadoEnum getTipo() {
		return tipo;
	}




	public void setTipo(MeuFeriadoEnum tipo) {
		this.tipo = tipo;
	}
	
	
	



}
