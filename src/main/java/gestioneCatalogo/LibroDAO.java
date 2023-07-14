package gestioneCatalogo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
	public void rimuoviPerISBN(String _isbn) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Libro libro = entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :_isbn", Libro.class)
				.setParameter("_isbn", _isbn).getSingleResult();

		if (libro != null) {
			entityManager.remove(libro);
			transaction.commit();
			System.out.println("Libro rimosso correttamente");
		} else {
			System.out.println("Libro non trovato");
		}
	}

	// - - - - - - - - - - - - - - - - - - - - 3) Ricerca per ISBN
	public Libro cercaPerISBN(String _isbn) {
		Libro libroCercato = entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :_isbn", Libro.class)
				.setParameter("_isbn", _isbn).getSingleResult();

		return libroCercato;

	}

	// - - - - - - - - - - - - - - - - - - - - 4) Ricerca per anno pubblicazione
	public List<Libro> cercaPerAnno(int _anno) {
		TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.anno = :_anno", Libro.class)
				.setParameter("_anno", _anno);

		List<Libro> risultati = query.getResultList();

		return risultati;
	}

	// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per autore
	public List<Libro> cercaPerAutore(String _autore) {
		TypedQuery<Libro> query = entityManager
				.createQuery("SELECT l FROM Libro l WHERE l.autore = :_autore", Libro.class)
				.setParameter("_autore", _autore);

		List<Libro> risultati = query.getResultList();

		return risultati;
	}

}
