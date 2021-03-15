package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.interfaces.IBibliotekaTest;

class BibliotekaTest extends IBibliotekaTest {

	@BeforeEach
	void setUp() throws Exception {
		//samo ovde inicijalizujem intsancu biblioteke
		biblioteka = new Biblioteka();
	}

	@AfterEach
	void tearDown() throws Exception {
		biblioteka = null;
	}

	

}
