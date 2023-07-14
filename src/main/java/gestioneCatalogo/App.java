package gestioneCatalogo;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import antlr.collections.List;
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
		Utente secondoUtente = new Utente("Paolo", "Bianchi", LocalDate.of(1980, 12, 1), "22222");

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
		// utenteDao.save(primoUtente);
		// utenteDao.save(secondoUtente);
		// prestitoDao.save(primoPrestito);
		// prestitoDao.save(secondoPrestito);
		// prestitoDao.save(terzoPrestito);
		// prestitoDao.save(quartoPrestito);
		// prestitoDao.save(quintoPrestito);

		// - - - - - - - - - - - - - - - - - - - - 1) Aggiunta di un elemento del
		// catalogo
		// libroDao.save(primoLibro);
		// rivistaDao.save(primaRivista);

		// - - - - - - - - - - - - - - - - - - - - LIBRO - - - - - - - - - - - - - - - -
		// - - - -
		// - - - - - - - - - - - - - - - - - - - - 2) Rimozione di un elemento del
		// catalogo dato un codice ISBN
		// libroDao.rimuoviPerISBN("001");

		// - - - - - - - - - - - - - - - - - - - - 3) Ricerca per ISBN
		// libroDao.cercaPerISBN("001");

//		Libro libroCercato = libroDao.cercaPerISBN("001");
//
//		if (libroCercato != null) {
//			System.out.println(libroCercato.toString());
//		} else {
//			System.out.println("Nessun libro trovato per l'ISBN specificato");
//		}
//
//		// - - - - - - - - - - - - - - - - - - - - 4) Ricerca per anno pubblicazione
//		List<Libro> libriPerAnno = libroDao.cercaPerAnno(1980);
//
//		if (!libriPerAnno.isEmpty()) {
//			for (Libro libro : libriPerAnno) {
//				System.out.println(libro.toString());
//			}
//		} else {
//			System.out.println("Nessun libro trovato per l'anno specificato");
//		}
//
//		// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per autore
//
//		List<Libro> libriPerAutore = libroDao.cercaPerAutore("Mario Rossi");
//
//		if (!libriPerAutore.isEmpty()) {
//			for (Libro libro : libriPerAutore) {
//				System.out.println(libro.toString());
//			}
//		} else {
//			System.out.println("Nessun libro trovato per l'autore specificato");
//		}
//
//		// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per titolo o parte di esso
//		List<Libro> libriPerTitolo = libroDao.cercaPerTitolo("primo");
//
//		if (!libriPerTitolo.isEmpty()) {
//			for (Libro libro : libriPerTitolo) {
//				System.out.println(libro.toString());
//			}
//		} else {
//			System.out.println("Nessun libro trovato per il titolo specificato");
//		}

		// - - - - - - - - - - - - - - - - - - - - RIVISTA - - - - - - - - - - - - - - -
		// - - - - -
		// - - - - - - - - - - - - - - - - - - - - 2) Rimozione di un elemento del
		// catalogo dato un codice ISBN
		// rivistaDao.rimuoviPerISBN("001");

		// - - - - - - - - - - - - - - - - - - - - 3) Ricerca per ISBN
		// rivistaDao.cercaPerISBN("001");

//				Rivista rivistaCercata = rivistaDao.cercaPerISBN("001");
		//
//				if (rivistaCercata != null) {
//					System.out.println(rivistaCercata.toString());
//				} else {
//					System.out.println("Nessuna rivista trovata per l'ISBN specificato");
//				}
		//
//				// - - - - - - - - - - - - - - - - - - - - 4) Ricerca per anno pubblicazione
//				List<Rivista> rivistePerAnno = rivistaDao.cercaPerAnno(1980);
		//
//				if (!rivistePerAnno.isEmpty()) {
//					for (Rivista rivista : rivistePerAnno) {
//						System.out.println(rivista.toString());
//					}
//				} else {
//					System.out.println("Nessuna rivista trovata per l'anno specificato");
//				}
		//
//				// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per autore
		//
//				List<Rivista> rivistePerAutore = rivistaDao.cercaPerAutore("Paolo Bianchi");
		//
//				if (!rivistePerAutore.isEmpty()) {
//					for (Rivista rivista : rivistePerAutore) {
//						System.out.println(rivista.toString());
//					}
//				} else {
//					System.out.println("Nessuna rivista trovata per l'autore specificato");
//				}
		//
//				// - - - - - - - - - - - - - - - - - - - - 5) Ricerca per titolo o parte di esso
//				List<Rivista> rivistePerTitolo = rivistaDao.cercaPerTitolo("primo");
		//
//				if (!rivistePerTitolo.isEmpty()) {
//					for (Rivista rivista : rivistePerTitolo) {
//						System.out.println(rivista.toString());
//					}
//				} else {
//					System.out.println("Nessuna rivista trovata per il titolo specificato");
//				}

		// - - - - - - - - - - - - - - - - - - - - 6) Ricerca degli elementi attualmente
		// in prestito dato un numero di tessera utente
		List<Prestito> prestitiPerNumeroTessera = prestitoDao.cercaPrestitiPerNumeroTessera("");
		
			for (Prestito prestito : prestitiPerNumeroTessera) {
				System.out.println(prestito.toString());
			}
		} 

		// - - - - - - - - - - - - - - - - - - - - entityManager & entityManagerFactory
		// closing
		entityManager.close();
		entityManagerFactory.close();

	}

}
