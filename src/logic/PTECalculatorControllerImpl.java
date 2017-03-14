package logic;

import exceptions.erUnderFejlgraenseException;

public class PTECalculatorControllerImpl implements PTECalculatorController {

	private Dimensionerendekraft fdim;
	private Tvaerkraft ft;
	private Vinkel vinkel;
	private Normalkraft fn;
	private PTEObserver observer;

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
	public void notifyObservers() {

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
	public void angivVinkel(double vinkel, boolean MaaltTilLodret) throws erUnderFejlgraenseException {
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
	public Dimensionerendekraft getDimensionerendekraft() {
		
		return fdim;
	}

}
