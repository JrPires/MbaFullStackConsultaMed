package br.com.sigamed.service;

import java.util.List;

import br.com.sigamae.DAO.ContatoDAO;
import br.com.sigamed.model.Contato;

public class ContatoService implements ContatoServiceInterface {

	private ContatoDAO dao;
	
	
	public ContatoService(ContatoDAO dao) {
		this.dao = dao;
	}

	@Override
	public void salvar(Contato contato) {
		this.dao.salvar(contato);
	}

	@Override
	public void remover(Long idContato) {
		
	}

	@Override
	public List<Contato> listarContatos() {
		return null;
	}

	@Override
	public void editar(Contato contato) {
		
	}

	@Override
	public Contato buscarContatoNome() {
		return null;
	}

	@Override
	public Contato buscarContatoEmail() {
		return null;
	}

}
