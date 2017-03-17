package presentation;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.PTEObserver;

public class FrontPageMediator {
	FrontPageTopLeftInsetter frontPageTopLeft;
	FrontPageBottomInsetter frontPageBottom;
	PTEObserverImpl pteObs = new PTEObserverImpl(this);
	
	public FrontPageMediator(FrontPageTopLeftInsetter frontPageTopLeft, FrontPageBottomInsetter frontPageBottom) {
		this.frontPageTopLeft = frontPageTopLeft;
		this.frontPageBottom = frontPageBottom;
	}
	public PTEObserverImpl getObserver(){
		return pteObs;
	}
	public TextField getFtTextField() {
		return frontPageBottom.getFtTextField();
	}
	
	public TextField getFnTextField() {
		return frontPageBottom.getFnTextField();
	}

	public TextField getVerticalAngleText() {
		return frontPageTopLeft.getVerticalAngle();
	}

	public TextField getHorizontalAngleText() {
		return frontPageTopLeft.getHorizontalAngle();
	}

	public TextField getWeightValueTextField() {
		return frontPageTopLeft.getWeightValueHBox().getWeightTextField();
	}

	public ComboBox<String> getWeightUnitComboBox() {
		return frontPageTopLeft.getWeightValueHBox().getUnit();
	}

	public Canvas getTriangle() {
		return frontPageTopLeft.getTriangle();
	}

	public TextField getFdimTextField() {
		return frontPageBottom.getFdimTextField();
	}
	public TextArea getMellemRegninger(){
		return frontPageBottom.getMellemRegninger();
	}
	
	public void setTriangle(Canvas triangle) {
		frontPageTopLeft.setTriangle(triangle);
	}

	public void setHorizontalAngleText(TextField tf) {
		frontPageTopLeft.setHorizontalAngle(tf);
	}

	public void setVerticalAngleText(TextField tf) {
		frontPageTopLeft.setVerticalAngle(tf);
	}

}
