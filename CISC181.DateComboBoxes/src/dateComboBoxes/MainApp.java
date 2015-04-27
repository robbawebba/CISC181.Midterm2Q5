package dateComboBoxes;

import java.io.IOException;

import dateComboBoxes.view.DateController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane dateScreen;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Date Picker");
		showDateScreen();
		
	}

	public void showDateScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/DateScreen.fxml"));
			dateScreen = (AnchorPane) loader.load();

			Scene dateScene = new Scene(dateScreen);

			primaryStage.setScene(dateScene);
			DateController controller = loader.getController();
			controller.setMainApp(this);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
