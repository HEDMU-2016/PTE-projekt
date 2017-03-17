package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public class TvaerkraftImpl implements Tvaerkraft {
	private Vinkel vinkel;
	private Dimensionerendekraft fdim;
	private String mellemregning = null;
	
	@Override
	public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		return mellemregning;
	}
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

	@Override
	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		double grader = vinkel.getGrader();
		boolean erMaaltTilLodret = vinkel.getMaaltTilLodret();
		double fdimNewton = fdim.getNewton();

		double ftNewton = 0;
		double sinV = Math.sin(Math.toRadians(grader));
		double cosV = Math.cos(Math.toRadians(grader));
		if (erMaaltTilLodret==false) {
			ftNewton = cosV * fdimNewton;
			mellemregning = "FT = cos(vinkel) * FDim" + "\n" + ftNewton + " = cos(" + grader + ") * " + fdimNewton; 
		}
		
		else {
			ftNewton = sinV * fdimNewton;
			mellemregning = "FT = sin(vinkel) * FDim" + "\n" + ftNewton + " = sin(" + grader + ") * " + fdimNewton; 

		}
		
		return ftNewton;
	}

}
