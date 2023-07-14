package gestioneCatalogo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prestito {

	// - - - - - - - - - - - - - - - - - - - - attributes
	@Id
	@GeneratedValue
	private long id;

	// *****UTENTE;
	// *****ELEMENTO PRESTATO;
	protected LocalDate inizioPrestito;
	protected LocalDate restituzionePrevista; // *****calcolata automaticamente a 30 gg dalla data inizio prestito;
	protected LocalDate restituzioneEffettiva;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Prestito() {

	}

	public Prestito(LocalDate _inizioPrestito, LocalDate _restituzionePrevista, LocalDate _restituzioneEffettiva) {
		// *****UTENTE;
		// *****ELEMENTO PRESTATO;
		this.inizioPrestito = _inizioPrestito;
		this.restituzionePrevista = _restituzionePrevista;
		this.restituzioneEffettiva = _restituzioneEffettiva;

	}

	// - - - - - - - - - - - - - - - - - - - - getters & setters
	// *****UTENTE;
	// *****ELEMENTO PRESTATO;

	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}

	public void setInizioPrestito(LocalDate _inizioPrestito) {
		this.inizioPrestito = _inizioPrestito;
	}

	public LocalDate getRestituzionePrevista() {
		return restituzionePrevista;
	}

	public void setRestituzionePrevista(LocalDate _restituzionePrevista) {
		this.restituzionePrevista = _restituzionePrevista;
	}

	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(LocalDate _restituzioneEffettiva) {
		this.restituzioneEffettiva = _restituzioneEffettiva;
	}

	@Override
	public String toString() {
		return "Prestito [" + inizioPrestito + ", " + restituzionePrevista + ", " + restituzioneEffettiva + "]";
	}
}
