package gestioneCatalogo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class RivistaDAO {

	private final EntityManager entityManager;

	public RivistaDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	// - - - - - - - - - - - - - - - - - - - - 1) Aggiunta di un elemento del
	// catalogo
	public void save(Rivista _rivista) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_rivista);
		entityTransaction.commit();
		System.out.println("Rivista salvata correttamente");
	}

	public Rivista findById(long _id) {
		Rivista rivistaCercata = entityManager.find(Rivista.class, _id);
		return rivistaCercata;
	}

	public void findByIdAndDelete(long _id) {
		Rivista rivistaCercata = entityManager.find(Rivista.class, _id);
		if (rivistaCercata != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(rivistaCercata);
			entityTransaction.commit();

		} else {
			System.out.println("Rivista non trovata");
		}
	}

	// - - - - - - - - - - - - - - - - - - - - 2) Rimozione di un elemento del
	// catalogo dato un codice ISBN
	public void rimuoviPerISBN(String _isbn) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Rivista rivista = entityManager.createQuery("SELECT l FROM Rivista l WHERE l.isbn = :_isbn", Rivista.class)
				.setParameter("_isbn", _isbn).getSingleResult();

		if (rivista != null) {
			entityManager.remove(rivista);
			transaction.commit();
			System.out.println("Rivista rimossa correttamente");
		} else {
			System.out.println("Rivista non trovata");
		}
	}

	// - - - - - - - - - - - - - - - - - - - - 3) Ricerca per ISBN
	public Rivista cercaPerISBN(String _isbn) {
		Rivista rivistaCercata = entityManager
				.createQuery("SELECT l FROM Rivista l WHERE l.isbn = :_isbn", Rivista.class)
				.setParameter("_isbn", _isbn).getSingleResult();

		return rivistaCercata;

	}

	// - - - - - - - - - - - - - - - - - - - - 4) Ricerca per anno pubblicazione
	public List<Rivista> cercaPerAnno(int _anno) {
		TypedQuery<Rivista> query = entityManager
				.createQuery("SELECT l FROM Rivista l WHERE l.anno = :_anno", Rivista.class)
				.setParameter("_anno", _anno);

		List<Rivista> risultati = query.getResultList();

		return risultati;
	}

	// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per autore
	public List<Rivista> cercaPerAutore(String _autore) {
		TypedQuery<Rivista> query = entityManager
				.createQuery("SELECT l FROM Rivista l WHERE l.autore = :_autore", Rivista.class)
				.setParameter("_autore", _autore);

		List<Rivista> risultati = query.getResultList();

		return risultati;
	}

	// - - - - - - - - - - - - - - - - - - - - 6) Ricerca per titolo o parte di esso
	public List<Rivista> cercaPerTitolo(String _titolo) {
		TypedQuery<Rivista> query = entityManager
				.createQuery("SELECT l FROM Rivista l WHERE l.titolo LIKE :_titolo", Rivista.class)
				.setParameter("_titolo", "%" + _titolo + "%");

		List<Rivista> risultati = query.getResultList();

		return risultati;
	}

	// - - - - - - - - - - - - - - - - - - - - 7) Ricerca degli elementi attualmente
	// in prestito dato un numero di tessera utente
	public List<Rivista> cercaRivisteInPrestitoPerNumeroTessera(String _numeroTessera) {
		LocalDate dataCheck = LocalDate.now();

		TypedQuery<Rivista> query = entityManager.createQuery(
				"SELECT DISTINCT r FROM Rivista r JOIN r.prestito p WHERE p.utente.tessera = :_numeroTessera AND p.restituzioneEffettiva >= :dataCheck",
				Rivista.class).setParameter("_numeroTessera", _numeroTessera).setParameter("dataCheck", dataCheck);

		List<Rivista> risultati = query.getResultList();

		return risultati;
	}

}
