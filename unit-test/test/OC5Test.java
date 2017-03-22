package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.NegativArealException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.NormalspaendingEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;
import logic.Areal;
import logic.ArealImpl;
import logic.Normalkraft;
import logic.NormalkraftImpl;
import logic.Normalspaending;
import logic.NormalspaendingImpl;
import logic.Vinkel;
import logic.VinkelImpl;

public class OC5Test {
	
	@Test
	public void testBeregnSigmaNMedMellemregning() throws DimensionerendeKraftEjDefineretException, ErOverFejlGraenseException, VinkelEjDefineretException, erUnderFejlgraenseException, NegativArealException, NormalspaendingEjDefineretException {
		Normalkraft fn = new NormalkraftImpl();
		Normalspaending sigmaN = new NormalspaendingImpl();
		Areal a = new ArealImpl();
		Vinkel vinkel = new VinkelImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(false);
		fn.setFnNewton(100);
		a.setMm2(50);
		
		assertEquals(0.34262, sigmaN.getSigmaNmm2(), 0.001);
		assertEquals("sigmaN = Fn/A" + "\n" + "= 17.131 / 50 = 0.34262", sigmaN.getMellemregning());			
	}
	
	@Test(expected=ArealEjDefineretException.class)
	public void sigmaArealEjDefineretException() throws ArealEjDefineretException, ErOverFejlGraenseException, erUnderFejlgraenseException{
		Normalkraft fn = new NormalkraftImpl();
		Vinkel vinkel = new VinkelImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(false);
		fn.setFnNewton(100);
		
		fail("ArealEjDefineretException ej kastet");		
	}
	
	@Test(expected=NormalkraftEjDefineretException.class)
	public void sigmaNewtonEjDefineretException() throws NormalkraftEjDefineretException, ErOverFejlGraenseException, erUnderFejlgraenseException, NegativArealException{
		Areal a = new ArealImpl();
		Vinkel vinkel = new VinkelImpl();
		
		vinkel.setGrader(1);
		vinkel.setMaaltTilLodret(false);
		a.setMm2(50);
		
		fail("NormalkraftEjDefineretException ej kastet");
	}	
}
