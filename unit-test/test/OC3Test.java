package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.Tvaerkraft;
import logic.TvaerkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class OC3Test {
	
	@Test//(expected=erUnderFejlgraenseException.class)
	public void test0GraderGiverAdvarsel() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException {
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(0);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);		
		
		fail("normalgrænse ej understøttet");
		assertEquals(0, fn.getNewton() ,0.001);
//		assertTrue(vinkel.erUnderNormalgraense());
		
	}
	
	@Test(expected=erUnderFejlgraenseException.class)
	public void testNegativVinkelGrader() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		boolean godNewton = false;
		vinkel.setGrader(-1);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		double newton = fn.getNewton();
		System.out.println(newton);
		if(0<=newton){
			godNewton = true;
		}else{
			godNewton = false;
		}
		
		assertTrue(godNewton);
//		assertTrue(vinkel.erUnderFejlgraense);
		fail("underFejlGrænse ej lavet");
		
	}
	
	@Test
	public void testBeregningAfNormalkraftKorrekt() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		assertEquals(17.131, fn.getNewton(), 0.001);
		
	}

	@Test// 
	public void test90GraderGiverAdvarsel() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(90);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		
		assertEquals(981.450, fn.getNewton(), 0.001);
//		assertTrue(vinkel.erOverNormalgraense());
		fail("erOverNormalgrænse ej lavet");
		
	}
	
	@Test// (expected=erUnderFejlgraenseException.class)
	public void testBogstavSomVinkelGrader() throws erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(Double.NaN);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
//		assertTrue(vinkel.fejlInput());
		fail("fejlInput ej lavet");
	}
	
	@Test
	public void testVinkelOverMaxgraense() throws erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(181);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		
		
//		assertTrue(vinkel.Overmaximalgraense);
		fail("overMaximalgrænse ej lavet");
	}
	@Test
	public void testMaaltTilLodretkorrekt() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(true);
		fdim.setKg(100);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		double newton =fn.getNewton();
		
		assertEquals(981.45, newton, 0.1);
	}
	
	@Test
	public void test45GraderSammenligningTilTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Tvaerkraft ft = new TvaerkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(45);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		ft.angivDimensionerendekraft(fdim);
		ft.angivVinkel(vinkel);
		assertEquals(ft.getNewton() , fn.getNewton(), 0.001);
		
	}
	@Test //(expected=erUnderFejlgraenseException.class)
	public void testvaegtSatTil0Kg() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		Dimensionerendekraft fdim = new DimensionerendekraftImpl();
		
		vinkel.setGrader(45);
		vinkel.setMaaltTilLodret(false);
		fdim.setKg(100);
		fn.angivDimensionerendekraft(fdim);
		fn.angivVinkel(vinkel);
		
		assertEquals(0, fn.getNewton(), 0.001);
//		assertTrue(fdim.VaegtUnderNormalgraense);
		fail("vægtUnderNormalgrænse ej lavet");
	}
	
	
}
