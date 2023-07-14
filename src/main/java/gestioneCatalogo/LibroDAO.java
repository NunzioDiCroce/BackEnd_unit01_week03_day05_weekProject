package gestioneCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibroDAO {

	private final EntityManager entityManager;

	public LibroDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	public void save(Libro _libro) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_libro);
		entityTransaction.commit();
		System.out.println("Libro salvato correttamente");
	}

	public Libro findById(long _id) {
		Libro libroCercato = entityManager.find(Libro.class, _id);
		return libroCercato;
	}

	public void findByIdAndDelete(long _id) {
		Libro libroCercato = entityManager.find(Libro.class, _id);
		if (libroCercato != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(libroCercato);
			entityTransaction.commit();

		} else {
			System.out.println("Libro non trovato");
		}
	}

}
