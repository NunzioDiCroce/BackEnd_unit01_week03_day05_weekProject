package gestioneCatalogo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class PrestitoDAO {

	private final EntityManager entityManager;

	public PrestitoDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	public void save(Prestito _prestito) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_prestito);
		entityTransaction.commit();
		System.out.println("Prestito salvato correttamente");
	}

	public Prestito findById(long _id) {
		Prestito prestitoCercato = entityManager.find(Prestito.class, _id);
		return prestitoCercato;
	}

	public void findByIdAndDelete(long _id) {
		Prestito prestitoCercato = entityManager.find(Prestito.class, _id);
		if (prestitoCercato != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(prestitoCercato);
			entityTransaction.commit();

		} else {
			System.out.println("Prestito non trovato");
		}
	}

	// - - - - - - - - - - - - - - - - - - - - 8) Ricerca di tutti i prestiti
	// scaduti e non ancora restituiti
	public List<Prestito> cercaPrestitiScaduti() {

		// LocalDate dataCheck = LocalDate.now();

		TypedQuery<Prestito> query = entityManager.createQuery(
				"SELECT p FROM Prestito p WHERE p.restituzioneEffettiva > p.restituzionePrevista", Prestito.class);

		List<Prestito> risultati = query.getResultList();

		return risultati;
	}

}
