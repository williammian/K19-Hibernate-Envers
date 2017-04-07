package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;

public class ConsultaPessoa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_hibernate_envers");
		EntityManager manager = factory.createEntityManager();
		
		AuditReader reader = AuditReaderFactory.get(manager);
		
		AuditQuery query = reader.createQuery().forEntitiesAtRevision(Pessoa.class, 1);
		query.add(AuditEntity.id().eq(1L));
		
		Pessoa p = (Pessoa)query.getSingleResult();
		
		System.out.println(p.getNome());
		
		manager.close();
		factory.close();
	}
}
