package gestioneCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {

	private final EntityManager entityManager;

	public UtenteDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	public void save(Utente _utente) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_utente);
		entityTransaction.commit();
		System.out.println("Utente salvato correttamente");
	}

	public Utente findById(long _id) {
		Utente utenteCercato = entityManager.find(Utente.class, _id);
		return utenteCercato;
	}

	public void findByIdAndDelete(long _id) {
		Utente utenteCercato = entityManager.find(Utente.class, _id);
		if (utenteCercato != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(utenteCercato);
			entityTransaction.commit();

		} else {
			System.out.println("Utente non trovato");
		}
	}

}
