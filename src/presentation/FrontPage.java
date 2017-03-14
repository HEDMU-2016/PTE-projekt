package presentation;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FrontPage {
	public static FrontPageMediator frontPageMediator; 

	public void start(Stage stage) {
		BorderPane root = new BorderPane();
		Scene frontPage = new Scene(root);
		
		FrontPageTopLeftInsetter fptInsetter = new FrontPageTopLeftInsetter();
		FrontPageBottomInsetter fpbInsetter = new FrontPageBottomInsetter();
		
		//indsætter grids i borderpane
		root.setLeft(fptInsetter.insetLeft());
		root.setBottom(fpbInsetter.insetButtom());
		
		frontPageMediator = new FrontPageMediator(fptInsetter,fpbInsetter);
		
		frontPageMediator.getWeightValueTextField().requestFocus();
		stage.setScene(frontPage);
		stage.show();
	}
	public static FrontPageMediator getFrontPageMediator(){
		return frontPageMediator;
	}

}
