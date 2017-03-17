package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class NormalkraftImpl implements Normalkraft {
	
	private Vinkel vinkel;
	private Dimensionerendekraft fdim;
	public String mellemRegning;
	
	@Override
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException {
		if(fdim==null) 
			throw new DimensionerendeKraftEjDefineretException();
		this.fdim = fdim;
	}
	@Override
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {
		if(vinkel==null) 
			throw new VinkelEjDefineretException();
		this.vinkel = vinkel;
	}

	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		double grader = vinkel.getGrader();
		boolean erMaaltTilLodret = vinkel.getMaaltTilLodret();
		double fdimNewton = fdim.getNewton();
		double fnNewton = 0;
		double sin = Math.sin(Math.toRadians(grader));
		double cos = Math.cos(Math.toRadians(grader));
		
<<<<<<< HEAD
		
		if (erMaaltTilLodret) {
			fnNewton = Math.sin(grader) * fdimNewton;
			mellemRegning = "Fn = sin("+vinkel+") * "+fdimNewton;
		}
		
		else {
			fnNewton = Math.cos(grader) * fdimNewton;
			mellemRegning = "Fn = cos("+vinkel+") * "+fdimNewton;
=======
		if (erMaaltTilLodret==false) {
			fnNewton = sin * fdimNewton;
			mellemRegning = "Fn = sin("+vinkel.getGrader()+") * "+fdimNewton;
		} else {
			fnNewton = cos * fdimNewton;
			mellemRegning = "Fn = cos("+vinkel.getGrader()+") * "+fdimNewton;
>>>>>>> branch 'master' of https://github.com/HEDMU-2016/PTE-projekt.git
		}
		
		return fnNewton;
	}

	@Override //TO DO
	public String getMellemregning() {
		return mellemRegning;
	}

}
