package gestioneCatalogo;

import javax.persistence.Entity;

@Entity
public class Libro extends Elemento {

	// - - - - - - - - - - - - - - - - - - - - attributes
	protected String autore;
	protected String genere;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Libro() {

	}

	public Libro(String _isbn, String _titolo, int _anno, int _pagine) {
		super(_isbn, _titolo, _anno, _pagine);
		// TODO Auto-generated constructor stub
	}

	public Libro(String _isbn, String _titolo, int _anno, int _pagine, String _autore, String _genere) {
		super(_isbn, _titolo, _anno, _pagine);
		this.autore = _autore;
		this.genere = _genere;
	}

	public Libro(String _isbn, String _titolo, int _anno, int _pagine, String _autore, String _genere,
			Prestito _prestito) {
		super(_isbn, _titolo, _anno, _pagine, _prestito);
		this.autore = _autore;
		this.genere = _genere;
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

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	@Override
	public String toString() {
		return "Libro [" + isbn + ", " + titolo + ", " + anno + ", " + pagine + ", " + autore + ", " + genere + "]";
	}
}
