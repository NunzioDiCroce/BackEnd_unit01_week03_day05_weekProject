package gestioneCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RivistaDAO {

	private final EntityManager entityManager;

	public RivistaDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

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

}
