package presentation;



import java.text.DecimalFormat;
import java.text.NumberFormat;

import exceptions.DimensionerendeKraftEjDefineretException;
import exceptions.NormalkraftEjDefineretException;
import exceptions.TvaerkraftEjDefineretException;
import exceptions.VinkelEjDefineretException;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import logic.PTEObserver;

public class PTEObserverImpl implements PTEObserver {
	FrontPageMediator frontPageMediator;
	PTECalculatorController pteCalc = new PTECalculatorControllerImpl();

	public PTEObserverImpl(FrontPageMediator fpm) {

		frontPageMediator = fpm;
		pteCalc.tilmeldObserver(this);
	}

	public void update() {
		frontPageMediator.getMellemRegninger().clear();
		   DecimalFormat formatter = new DecimalFormat("##.000");
		    
		try {
			double fDim = pteCalc.getDimensionerendekraft();
			String fDimText = formatter.format(fDim); //TODO formater til 3 decimaler
			frontPageMediator.getFdimTextField().setText(fDimText );
			String fDimMellemregning = pteCalc.getDimensionerendekraftMellemregning();
			frontPageMediator.getMellemRegninger().appendText(fDimMellemregning);
		} catch (DimensionerendeKraftEjDefineretException e1) {
			frontPageMediator.getFdimTextField().clear();
		}
		
		try {
			double tvaerkraft = pteCalc.getTvaerkraft();
			String tvaerkraftText = formatter.format(tvaerkraft);
			frontPageMediator.getFtTextField().setText(tvaerkraftText);
			String tvaerkraftMellemregning = pteCalc.getTvaerkraftMellemregning();
			frontPageMediator.getMellemRegninger().appendText(tvaerkraftMellemregning);
		} catch (TvaerkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e1) {
			frontPageMediator.getFtTextField().clear();
		}
		
		try {
			double normalkraft = pteCalc.getNormalkraft();
			String normalkraftText = formatter.format(normalkraft);
			frontPageMediator.getFnTextField().setText(normalkraftText);
			String normalkraftMellemregning = pteCalc.getNormalkraftMellemregning();
			frontPageMediator.getMellemRegninger().appendText(normalkraftMellemregning);
		} catch (NormalkraftEjDefineretException | DimensionerendeKraftEjDefineretException
				| VinkelEjDefineretException e1) {
			frontPageMediator.getFnTextField().clear();
		}
	}		

	public PTECalculatorController getPteCalc() {
		return pteCalc;
	}

}
