package logic;

import exceptions.ArealEjDefineretException;
import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NegativKgException;
import exceptions.ForskydningsspaendingEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import exceptions.erUnderFejlgraenseException;

public class PTECalculatorControllerImpl implements PTECalculatorController {

	private Dimensionerendekraft fdim;
	private Tvaerkraft ft;
	private Vinkel vinkel;
	private Normalkraft fn;
	private ForskydningsSpaendning tau;
	private PTEObserver observer;
	private Normalspaending sigmaN;

	@Override
	public void beregnNormalkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (fdim == null) {
			throw new DimensionerendeKraftEjDefineretException();
		}

		if (vinkel == null) {
			throw new VinkelEjDefineretException();
		}

		fn = new NormalkraftImpl();

		fn.angivDimensionerendekraft(fdim);

		fn.angivVinkel(vinkel);

		notifyObservers();

	}

	@Override
	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException {

		if (fn == null) {
			throw new NormalkraftEjDefineretException();

		}

		double fnNewton = fn.getNewton();

		return fnNewton;

	}

	@Override
	public String getNormalkraftMellemregning() throws NormalkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (fn == null) {
			throw new NormalkraftEjDefineretException();

		}

		String normalkraftMellemregning = fn.getMellemregning();

		return normalkraftMellemregning;

	}

	@Override
	public void angivVaegt(double kg) throws DimensionerendeKraftEjDefineretException {
		fdim = new DimensionerendekraftImpl();

		fdim.setKg(kg);

		notifyObservers();
	}
	
	@Override
	public double beregnForskydningsspaendning() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException, ForskydningsspaendingEjDefineretException, ArealEjDefineretException, TvaerkraftEjDefineretException {
		return tau.getNmm2();				
	}
	
	@Override
	public double beregnNormalspaending() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException{
		return sigmaN.beregnNormalspaending();
	}

	@Override
	public void notifyObservers() throws DimensionerendeKraftEjDefineretException {

		if (observer != null) {
			observer.update();
		}

	}

	@Override
	public double getVinkel() throws VinkelEjDefineretException {
		if (vinkel == null)
			throw new VinkelEjDefineretException();
		return vinkel.getGrader();
	}

	@Override
	public void beregnTvaerkraft() throws DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {
		if (fdim == null) {
			throw new DimensionerendeKraftEjDefineretException();
		}

		if (vinkel == null) {
			throw new VinkelEjDefineretException();
		}

		ft = new TvaerkraftImpl();

		ft.angivDimensionerendekraft(fdim);

		ft.angivVinkel(vinkel);

		notifyObservers();

	}

	@Override
	public String getTvaerkraftMellemregning() throws TvaerkraftEjDefineretException,
			DimensionerendeKraftEjDefineretException, VinkelEjDefineretException {

		if (ft == null) {
			throw new TvaerkraftEjDefineretException();

		}

		String tvaerkraftMellemregning = ft.getMellemregning();

		return tvaerkraftMellemregning;

	}

	@Override
	public double getTvaerkraft() throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException,
			VinkelEjDefineretException {

		if (ft == null) {
			throw new TvaerkraftEjDefineretException();

		}

		double ftNewton = ft.getNewton();

		return ftNewton;
	}

	@Override
	public void angivVinkel(double vinkel, boolean MaaltTilLodret) throws erUnderFejlgraenseException, DimensionerendeKraftEjDefineretException {
		if(this.vinkel == null){
			this.vinkel = new VinkelImpl();
		}
		
		this.vinkel.setGrader(vinkel);
		this.vinkel.setMaaltTilLodret(MaaltTilLodret);
		
		try {
			beregnTvaerkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beregnNormalkraft();
		} catch (DimensionerendeKraftEjDefineretException | VinkelEjDefineretException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		notifyObservers();
	}

	@Override
	public void tilmeldObserver(PTEObserver observer) {
		this.observer = observer;
		
	}
	@Override
	public double getDimensionerendekraft() throws DimensionerendeKraftEjDefineretException {
		if(fdim == null)
			throw new DimensionerendeKraftEjDefineretException();
		return fdim.getNewton();
	}

	@Override
	public String getDimensionerendekraftMellemregning() throws DimensionerendeKraftEjDefineretException {
		if(fdim == null)
			throw new DimensionerendeKraftEjDefineretException();
		return fdim.getMellemRegning();
	}
	
	@Override
	public void setFtNewton(double ftNewton) throws TvaerkraftEjDefineretException, DimensionerendeKraftEjDefineretException{
		ft = new TvaerkraftImpl();

		ft.setFtNewton(ftNewton);

		notifyObservers();
	}
	
	@Override
	public void setFnNewton(double fnNewton) throws DimensionerendeKraftEjDefineretException {
		fn = new NormalkraftImpl();
		fn.setFnNewton(fnNewton);
		
		notifyObservers();
	}

	@Override
	public boolean erVaegtNormal() throws NegativKgException {
		fdim = new DimensionerendekraftImpl();
		
		return false;
	}
	

}
