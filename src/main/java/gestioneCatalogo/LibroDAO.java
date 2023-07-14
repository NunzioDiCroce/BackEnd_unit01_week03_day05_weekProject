package gestioneCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibroDAO {

	private final EntityManager entityManager;

	public LibroDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	// - - - - - - - - - - - - - - - - - - - - 1) Aggiunta di un elemento del
	// catalogo
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

	// - - - - - - - - - - - - - - - - - - - - 2) Rimozione di un elemento del
	// catalogo dato un codice ISBN
	public void rimuoviPerISBN(String isbn) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Libro libro = entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class)
				.setParameter("isbn", isbn).getSingleResult();

		if (libro != null) {
			entityManager.remove(libro);
			transaction.commit();
			System.out.println("Libro rimosso correttamente");
		} else {
			System.out.println("Libro non trovato");
		}
	}

}
