package logic;

public class PTECalculatorControllerImpl implements PTECalculatorController {

	private Dimensionerendekraft fdim;
	private Vinkel vinkel;
	private Normalkraft fn;
	private PTEObserver observer;

	@Override
	public void beregnNormalkraft() throws DimensionerendekraftEjDefineretException, VinkelEjDefineretException {

		if (fdim == null) {
			throw new DimensionerendekraftEjDefineretException();
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
	public double getNormalkraft() throws NormalkraftEjDefineretException, DimensionerendekraftEjDefineretException,
			VinkelEjDefineretException {

		if (fn == null) {
			throw new NormalkraftEjDefineretException();

		}

		double fnNewton = fn.getNewton();

		return fnNewton;

	}

	@Override
	public void notifyObservers() {

		if (observer != null) {
			observer.update();
		}

	}

}
