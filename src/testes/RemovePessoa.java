package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

public class RemovePessoa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_hibernate_envers");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Pessoa p1 = manager.find(Pessoa.class, 1L);
		
		manager.remove(p1);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
