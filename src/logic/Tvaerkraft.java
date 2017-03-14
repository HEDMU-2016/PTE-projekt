package logic;

public interface Tvaerkraft {

	public String getMellemregning()throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;
	
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException;
	
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException;
	
	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

}
