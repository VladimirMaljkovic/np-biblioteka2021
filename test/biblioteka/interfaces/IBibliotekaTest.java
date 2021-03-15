package biblioteka.interfaces;

import static org.junit.jupiter.api.Assertions.*;

//dodam da mi je ovo public abstract test klasa

import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;
import java.util.List;

public abstract class IBibliotekaTest {
	
	//koristicu ovu instancu da nad njom testiram iako ona jos ne postoji?
	protected IBiblioteka biblioteka;

	@Test
	void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertEquals(k, biblioteka.vratiSveKnjige().get(0));
		
	}
	
	@Test
	void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> biblioteka.dodajKnjigu(null) );
	}
	
	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		Knjiga k2 = new Knjiga();
		k2.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.dodajKnjigu(k2) );
		assertEquals("knjiga vec postoji", e.getMessage());
	}

	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		biblioteka.dodajKnjigu(k);
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.obrisiKnjigu(null));
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("23453245");
		
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.obrisiKnjigu(k2));
	}

	@Test
	void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		biblioteka.dodajKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		assertEquals(1, knjige.size());
		assertEquals(k, knjige.get(0));
	}

	@Test
	void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.pronadjiKnjigu(null, null, null, null));
	}
	
	@Test
	void testPronadjiKnjigu() {
		Knjiga k1 = new Knjiga();
		k1.setNaslov("Knjiga o dzungli");
		k1.setIsbn("123");
		biblioteka.dodajKnjigu(k1);
		Knjiga k2 = new Knjiga();
		k2.setNaslov("Dzungla zivota");
		k2.setIsbn("234");
		biblioteka.dodajKnjigu(k2);
		Knjiga k3 = new Knjiga();
		k3.setNaslov("Peepee");
		k3.setIsbn("345");
		biblioteka.dodajKnjigu(k3);
		
		List<Knjiga> knjige = biblioteka.pronadjiKnjigu(null, null, "zung", null);
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k1));
		assertTrue(knjige.contains(k2));
		
	}

}
