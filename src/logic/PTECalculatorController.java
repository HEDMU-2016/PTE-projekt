package logic;

public interface PTECalculatorController {

	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException;

	String getNormalkraftMellemregning() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void angivVaegt(double Kg) throws DimensionerendeKraftEjDefineretException;

	public void notifyObservers();

	public double getVinkel() throws VinkelEjDefineretException;

	public void angivVinkel(double vinkel, boolean maaltTilLodret);

	public void beregnTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public String getTvaerkraftMellemregning()
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getTvaerkraft()
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void tilmeldObserver(PTEObserver observer);
	
	public Dimensionerendekraft getDimensionerendekraft();

}
