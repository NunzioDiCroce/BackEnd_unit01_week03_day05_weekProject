package gestioneCatalogo;

import java.time.LocalDate;

public class Prestito {

	// - - - - - - - - - - - - - - - - - - - - attributes
	// *****UTENTE;
	// *****ELEMENTO PRESTATO;
	protected LocalDate inizioPrestito;
	protected LocalDate restituzionePrevista; // *****calcolata automaticamente a 30 gg dalla data inizio prestito;
	protected LocalDate restituzioneEffettiva;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Prestito(LocalDate _inizioPrestito, LocalDate _restituzionePrevista, LocalDate _restituzioneEffettiva) {
		// *****UTENTE;
		// *****ELEMENTO PRESTATO;
		this.inizioPrestito = _inizioPrestito;
		this.restituzionePrevista = _restituzionePrevista;
		this.restituzioneEffettiva = _restituzioneEffettiva;

	}

	// - - - - - - - - - - - - - - - - - - - - getters & setters
	public String getNome() {
		return nome;
	}

	public void setNome(String _nome) {
		this.nome = _nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String _cognome) {
		this.cognome = _cognome;
	}

	public LocalDate getNascita() {
		return nascita;
	}

	public void setNascita(LocalDate _nascita) {
		this.nascita = _nascita;
	}

	public String getTessera() {
		return tessera;
	}

	public void setTessera(String _tessera) {
		this.tessera = _tessera;
	}

	@Override
	public String toString() {
		return "Utente [" + nome + ", " + cognome + ", " + nascita + ", " + tessera + "]";
	}
}
