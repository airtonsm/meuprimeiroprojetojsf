package br.com.repository;

import br.com.entidades.Pessoa;

public interface IDaoPessoa {
	
	Pessoa ConsultarUsuario(String login, String senha);

}
