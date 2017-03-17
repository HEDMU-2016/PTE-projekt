package logic;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public interface PTECalculatorController {

	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException;

	String getNormalkraftMellemregning() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void angivVaegt(double Kg) throws DimensionerendeKraftEjDefineretException;

	public void notifyObservers() throws DimensionerendeKraftEjDefineretException;

	public double getVinkel() throws VinkelEjDefineretException;

	public void angivVinkel(double vinkel, boolean maaltTilLodret) throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException;

	public void beregnTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public String getTvaerkraftMellemregning()
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public double getTvaerkraft()
			throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException, VinkelEjDefineretException;

	public void tilmeldObserver(PTEObserver observer);
	
	public double getDimensionerendekraft() throws DimensionerendeKraftEjDefineretException;

	public String getDimensionerendekraftMellemregning() throws DimensionerendeKraftEjDefineretException;

}
