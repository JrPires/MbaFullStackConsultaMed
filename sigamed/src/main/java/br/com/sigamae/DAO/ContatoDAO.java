package br.com.sigamae.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.sigamed.model.Contato;
import br.com.sigamed.utils.JPAUtils;

public class ContatoDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar (Contato contato) {
		
		this.factory.getTransaction();
		this.factory.persist(contato);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idContato) {
		
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idContato));
	}

	private Contato buscarPorId(Long idContato) {
		
		this.factory.getTransaction().begin();
		Contato contatoRemover = this.factory.find(Contato.class, idContato);
		return contatoRemover;
	}
	
	private Contato buscarPorNome(String nome) {
		
		this.factory.getTransaction().begin();
		Query query =
				this.factory.createQuery("SELECT c FROM Contato c WHERE c.nome = :nome");
		Contato contato = (Contato) query.getSingleResult();
		return contato;
	}
	
	private Contato buscarPorEmail(String email) {
		
		this.factory.getTransaction().begin();
		Query query =
				this.factory.createQuery("SELECT c FROM Contato c WHERE c.email = :email");
		Contato contato = (Contato) query.getSingleResult();
		return contato;
	}
	
	private void editar(Contato contato) {
		
		this.factory.getTransaction().begin();
		
		Contato contatoEditar = buscarPorId(contato.getId());
		
		contatoEditar.setId(contato.getId());
		contatoEditar.setNome(contato.getNome());
		contatoEditar.setEmail(contato.getEmail());
		contatoEditar.setTelefone(contato.getTelefone());
		
		this.factory.merge(contatoEditar);
		this.factory.getTransaction().commit();
		this.factory.close();
		
	}
}
