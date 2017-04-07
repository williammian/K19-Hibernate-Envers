package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

public class AdicionaPessoa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_hibernate_envers");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Rafael Cosentino");
		
		manager.persist(p1);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
