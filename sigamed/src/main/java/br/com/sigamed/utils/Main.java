
package br.com.sigamed.utils;

import br.com.sigamed.model.Contato;
import br.com.sigamed.service.ContatoService;

public class Main {

	public static void main(String[] args) {

		ContatoService service = new ContatoService();
				
		Contato contato = new Contato();
		contato.setId(null);
		contato.setNome("Jose Pires");
		contato.setEmail("jpires_1@gmail.com");
		contato.setTelefone("83 98888-8888");

//		service.salvar(contato);
		
//		Contato contatoBanco = service.buscaContatoId(2L);
		
		service.listarContatos();
		
//		for(Contato c : contatos) {
//			System.out.println(c.getNome());
//		}
		
//		System.out.println("Contato " + contato.getEmail() + " retornado com sucesso.");

		
	}

}
