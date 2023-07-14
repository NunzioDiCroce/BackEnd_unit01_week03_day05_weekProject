package gestioneCatalogo;

import javax.persistence.Entity;

@Entity
public class Rivista extends Elemento {

	// - - - - - - - - - - - - - - - - - - - - attributes
	protected Periodicita periodicita;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Rivista() {

	}

	public Rivista(String _isbn, String _titolo, int _anno, int _pagine) {
		super(_isbn, _titolo, _anno, _pagine);
		// TODO Auto-generated constructor stub
	}

	public Rivista(String _isbn, String _titolo, int _anno, int _pagine, Periodicita _periodicita) {
		super(_isbn, _titolo, _anno, _pagine);
		this.periodicita = _periodicita;
	}

	public Rivista(String _isbn, String _titolo, int _anno, int _pagine, Periodicita _periodicita, Prestito _prestito) {
		super(_isbn, _titolo, _anno, _pagine, _prestito);
		this.periodicita = _periodicita;
	}

	// - - - - - - - - - - - - - - - - - - - - getters & setters
	public String getIsbn() {
		return isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getAnno() {
		return anno;
	}

	public int getPagine() {
		return pagine;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	@Override
	public String toString() {
		return "Rivista [" + isbn + ", " + titolo + ", " + anno + ", " + pagine + ", " + periodicita + "]";
	}

}
