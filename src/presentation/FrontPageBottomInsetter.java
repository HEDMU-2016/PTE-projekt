package presentation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FrontPageBottomInsetter {
	private TextField FdimTextField;
	private TextField FtTextField;
	private TextField FnTextField;
	private TextField MBTextField;
	private TextField tauTextField;
	private TextField sigmaNTextField;
	private TextField sigmaBTextField;
	private TextField sigmaRefTextField;
	private TextField SFTextField;
	private TextArea mellemRegninger;
	

	public GridPane insetButtom() {

		GridPane buttomGrid = new GridPane();
		buttomGrid.setPadding(new Insets(20,20,20,20));
		mellemRegninger = new TextArea();

		Label FdimLabel = new Label("Fdim: ");
		FdimTextField = new TextField();
		FdimTextField.setPromptText("Fdim");
		
		Label FtLabel = new Label("Ft: ");
		FtTextField = new TextField();
		FtTextField.setPromptText("Ft");
		
		Label FnLabel = new Label("Fn: ");
		FnTextField = new TextField();
		FnTextField.setPromptText("Fn");
		
		
		Label tauLabel = new Label("Tau: ");
		tauTextField = new TextField();
		tauTextField.setPromptText("Tau");
		
		Label MBLabel = new Label("MB: ");
		MBTextField = new TextField();
		MBTextField.setPromptText("MB");
		
		Label sigmaNLabel = new Label("sigmaN: ");
		sigmaNTextField = new TextField();
		sigmaNTextField.setPromptText("sigmaN");
		
		Label sigmaBLabel = new Label("sigmaB: ");
		sigmaBTextField = new TextField();
		sigmaBTextField.setPromptText("sigmaB");
		
		Label sigmaRefLabel = new Label("sigmaRef: ");
		sigmaRefTextField = new TextField();
		sigmaRefTextField.setPromptText("sigmaRef");
		
		Label SFLabel = new Label("SF: ");
		SFTextField = new TextField();
		SFTextField.setPromptText("SF");

		//TODO mangler get og set motoder på, MB - tau - sigmaN - sigmaB - sigmaRef - SF
		
		buttomGrid.add(FdimLabel, 0, 0);
		buttomGrid.add(FdimTextField, 1, 0);
		buttomGrid.add(FnLabel, 0, 1);
		buttomGrid.add(FnTextField, 1, 1);
		buttomGrid.add(FtLabel, 0, 2);
		buttomGrid.add(FtTextField, 1, 2);
		buttomGrid.add(MBLabel, 0, 3);
		buttomGrid.add(MBTextField, 1, 3);
		buttomGrid.add(tauLabel, 0, 4);
		buttomGrid.add(tauTextField, 1, 4);
		buttomGrid.add(sigmaNLabel, 0, 5);
		buttomGrid.add(sigmaNTextField, 1, 5);
		buttomGrid.add(sigmaBLabel, 0, 6);
		buttomGrid.add(sigmaBTextField, 1, 6);
		buttomGrid.add(sigmaRefLabel, 0, 7);
		buttomGrid.add(sigmaRefTextField, 1, 7);
		buttomGrid.add(SFLabel, 0, 8);
		buttomGrid.add(SFTextField, 1, 8);
		
		buttomGrid.add(mellemRegninger, 2, 0,4,10);

		return buttomGrid;
	}

	public TextField getFdimTextField() {
		return FdimTextField;
	}

	public void setFdimTextField(TextField fdimTextField) {
		FdimTextField = fdimTextField;
	}

	public TextArea getMellemRegninger() {
		return mellemRegninger;
	}

	public void setMellemRegninger(TextArea mellemRegninger) {
		this.mellemRegninger = mellemRegninger;
	}

	public TextField getFtTextField() {
		return FtTextField;
	}

	public void setFtTextField(TextField ftTextField) {
		FtTextField = ftTextField;
	}

	public TextField getFnTextField() {
		return FnTextField;
	}

	public void setFnTextField(TextField fnTextField) {
		FnTextField = fnTextField;
	}
	

}