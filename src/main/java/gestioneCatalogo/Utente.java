package gestioneCatalogo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {

	// - - - - - - - - - - - - - - - - - - - - attributes
	@Id
	@GeneratedValue
	private long id;

	protected String nome;
	protected String cognome;
	protected LocalDate nascita;
	protected String tessera;

	@OneToMany(mappedBy = "utente")
	protected Set<Prestito> prestiti;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Utente() {

	}

	public Utente(String _nome, String _cognome, LocalDate _nascita, String _tessera) {
		this.nome = _nome;
		this.cognome = _cognome;
		this.nascita = _nascita;
		this.tessera = _tessera;

	}

	public Utente(String _nome, String _cognome, LocalDate _nascita, String _tessera, Set<Prestito> _prestiti) {
		this.nome = _nome;
		this.cognome = _cognome;
		this.nascita = _nascita;
		this.tessera = _tessera;
		this.prestiti = _prestiti;

	}

	// - - - - - - - - - - - - - - - - - - - - getters & setters
	public long getId() {
		return id;
	}

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

	public Set<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(Set<Prestito> _prestiti) {
		this.prestiti = _prestiti;
	}

	@Override
	public String toString() {
		return "Utente [" + id + ", " + nome + ", " + cognome + ", " + nascita + ", " + tessera + "]";
	}
}
