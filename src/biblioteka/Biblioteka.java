package biblioteka;

import java.util.LinkedList;

import biblioteka.interfaces.IBiblioteka;

public class Biblioteka implements IBiblioteka {
	
	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga == null || knjige.contains(knjiga))
			throw new RuntimeException("ne sme biti null ili duplikat");
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null || !knjige.contains(knjiga))
			throw new RuntimeException("knjiga ne sme biti null, mora postojati");
		knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		
		if(autor==null && isbn==null && naslov==null && izdavac==null)
			throw new RuntimeException("mora imati bar jedan kriterijum");
		
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for(Knjiga knjiga: knjige)
			if(knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
		
		return rezultat;
	}

}
