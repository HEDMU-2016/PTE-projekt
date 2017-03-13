package logic;

public interface Normalkraft {
 
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendekraftEjDefineretException;
	
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException;
	
	public double getNewton() throws DimensionerendekraftEjDefineretException, VinkelEjDefineretException;
}
