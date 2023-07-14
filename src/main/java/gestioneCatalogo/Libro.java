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

	public String getAutore() {
		return autore;
	}

	public void setAutore(String _autore) {
		this.autore = _autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String _genere) {
		this.genere = _genere;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito _prestito) {
		this.prestito = _prestito;
	}

	@Override
	public String toString() {
		return "Libro [" + isbn + ", " + titolo + ", " + anno + ", " + pagine + ", " + autore + ", " + genere + "]";
	}
}
