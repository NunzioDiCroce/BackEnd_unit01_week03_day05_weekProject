package gestioneCatalogo;

import java.time.LocalDate;
import java.util.List;

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

		// - - - - - - - - - - - - - - - - - - - - GESTIONE UTENTI E PRESTITI
		// utenteDao.save(primoUtente);
		// prestitoDao.save(primoPrestito);

		// - - - - - - - - - - - - - - - - - - - - 1) Aggiunta di un elemento del
		// catalogo
		// libroDao.save(primoLibro);
		// rivistaDao.save(primaRivista);

		// - - - - - - - - - - - - - - - - - - - - 2) Rimozione di un elemento del
		// catalogo dato un codice ISBN
		// libroDao.rimuoviPerISBN("001");

		// - - - - - - - - - - - - - - - - - - - - 3) Ricerca per ISBN
		// libroDao.cercaPerISBN("001");

		Libro libroCercato = libroDao.cercaPerISBN("001");

		if (libroCercato != null) {
			System.out.println(libroCercato.toString());
		} else {
			System.out.println("Nessun libro trovato per l'ISBN specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - 4) Ricerca per anno pubblicazione
		List<Libro> libriPerAnno = libroDao.cercaPerAnno(1980);

		if (!libriPerAnno.isEmpty()) {
			for (Libro libro : libriPerAnno) {
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("Nessun libro trovato per l'anno specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per autore

		List<Libro> libriPerAutore = libroDao.cercaPerAutore("Mario Rossi");

		if (!libriPerAutore.isEmpty()) {
			for (Libro libro : libriPerAutore) {
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("Nessun libro trovato per l'autore specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per titolo o parte di esso
		List<Libro> libriPerTitolo = libroDao.cercaPerTitolo("primo");

		if (!libriPerTitolo.isEmpty()) {
			for (Libro libro : libriPerTitolo) {
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("Nessun libro trovato per il titolo specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
