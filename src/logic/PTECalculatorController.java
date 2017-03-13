package logic;

public interface PTECalculatorController {

	public void beregnNormalkraft() throws DimensionerendekraftEjDefineretException, VinkelEjDefineretException;

	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendekraftEjDefineretException, VinkelEjDefineretException;

	public void notifyObservers();

}
