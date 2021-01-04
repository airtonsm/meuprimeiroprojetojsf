package br.com.cursojsf;

import javax.persistence.Persistence;

public class TesteJPA {
	
	public static void main(String[] args) { // cria tabelas no BD usando JPA persistence-unit
		Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");	
		
		
		
	}

}
