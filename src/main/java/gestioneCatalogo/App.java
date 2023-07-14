package gestioneCatalogo;

import java.time.LocalDate;

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

		// Libro(String _isbn, String _titolo, int _anno, int _pagine, String _autore,
		// String _genere)
		Libro primoLibro = new Libro("001", "Titolo primo libro", 1990, 300, "Mario Rossi", "Avventura");

		// Rivista(String _isbn, String _titolo, int _anno, int _pagine, Periodicita
		// _periodicita)
		Rivista primaRivista = new Rivista("010", "Titolo prima rivista", 1980, 150, Periodicita.MENSILE);

		// Utente(String _nome, String _cognome, LocalDate _nascita, String _tessera)
		Utente primoUtente = new Utente("Franco", "Franchi", LocalDate.of(1980, 12, 1), "11111");

		// Prestito(LocalDate _inizioPrestito, LocalDate _restituzioneEffettiva)
		Prestito primoPrestito = new Prestito(LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 15));

		// - - - - - - - - - - - - - - - - - - - - DAO OBJECT CREATION
		ElementoDAO elementoDao = new ElementoDAO(entityManager);
		LibroDAO libroDao = new LibroDAO(entityManager);
		RivistaDAO rivistaDao = new RivistaDAO(entityManager);
		UtenteDAO utenteDao = new UtenteDAO(entityManager);
		PrestitoDAO prestitoDao = new PrestitoDAO(entityManager);

		// - - - - - - - - - - - - - - - - - - - - SETTING & SAVING

		libroDao.save(primoLibro);
		// primoConcerto.setGenere(Genere.CLASSICO);

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
