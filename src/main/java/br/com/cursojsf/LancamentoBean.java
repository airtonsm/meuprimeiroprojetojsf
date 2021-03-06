package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.dao.DaoGeneric;
import br.com.entidades.Lancamento;
import br.com.entidades.Pessoa;
import br.com.repository.IDaoLancamento;
import br.com.repository.IDaoLancamentoImpl;

@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {

	private Lancamento lancamento = new Lancamento();
	private DaoGeneric<Lancamento> daoGeneric = new DaoGeneric<Lancamento>();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private IDaoLancamento daoLancamento =  new IDaoLancamentoImpl();
	
	
	
	public String salvar() {
		
		//captura qual user está logado
		FacesContext context =  FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");
		
		lancamento.setUsuario(pessoaUser);
		daoGeneric.merge(lancamento);
		
		carregarLancamento();
						
		
		return"";
	}
	
	@PostConstruct // após abrir tela pela primeira vez métedo é invocado
	private void carregarLancamento() {
		
		//captura user logado
		FacesContext context =  FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");
		
		lancamentos =  daoLancamento.consultar(pessoaUser.getId());
		
		
	}

	public String novo() {		
		lancamento = new Lancamento();
		return"";
	}
	
	public String remove() {	
		daoGeneric.deletePorId(lancamento);// deleta lançamento
		lancamento =  new Lancamento(); // limpa objeto
		carregarLancamento(); // recarraga lista de lançamentos novamente
		return"";
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public DaoGeneric<Lancamento> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Lancamento> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
