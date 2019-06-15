package br.com.sigamed.service;

import java.util.List;

import br.com.sigamed.model.Contato;

public interface ContatoServiceInterface {

	public void salvar(Contato contato);
	public void remover(Long idContato);
	public List<Contato> listarContatos();
	public void editar(Contato contato);
	public Contato buscarContatoNome();
	public Contato buscarContatoEmail();
	public Contato buscaContatoId(Long idContato);
	
}
