package gestioneCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ElementoDAO {

	private final EntityManager entityManager;

	public ElementoDAO(EntityManager _entityManager) {
		this.entityManager = _entityManager;
	}

	public void save(Elemento _elemento) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(_elemento);
		entityTransaction.commit();
		System.out.println("Elemento salvato correttamente");
	}

	public Elemento findById(long _id) {
		Elemento elementoCercato = entityManager.find(Elemento.class, _id);
		return elementoCercato;
	}

	public void findByIdAndDelete(long _id) {
		Elemento elementoCercato = entityManager.find(Elemento.class, _id);
		if (elementoCercato != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(elementoCercato);
			entityTransaction.commit();

		} else {
			System.out.println("Elemento non trovato");
		}
	}

}
