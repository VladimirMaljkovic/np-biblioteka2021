package biblioteka.interfaces;

import java.util.LinkedList;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface IBiblioteka {
	
	public void dodajKnjigu(Knjiga knjiga);
	
	public void obrisiKnjigu(Knjiga knjiga);
	
	public LinkedList<Knjiga> vratiSveKnjige();
	
	public LinkedList<Knjiga> pronadjiKnjigu(
			Autor autor,
			String isbn,
			String naslov,
			String izdavac);

}
