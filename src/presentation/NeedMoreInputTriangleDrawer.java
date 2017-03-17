package presentation;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NeedMoreInputTriangleDrawer {
	public WebView drawTriangle(){
		WebView wv = new WebView();
		WebEngine we = new WebEngine();
		we.load(getClass().getResource("/presentation/ManglerInputTrekanten.svg").toExternalForm());
		return wv;
	}
}
