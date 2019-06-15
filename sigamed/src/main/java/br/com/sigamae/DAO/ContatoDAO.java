package br.com.sigamae.DAO;

import java.util.List;

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

	public Contato buscarPorId(Long idContato) {
		
		this.factory.getTransaction().begin();
		Contato contatoRemover = this.factory.find(Contato.class, idContato);
		return contatoRemover;
		
	}
	
	public Contato buscarPorNome(String nome) {
		
		this.factory.getTransaction().begin();
		Query query =
				this.factory.createQuery("SELECT c FROM Contato c WHERE c.nome = :nome");
		query.setParameter("nome", nome);
		Contato contato = (Contato) query.getSingleResult();
		return contato;
		
	}
	
	public Contato buscarPorEmail(String email) {
		
		this.factory.getTransaction().begin();
		Query query =
				this.factory.createQuery("SELECT c FROM Contato c WHERE c.email = :email");
		query.setParameter("email", email);
		Contato contato = (Contato) query.getSingleResult();
		return contato;
		
	}
	
	public void editar(Contato contato) {
		
		this.factory.getTransaction().begin();
		this.factory.merge(contato);
		this.factory.getTransaction().commit();
		this.factory.close();
		
	}
	
	public List<Contato> contatos() {
		
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT c FROM Contato c");
		List<Contato> contatos = query.getResultList();
		for( Contato contato: contatos) {
			System.out.println(contato.getNome());
		}
		this.factory.close();
		return contatos;
		
	}
}
