package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("BackEnd_unit01_week03_day05_weekProject");

		} catch (Throwable ex) {
			System.err.print("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);

		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
