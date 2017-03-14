package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class OC3Test {
	
	@Test
	public void test0GraderGiverAdvarsel() {
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(0);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);		
		
		assertEquals(0, fn.getNewton() ,0.001);
		assertTrue(vinkel.erUnderNormalgraense());
		
	}
	
	@Test
	public void testNegativVinkelGrader(){
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(-1);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		assertTrue(0<=fn.getNewton());
		assertTrue(vinkel.erUnderFejlgraense);
		
	}
	
	@Test
	public void testBeregningAfNormalkraftKorrekt(){
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		assertEquals(17.131, fn.getNewton(), 0.001);
		
	}

	@Test
	public void test90GraderGiverAdvarsel(){
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(90);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		assertEquals(981.450, fn.getNewton(), 0.001);
		assertTrue(vinkel.erOverNormalgraense());
		
	}
	
	@Test
	public void testBogstavSomVinkelGrader(){
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(a);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		assertTrue(vinkel.fejlInput());
	}
	
	@Test
	public void testVinkelOverMaxgraense(){
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(181);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		
		assertTrue(vinkel.Overmaximalgraense);
	}
	@Test
	public void testMaaltTilLodretkorrekt(){
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(true);
		fdim.setKg(100);
		
		assertEquals(981.45, fn.getNewton(), 0.001);
	}
	
	@Test
	public void test45GraderSammenligningTilTvaerkraft(){
		Normalkraft fn = new NormalkraftImpl();
		Tvearkraft ft = new TvaerkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(45);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		assertEquals(ft.getNewton, fn.getNewton());
		
	}
	@Test
	public void testvaegtSatTil0Kg(){
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(45);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		assertEquals(0, fn.getNewton(), 0.001);
		assertTrue(fdim.VaegtUnderNormalgraense);
	}
	
	
}
