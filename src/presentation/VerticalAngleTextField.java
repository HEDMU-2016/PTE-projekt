package presentation;

import javafx.scene.control.TextField;
import logic.PTECalculatorController;
import logic.PTECalculatorControllerImpl;
import observers.AngleObserver;

public class VerticalAngleTextField extends TextField{
	public VerticalAngleTextField () {
		this.setPromptText("vertical angle");
		this.setMaxSize(150, 20);
		
		this.setOnKeyReleased(e->{
			notifyObservers();
		});
		
	}
	private void notifyObservers(){
		new AngleObserver().update(this.getText(),this);
		FrontPage.frontPageMediator.getObserver().getPteCalc().angivVinkel(Double.parseDouble(this.getText()), false);
	}

}
