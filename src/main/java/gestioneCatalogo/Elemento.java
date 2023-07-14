package gestioneCatalogo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Elemento {

	// - - - - - - - - - - - - - - - - - - - - attributes
	@Id
	@GeneratedValue
	private long id;

	protected String isbn;
	protected String titolo;
	protected int anno;
	protected int pagine;

	@OneToOne(mappedBy = "elemento")
	protected Prestito prestito;

	// - - - - - - - - - - - - - - - - - - - - constructors
	public Elemento() {

	}

	public Elemento(String _isbn, String _titolo, int _anno, int _pagine) {
		this.isbn = _isbn;
		this.titolo = _titolo;
		this.anno = _anno;
		this.pagine = _pagine;

	}

	public Elemento(String _isbn, String _titolo, int _anno, int _pagine, Prestito _prestito) {
		this.isbn = _isbn;
		this.titolo = _titolo;
		this.anno = _anno;
		this.pagine = _pagine;
		this.prestito = _prestito;

	}

	// - - - - - - - - - - - - - - - - - - - - getters & setters
	public long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String _isbn) {
		this.isbn = _isbn;
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

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito _prestito) {
		this.prestito = _prestito;
	}

	@Override
	public String toString() {
		return "Elemento [" + id + ", " + isbn + ", " + titolo + ", " + anno + ", " + pagine + "]";
	}

}
