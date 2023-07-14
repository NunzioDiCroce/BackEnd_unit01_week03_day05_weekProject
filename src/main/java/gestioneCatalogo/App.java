package gestioneCatalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import utils.JpaUtil;

public class App {

	private static EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("");
		System.out.println(
				"- - - - - - - - - - - - - - - App Gestione Catalogo is running - - - - - - - - - - - - - - -");

		// - - - - - - - - - - - - - - - - - - - - OBJECTS CREATION

		// - - - - - - - - - - - - - - - - - - - - SETTING & SAVING

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
