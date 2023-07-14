package gestioneCatalogo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito {

	// - - - - - - - - - - - - - - - - - - - - attributes
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	protected Utente utente;

	@OneToOne
	protected Elemento elemento;

	protected LocalDate inizioPrestito;
	protected LocalDate restituzionePrevista; // *****calcolata automaticamente a 30 gg dalla data inizio prestito;
	protected LocalDate restituzioneEffettiva;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Prestito() {

	}

	public Prestito(LocalDate _inizioPrestito, LocalDate _restituzionePrevista, LocalDate _restituzioneEffettiva) {
		this.inizioPrestito = _inizioPrestito;
		this.restituzionePrevista = _restituzionePrevista;
		this.restituzioneEffettiva = _restituzioneEffettiva;

	}

	public Prestito(Utente _utente, Elemento _elemento, LocalDate _inizioPrestito, LocalDate _restituzionePrevista,
			LocalDate _restituzioneEffettiva) {
		this.utente = _utente;
		this.elemento = _elemento;
		this.inizioPrestito = _inizioPrestito;
		this.restituzionePrevista = _restituzionePrevista;
		this.restituzioneEffettiva = _restituzioneEffettiva;

	}

	// - - - - - - - - - - - - - - - - - - - - getters & setters
	public long getId() {
		return id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente _utente) {
		this.utente = _utente;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento _elemento) {
		this.elemento = _elemento;
	}

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
