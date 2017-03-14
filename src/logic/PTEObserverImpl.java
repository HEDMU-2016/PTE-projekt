package logic;

import javafx.scene.control.TextArea;
import presentation.FrontPage;
import presentation.FrontPageMediator;

public class PTEObserverImpl implements PTEObserver {
	FrontPageMediator frontPageMediator;
	PTECalculatorController pteCalc = new PTECalculatorControllerImpl();

	public PTEObserverImpl(FrontPageMediator fpm) {

		frontPageMediator = fpm;
		pteCalc.tilmeldObserver(this);
	}

	public void update() {
		System.out.println(frontPageMediator);
		if (frontPageMediator.getMellemRegninger() != null) {
			frontPageMediator.getMellemRegninger().clear();
		}

		frontPageMediator.getFdimTextField().setText(Double.toString(pteCalc.getDimensionerendekraft().getNewton()));
		try {
			frontPageMediator.getFtTextField().setText(Double.toString(pteCalc.getTvaerkraft()));
			frontPageMediator.getFnTextField().setText(Double.toString(pteCalc.getNormalkraft()));
		} catch (NormalkraftEjDefineretException e) {
			e.printStackTrace();
		} catch (DimensionerendeKraftEjDefineretException e) {
			e.printStackTrace();
		} catch (VinkelEjDefineretException e) {
			e.printStackTrace();
		} catch (TvaerkraftEjDefineretException e) {
			e.printStackTrace();
		}
		insaetMellemregninger();
	}


	private void insaetMellemregninger() {
		try {
			TextArea mellemregninger = frontPageMediator.getMellemRegninger();
			mellemregninger.appendText(pteCalc.getDimensionerendekraft().getMellemRegning() + "\n");
			mellemregninger.appendText(pteCalc.getTvaerkraftMellemregning() + "\n");
			mellemregninger.appendText(pteCalc.getNormalkraftMellemregning() + "\n");
		} catch (NormalkraftEjDefineretException e) {
			e.printStackTrace();
		} catch (DimensionerendeKraftEjDefineretException e) {
			e.printStackTrace();
		} catch (VinkelEjDefineretException e) {
			e.printStackTrace();
		} catch (TvaerkraftEjDefineretException e) {
			e.printStackTrace();
		}
	}

	public PTECalculatorController getPteCalc() {
		return pteCalc;
	}

}
