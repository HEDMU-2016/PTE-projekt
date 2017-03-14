package presentation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FrontPageBottomInsetter {
	private TextField FdimTextField;
	private TextField FtTextField;
	private TextField FnTextField;
	private TextArea mellemRegninger;

	public GridPane insetButtom() {

		GridPane buttomGrid = new GridPane();
		buttomGrid.setPadding(new Insets(20,20,20,20));
		mellemRegninger = new TextArea();

		HBox Fdim = new HBox();
		Label FdimLabel = new Label("Fdim: ");
		FdimTextField = new TextField();
		FdimTextField.setPromptText("Fdim");
		Fdim.getChildren().addAll(FdimLabel, FdimTextField);
		
		HBox Ft = new HBox();
		Label FtLabel = new Label("Ft: ");
		FtTextField = new TextField();
		FtTextField.setPromptText("Ft");
		Ft.getChildren().addAll(FtLabel, FtTextField);
		
		HBox Fn = new HBox();
		Label FnLabel = new Label("Fn: ");
		FnTextField = new TextField();
		FnTextField.setPromptText("Fn");
		Fn.getChildren().addAll(FnLabel, FnTextField);

		
		buttomGrid.add(Fdim, 0, 0);
		buttomGrid.add(Ft, 0, 1);
		buttomGrid.add(Fn, 0, 2);
		
		
		buttomGrid.add(mellemRegninger, 5, 0,10,10);

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