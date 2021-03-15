package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	
	Autor a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testSetIme() {
		a.setIme("Pera");
		assertEquals("Pera", a.getIme());
	}
	
	@Test
	@DisplayName("Testira uneto null za ime")
	void testSetImeNull() {		
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setIme(null));
	}
	
	@Test
	@DisplayName("Testira uneto ime manje od 1 karaktera")
	void testSetImeJednoSlovo() {
		
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setIme("P"));
	}
	
	@Test
	@DisplayName("Testira uneto prezime od 0 karaktera")
	void testSetImeNulaSlovo() {
		
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setIme(""));
	}

	@Test
	void testSetPrezime() {
		a.setPrezime("Peric");
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	@DisplayName("Testira uneto null za prezime")
	void testSetPrezimeNull() {		
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setPrezime(null));
	}
	
	@Test
	@DisplayName("Testira uneto prezime manje od 1 karaktera")
	void testSetPrezimemeJednoSlovo() {
		
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setPrezime("P"));
	}

	@Test
	void testAutor() {
		assertNotNull(a);
	}

	@Test
	void testAutorStringString() {
		a = new Autor("Pera", "Peric");
		assertNotNull(a);
		assertEquals("Pera", a.getIme());
		assertEquals("Peric", a.getPrezime());

	}

	@Test
	void testToString() {
		a.setIme("Pera");
		a.setPrezime("Peric");
		String s = a.toString();
		
		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));	}

	
	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Peric, Pera, Mikic, false",
		"Pera, Peric, Mika, Peric, false",
		"Pera, Peric, Mika, Mikic, false",
	})
	void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
			
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor b = new Autor(ime2, prezime2);
		
		assertEquals(eq, a.equals(b));
		
	}

}
