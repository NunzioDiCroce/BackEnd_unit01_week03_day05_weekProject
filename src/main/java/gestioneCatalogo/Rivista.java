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

	public void setTitolo(String _titolo) {
		this.titolo = _titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int _anno) {
		this.anno = _anno;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int _pagine) {
		this.pagine = _pagine;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita _periodicita) {
		this.periodicita = _periodicita;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito _prestito) {
		this.prestito = _prestito;
	}

	@Override
	public String toString() {
		return "Rivista [" + isbn + ", " + titolo + ", " + anno + ", " + pagine + ", " + periodicita + "]";
	}

}
