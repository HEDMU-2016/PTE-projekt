package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.VinkelEjDefineretException;

public interface Normalkraft {
 
	public void angivDimensionerendekraft(Dimensionerendekraft fdim) throws DimensionerendeKraftEjDefineretException;
	
	public void angivVinkel(Vinkel vinkel) throws VinkelEjDefineretException;
	
	public double getNewton() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public String getMellemregning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;
	
	public void setFnNewton(double fnNewton);
}
