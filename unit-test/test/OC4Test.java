package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.VinkelErNaNException;
import exceptions.erUnderFejlgraenseException;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Tvaerkraft;
import logic.TvaerkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;


public class OC4Test {

	@Test
	public void testKorrektUdregningAfTvaersKraft() throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Tvaerkraft ft = new TvaerkraftImpl();
		
		vinkel.setGrader(55);
		vinkel.setMaaltTilLodret(true);
		fdim.setKg(500);
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(vinkel);
		
		assertEquals(409.58,ft.getNewton(), 0.001);
	}
	@Test// (expected = VinkelErNaNException.class)
	public void testVinkelErNaN() throws erUnderFejlgraenseException {
		Vinkel vinkel = new VinkelImpl();

		vinkel.setGrader(Double.NaN);

		
		fail("VinkelErNaNException Ej Lavet");
//		assertTrue(vinkel.VinkelErNullFejl);
	}
	@Test
	public void testFdimErNullFejl() throws erUnderFejlgraenseException {
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Tvaerkraft ft = new TvaerkraftImpl();
		
		vinkel.setGrader(25);
		vinkel.setMaaltTilLodret(false);
		fdim.setNewton(0);
		
		fail("VaegtErIkkeAngivetFejl Exception Ej Lavet");
//		assertTrue(fdim.VaegtErIkkeAngivetFejl);
	}
	@Test
	public void test() throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Tvaerkraft ft = new TvaerkraftImpl();
		
		vinkel.setGrader(60);
		vinkel.setMaaltTilLodret(false);
		fdim.setNewton(800);
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(vinkel);
		
		assertEquals(400.00 ,ft.getNewton(),0.001);
	}
}
