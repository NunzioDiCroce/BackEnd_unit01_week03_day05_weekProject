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
		Libro secondoLibro = new Libro("002", "Titolo secondo libro", 2000, 450, "Cetto Laqualunque", "Politica");
		Libro terzoLibro = new Libro("003", "Titolo terzo libro", 2010, 250, "Antonio Antoni", "Scienza");

		// Rivista(String _isbn, String _titolo, int _anno, int _pagine, Periodicita
		// _periodicita)
		Rivista primaRivista = new Rivista("010", "Titolo prima rivista", 1980, 150, Periodicita.MENSILE);
		Rivista secondaRivista = new Rivista("020", "Titolo seconda rivista", 2020, 200, Periodicita.SETTIMANALE);

		// Utente(String _nome, String _cognome, LocalDate _nascita, String _tessera)
		Utente primoUtente = new Utente("Franco", "Franchi", LocalDate.of(1980, 12, 1), "11111");
		Utente secondoUtente = new Utente("Paolo", "Bianchi", LocalDate.of(1980, 12, 1), "22222");
		Utente terzoUtente = new Utente("Checco", "Checchi", LocalDate.of(1990, 4, 1), "33333");

		// Prestito(LocalDate _inizioPrestito, LocalDate _restituzioneEffettiva)
		Prestito primoPrestito = new Prestito(LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 15));
		Prestito secondoPrestito = new Prestito(LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 31),
				LocalDate.of(2023, 7, 31));
		Prestito terzoPrestito = new Prestito(LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 31),
				LocalDate.of(2023, 7, 31));
		Prestito quartoPrestito = new Prestito(LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 30),
				LocalDate.of(2023, 6, 30));
		Prestito quintoPrestito = new Prestito(LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 30),
				LocalDate.of(2023, 7, 31));

		// - - - - - - - - - - - - - - - - - - - - DAO OBJECT CREATION
		ElementoDAO elementoDao = new ElementoDAO(entityManager);
		LibroDAO libroDao = new LibroDAO(entityManager);
		RivistaDAO rivistaDao = new RivistaDAO(entityManager);
		UtenteDAO utenteDao = new UtenteDAO(entityManager);
		PrestitoDAO prestitoDao = new PrestitoDAO(entityManager);

		// - - - - - - - - - - - - - - - - - - - - GESTIONE UTENTI E PRESTITI
//		 utenteDao.save(primoUtente);
//		 utenteDao.save(secondoUtente);
//		 utenteDao.save(terzoUtente);
//		 prestitoDao.save(primoPrestito);
//		 prestitoDao.save(secondoPrestito);
//		 prestitoDao.save(terzoPrestito);
//		 prestitoDao.save(quartoPrestito);
//		 prestitoDao.save(quintoPrestito);

		// - - - - - - - - - - - - - - - - - - - - 1) Aggiunta di un elemento del
		// catalogo
//		libroDao.save(primoLibro);
//		libroDao.save(secondoLibro);
//		libroDao.save(terzoLibro);
//		rivistaDao.save(primaRivista);
//		rivistaDao.save(secondaRivista);

		// - - - - - - - - - - - - - - - - - - - - 2) Rimozione di un elemento del
		// catalogo dato un codice ISBN
//		libroDao.rimuoviPerISBN("001");
//		rivistaDao.rimuoviPerISBN("010");

		// - - - - - - - - - - - - - - - - - - - - 3) Ricerca per ISBN
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - 3) Ricerca per ISBN");
		libroDao.cercaPerISBN("002");

		Libro libroCercato = libroDao.cercaPerISBN("002");

		if (libroCercato != null) {
			System.out.println(libroCercato.toString());
		} else {
			System.out.println("Nessun libro trovato per l'ISBN specificato");
		}

		rivistaDao.cercaPerISBN("020");

		Rivista rivistaCercata = rivistaDao.cercaPerISBN("020");

		if (rivistaCercata != null) {
			System.out.println(rivistaCercata.toString());
		} else {
			System.out.println("Nessuna rivista trovata per l'ISBN specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - 4) Ricerca per anno pubblicazione
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - 4) Ricerca per anno pubblicazione");
		java.util.List<Libro> libriPerAnno = libroDao.cercaPerAnno(2000);

		if (!libriPerAnno.isEmpty()) {
			for (Libro libro : libriPerAnno) {
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("Nessun libro trovato per l'anno specificato");
		}

		java.util.List<Rivista> rivistePerAnno = rivistaDao.cercaPerAnno(2020);

		if (!rivistePerAnno.isEmpty()) {
			for (Rivista rivista : rivistePerAnno) {
				System.out.println(rivista.toString());
			}
		} else {
			System.out.println("Nessuna rivista trovata per l'anno specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per autore
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - 5) Ricerca per autore");
		java.util.List<Libro> libriPerAutore = libroDao.cercaPerAutore("Mario Rossi");

		if (!libriPerAutore.isEmpty()) {
			for (Libro libro : libriPerAutore) {
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("Nessun libro trovato per l'autore specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - 6) Ricerca per titolo o parte di esso
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - 6) Ricerca per titolo o parte di esso");
		java.util.List<Libro> libriPerTitolo = libroDao.cercaPerTitolo("primo");

		if (!libriPerTitolo.isEmpty()) {
			for (Libro libro : libriPerTitolo) {
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("Nessun libro trovato per il titolo specificato");
		}

		java.util.List<Rivista> rivistePerTitolo = rivistaDao.cercaPerTitolo("seconda");

		if (!rivistePerTitolo.isEmpty()) {
			for (Rivista rivista : rivistePerTitolo) {
				System.out.println(rivista.toString());
			}
		} else {
			System.out.println("Nessuna rivista trovata per il titolo specificato");
		}

		// - - - - - - - - - - - - - - - - - - - - 7) Ricerca degli elementi attualmente
		// in prestito dato un numero di tessera utente
		System.out.println("");
		System.out.println(
				"- - - - - - - - - - - - - - - - - - - - 7) Ricerca degli elementi attualmente in prestito dato un numero di tessera utente");
		String numeroTesseraUtente = "11111";
		java.util.List<Libro> libriInPrestito = libroDao.cercaLibriInPrestitoPerNumeroTessera(numeroTesseraUtente);
		for (Libro libro : libriInPrestito) {
			System.out.println(libro.getTitolo());
		}

		// - - - - - - - - - - - - - - - - - - - - 8) Ricerca di tutti i prestiti
		// scaduti e non ancora restituiti
		System.out.println("");
		System.out.println(
				"- - - - - - - - - - - - - - - - - - - - 8) Ricerca di tutti i prestiti scaduti e non ancora restituiti");
		java.util.List<Prestito> prestitiScaduti = prestitoDao.cercaPrestitiScaduti();
		System.out.println(prestitiScaduti);

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
