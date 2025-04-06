package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	Giocatore g;
	
	@Before
	public void setUp() {
		g = new Giocatore();
		g.setCfu(20);
	}
	
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, g.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		g.setCfu(3);
		assertEquals(3, g.getCfu());
	}

	@Test
	public void testGetBorsaDefault() {
		assertNotNull(g.getBorsa());
	}

}
