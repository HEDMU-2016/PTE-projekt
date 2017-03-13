package logic;

public class NormalkraftImpl implements Normalkraft {
	
	private Vinkel vinkel;
	private Dimensionerendekraft fdim;
	

	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendekraftEjDefineretException {

	}

	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException {

	}

	public double getNewton() throws DimensionerendekraftEjDefineretException, VinkelEjDefineretException {
		double grader = vinkel.getGrader();
		boolean erMaaltTilLodret = vinkel.getMaaltTilLodret();
		double fdimNewton = fdim.getNewton();
		double fnNewton = 0;
		
		if (erMaaltTilLodret) {
			fnNewton = Math.cos(grader) * fdimNewton;
		}
		
		else {
			fnNewton = Math.sin(grader) * fdimNewton;
		}
		
		return fnNewton;
	}

}
