package TAD.JUnitTests;

import TAD.trees.GeneralTreeLinked;
import TAD.trees.GeneralTreeTAD;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeneralTreeTADTests {
	private GeneralTreeTAD<String> arv;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		arv = new GeneralTreeLinked<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIsEmpty() {
		assertEquals("Deve retornar true", true, arv.isEmpty() );
	}

	@Test
	public final void testAdd_1() {
		assertEquals("Deve retornar 0", 0, arv.count() );
		
	}
}
