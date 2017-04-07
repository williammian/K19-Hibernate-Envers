package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

public class AlteraPessoa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_hibernate_envers");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Pessoa p1 = manager.find(Pessoa.class, 1L);
		p1.setNome("Marcelo Martins");
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
