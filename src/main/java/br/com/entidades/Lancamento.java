package br.com.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Lancamento implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String numeroNotaFiscal;
	
	private String empresaOrigem;
	
	private String empresaDestino;
	
	@ManyToOne(optional = false)
	@ForeignKey(name = "usuario_fk")
	private Pessoa usuario;
	
	
	

}
