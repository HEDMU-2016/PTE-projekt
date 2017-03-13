import static org.junit.Assert.*;

import org.junit.Test;


public class OC4Test {

	@Test
	public void testKorrektUdregningAfTvaersKraft() {
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Tvearkraft ft = new TvaerkraftImpl();
		
		vinkel.setGrader(55);
		vinkel.getMaaltTilLodret(true);
		fdim.setNewton(500);
		
		assertEquals(409.58,ft.getNewton(), 0.001);
	}
	@Test
	public void testVinkelErNull() {
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Tvearkraft ft = new TvaerkraftImpl();
		
		vinkel.setGrader(null);
		vinkel.getMaaltTilLodret(true);
		fdim.setNewton(500);
		
		assertTrue(vinkel.VinkelErNullFejl);
	}
	@Test
	public void testFdimErNullFejl() {
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Tvearkraft ft = new TvaerkraftImpl();
		
		vinkel.setGrader(25);
		vinkel.getMaaltTilLodret(false);
		fdim.setNewton(null);
		
		assertTrue(fdim.V�gtErIkkeAngivetFejl);
	}
	@Test
	public void test() {
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		Tvearkraft ft = new TvaerkraftImpl();
		
		vinkel.setGrader(60);
		vinkel.getMaaltTilLodret(false);
		fdim.setNewton(800);
		
		assertEquals(400.00 ,ft.getNewton(),0.001);
	}
}
