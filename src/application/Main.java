package application;

import javafx.application.Application;
import javafx.stage.Stage;
import presentation.FrontPage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		FrontPage fp = new FrontPage();
		fp.start(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
