package biblioteka;

import java.util.LinkedList;

import biblioteka.interfaces.IBiblioteka;

public class Biblioteka implements IBiblioteka {
	
	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for(Knjiga knjiga: knjige)
			if(knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
		
		return rezultat;
	}

}
