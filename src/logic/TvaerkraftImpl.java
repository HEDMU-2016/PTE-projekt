package logic;

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
		double ftNewton;
		
		if (erMaaltTilLodret) {
			ftNewton = Math.cosh(grader) * fdimNewton;
			mellemregning = "FT = cos(vinkel) * FDim" + "\n" + ftNewton + " = cos(" + grader + ") * " + ftNewton + "\n"; 
		}
		
		else {
			ftNewton = Math.sinh(grader) * fdimNewton;
			mellemregning = "FT = sin(vinkel) * FDim" + "\n" + ftNewton + " = sin(" + grader + ") * " + ftNewton + "\n"; 
		}
		
		return ftNewton;
	}

}
