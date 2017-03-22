package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.ErOverFejlGraenseException;
import exceptions.VinkelEjDefineretException;
import exceptions.VinkelErNaNException;
import exceptions.erUnderFejlgraenseException;
import logic.Dimensionerendekraft;
import logic.DimensionerendekraftImpl;
import logic.Enhed;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.Tvaerkraft;
import logic.TvaerkraftImpl;
import logic.Vinkel;
import logic.VinkelImpl;


public class OC4Test {

	@Test
	public void testKorrektUdregningAfTvaersKraft() throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ErOverFejlGraenseException {
		VinkelMock vinkelMock = new VinkelMock();
		DimensionerendekraftMock fdimMock = new DimensionerendekraftMock();
		Tvaerkraft ft = new TvaerkraftImpl();
		
		vinkelMock.setGrader(55);
		vinkelMock.setMaaltTilLodret(true);
		double newton = 500;
		fdimMock.setNewton(newton);
		ft.angivDimensionerendekraft(fdimMock);
		ft.angivVinkel(vinkelMock);
		
		assertEquals(409.576,ft.getNewton(), 0.001);
	}
	@Test (expected = erUnderFejlgraenseException.class)
	public void testVinkelErNaN() throws erUnderFejlgraenseException, ErOverFejlGraenseException {
		Vinkel vinkel = new VinkelImpl();

		vinkel.setGrader(Double.NaN);

		fail("erUnderFejlgraenseException Ej Lavet");
//		assertTrue(vinkel.VinkelErNullFejl);
	}
	@Test ( expected = DimensionerendeKraftEjDefineretException.class)
	public void testFdimErNullFejl() throws DimensionerendeKraftEjDefineretException {
		PTECalculatorController calc = new PTECalculatorControllerImpl();
		calc.getDimensionerendekraft();
		
		fail("VaegtErIkkeAngivetFejl Exception Ej Lavet");
	}
	@Test
	public void testUdregningAfTvaerkraft() throws erUnderFejlgraenseException, ErOverFejlGraenseException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		Vinkel vinkelMock = new VinkelMock();
		Dimensionerendekraft fdimMock = new DimensionerendekraftMock();
		Tvaerkraft ft = new TvaerkraftImpl();
		
		vinkelMock.setGrader(60);
		vinkelMock.setMaaltTilLodret(false);
		fdimMock.setNewton(800);
		ft.angivDimensionerendekraft(fdimMock);
		ft.angivVinkel(vinkelMock);
		
		assertEquals(400.00 ,ft.getNewton(),0.001);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private class VinkelMock implements Vinkel{
		double grader;
		boolean maaltTilLodret;
		@Override
		public double getGrader() {
			return grader;
		}

		@Override
		public void setGrader(double grader) throws erUnderFejlgraenseException {
			this.grader = grader;
		}

		@Override
		public boolean getMaaltTilLodret() {
			return maaltTilLodret;
		}

		@Override
		public void setMaaltTilLodret(boolean erMaaltTilLodret) {
			this.maaltTilLodret = erMaaltTilLodret;
		}
		
	}
	private class DimensionerendekraftMock implements Dimensionerendekraft{
		double kg;
		double newton;
		@Override
		public double getNewton() {
			return newton;
		}

		@Override
		public void setKg(double kg) {
			this.kg = kg;
		}

		@Override
		public double getKg() {
			return kg;
		}

		@Override
		public void setMellemRegning(String mellemRegning) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getMellemRegning() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public double setNewton(double newton) {
			this.newton = newton;
			return 0;
		}

		@Override
		public void setVaegt(double vaegt, Enhed enhed) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean erVaegtNormal() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
