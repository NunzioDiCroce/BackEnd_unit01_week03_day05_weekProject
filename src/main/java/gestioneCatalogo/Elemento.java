package gestioneCatalogo;

public abstract class Elemento {

	// - - - - - - - - - - - - - - - - - - - - attributes
	protected String isbn;
	protected String titolo;
	protected int anno;
	protected int pagine;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Elemento(String _isbn, String _titolo, int _anno, int _pagine) {
		this.isbn = _isbn;
		this.titolo = _titolo;
		this.anno = _anno;
		this.pagine = _pagine;
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

	@Override
	public String toString() {
		return "[ISBN " + isbn + " " + "\"" + titolo + "\"" + ", " + anno + ", " + pagine + " pagine" + "]";
	}

}
