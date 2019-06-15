
package br.com.sigamed.utils;

import br.com.sigamed.model.Contato;
import br.com.sigamed.service.ContatoService;

public class Main {

	public static void main(String[] args) {

		ContatoService service = new ContatoService();
				
		Contato contato = new Contato();
		contato.setId(null);
		contato.setNome("José Pires");
		contato.setEmail("jpires_1@gmail.com");
		contato.setTelefone("83 98888-8888");
		
		
		Contato contatoBanco = service.buscarContatoId("jpires_1@hotmail.com");
		
		
		System.out.println("Contato " + contato.getNome()+ " retornado com sucesso !");
	}

}
