package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class FrontPageTopLeftInsetter {
	TextField horizontalAngle;
	TextField verticalAngle;
	WeightHBox weightHBox;
	ComboBox<String> weightUnit;
	Canvas triangle;
	TriangleDrawer td = new TriangleDrawer();

	public GridPane insetLeft() {
		Canvas canvas = new Canvas(150,150);
		GridPane beregnerGrid = new GridPane();
		beregnerGrid.setAlignment(Pos.TOP_LEFT);

		beregnerGrid.setGridLinesVisible(true);

		StackPane trianglePane = new StackPane();
		trianglePane.setPadding(new Insets(20, 20, 20, 20));
		triangle = td.createTriangle(canvas,40);

		horizontalAngle = new HorizontalAngleTextField();
		verticalAngle = new VerticalAngleTextField();
		weightHBox = new WeightHBox();
		
		//for at få verticalAngle textFeltet på linje med trekanten
		GridPane verticalGrid = new GridPane();
		verticalGrid.setGridLinesVisible(true);
		verticalGrid.add(verticalAngle, 0, 1);
		verticalGrid.setPadding(new Insets(125, 0, 0, 0));
		
		beregnerGrid.add(horizontalAngle, 0, 0);
		beregnerGrid.add(weightHBox, 1, 0);
		beregnerGrid.add(triangle, 0, 1,1,2);
		beregnerGrid.add(verticalGrid, 1, 2);
		
		return beregnerGrid;

	}

	public TextField getHorizontalAngle() {
		return horizontalAngle;
	}

	public void setHorizontalAngle(TextField horizontalAngle) {
		this.horizontalAngle = horizontalAngle;
	}

	public TextField getVerticalAngle() {
		return verticalAngle;
	}

	public void setVerticalAngle(TextField verticalAngle) {
		this.verticalAngle = verticalAngle;
	}

	public WeightHBox getWeightValueHBox() {
		return weightHBox;
	}

	public void setWeightValue(WeightHBox weightValue) {
		this.weightHBox = weightValue;
	}
	public Canvas getTriangle() {
		return triangle;
	}
	public void setTriangle(Canvas triangle) {
		this.triangle = triangle;
	}
	

}
