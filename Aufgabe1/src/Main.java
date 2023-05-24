import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch();
	}
	
	/**
	 * Pane: Blau 
	 * Label: Pink 
	 * Button: weiß
	 * Fields: grün 
	 */

	@Override
	public void start(Stage stage) {
		// Pane erstellen
		GridPane grid = new GridPane();	

		// Nodes erstellen (... auf die man noch zugreifen möchte) 
		Label überschrift = new Label("Willkommen zu Moodle!"); 
		Button loginButton = new Button("Log in");
		CheckBox gitterlinienCheckbox = new CheckBox("Gitterlinien");
		TextField textField = new TextField();
		PasswordField passwordField = new PasswordField();

//	

		// Nodes in Grid Pane setzen
		grid.add(
				überschrift /* Node */, 
				0 /* Column */, 
				0 /* Row */ , 
				2 /* Columnspan */, 
				1 /* Rowspan */);

		grid.add(new Label("Name:"), 0, 1);
		grid.add(textField, 1, 1);

		grid.add(new Label("Passwort:"), 0, 2);
		grid.add(passwordField, 1, 2);

		grid.add(loginButton, 1, 3);

		grid.add(gitterlinienCheckbox, 0, 5, 2, 1);

		// Alignment der Buttons setzen
		GridPane.setHalignment(überschrift, HPos.CENTER);
		GridPane.setHalignment(loginButton, HPos.RIGHT);

		// Event Handling
		gitterlinienCheckbox.setOnAction(event -> 
		grid.setGridLinesVisible(gitterlinienCheckbox.isSelected()));
		
		// Drucke den Inhalt des nameFields bei LogIn versuch 
		loginButton.setOnAction(event -> 
		System.out.println(textField.getText()));

		// Stadard "Dreiklang" zum umsetzen
		Scene scene = new Scene(grid);
		stage.setScene(scene);
		stage.show();
	}
}
