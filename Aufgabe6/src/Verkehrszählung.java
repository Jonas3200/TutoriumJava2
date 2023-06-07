import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Verkehrszählung extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane mainPane = new BorderPane();

		GridPane gridPane = new GridPane();

		Label anzahlLabel = new Label("Anzahl");

		TextField anzahlLkwTextField = new TextField("0");
		TextField anzahlPkwTextField = new TextField("0");

		Button lkwButton = new Button("Lkw");
		Button pkwButton = new Button("Pkw");

		Button resetButton = new Button("Reset");

		mainPane.setTop(anzahlLabel);
		mainPane.setBottom(resetButton);

		gridPane.add(anzahlLkwTextField, 0, 0);
		gridPane.add(anzahlPkwTextField, 1, 0);

		gridPane.add(lkwButton, 0, 1);
		gridPane.add(pkwButton, 1, 1);

		mainPane.setCenter(gridPane);

		primaryStage.setTitle("VZ");

		lkwButton.setOnAction(event -> {
			int previousValue;
			previousValue = Integer.parseInt(anzahlLkwTextField.getText());
			anzahlLkwTextField.setText(Integer.toString(++previousValue));
		});

		pkwButton.setOnAction(event -> {
			int previousValue;
			previousValue = Integer.parseInt(anzahlPkwTextField.getText());

			anzahlPkwTextField.setText(Integer.toString(++previousValue));

		});
		
		resetButton.setOnAction(event -> {
			anzahlLkwTextField.setText(("0"));
			anzahlPkwTextField.setText(("0"));
		});

		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
