package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.erUnderFejlgraenseException;
import logic.Normalkraft;
import logic.NormalkraftImpl;

public class OC5Test {
	
	@Test
	public void testBeregnSigmaNMedMellemregning() {
		Normalkraft fn = new NormalkraftImpl();
		Areal a = new ArealImpl();
		Normalspaending sigmaN = new NormalspaendingImpl();
		
		fn.setNewton(100);
		a.setMm2(50);
		sigmaN.setNormalkraft(fn);
		sigmaN.setAreal(a);
		
		assertEquals(2, sigmaN.getNmm2());
		assertEquals("sigmaN = Fn/A" + "\n" + "= 100/50 = 2", sigmaN.getMellemregning());			
	}
	
	@Test(expected=ArealEjDefineretException.class)
	public void sigmaArealEjDefineretException() throws ArealEjDefineretException{
		Normalkraft fn = new NormalkraftImpl();
		Normalspaending sigmaN = new NormalspaendingImpl();
		
		fn.setNewton(200);
		sigmaN.setNormalkraft(fn);
		sigmaN.getNmm2();
		
		fail("ArealEjDefineretException ej kastet");		
	}
	
	@Test(expected=NewtonEjDefineretException.class)
	public void sigmaNewtonEjDefineretException() throws NewtonEjDefineretException{
		Areal a = new ArealImpl();
		Normalspaending sigmaN = new NormalspaendingImpl();
		
		a.setMm2();
		sigmaN.getAreal(a);
		sigmaN.getNmm2();
		
		fail("NewtonEjDefineretException ej kastet");
	}	
}
