package gestioneCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

}
