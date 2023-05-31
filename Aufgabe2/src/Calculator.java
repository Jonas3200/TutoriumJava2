import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

	String operand1 = "";
	String operand2 = "";
	String operator;

	Label topLabel;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane gridPane = new GridPane();

		topLabel = new Label("0");

		// Matrix zum leichteren Beschreiben der Buttons
		String[][] buttonLabel = new String[][] { 
			{ "7", "8", "9", "÷", "C" }, 
			{ "4", "5", "6", "x", "±" },
			{ "1", "2", "3", "-", "√" }, 
			{ "0", ".", "π", "+", "=" } };

		gridPane.add(topLabel, 0, 0, 5, 1);

		// Schleife zur erstellung der Buttons mit Hilfe der Martrix
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 5; col++) {
				Button button = new Button(buttonLabel[row][col]);
				gridPane.add(button, col, row + 1); // Immer row+1, weil in row 0 das Label ist
				button.setOnAction(event -> {
					this.handlePressedButton(event); // Auslagerung der Event Verarbeitung
				});
			}
		}

		Scene scene = new Scene(gridPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Evend Verarbeitung
	private void handlePressedButton(ActionEvent event) {

		// Auslöser des Events ermitteln
		Button pressedButton = (Button) event.getTarget();

		// Label des Buttons ermitteln
		String description = pressedButton.getText();

		// Pi Abfangen
		if (description.equals("π")) {

			if (operator == null) {
				operand1 = "" + Math.PI;
			} else {
				operand2 = "" + Math.PI;
			}

			topLabel.setText("" + Math.PI);
			return; // Methode beenden
		}

		// Zahleneingaben verarbeiten
		try {
			String operand;

			// Prüfen, ob man sich vor oder hinter dem Operand befindet (gleiche logik wie
			// unten, nur mit dem Ternären Operator umgesetzt
			operand = operator == null ? operand1 : operand2;

			// Eingabe von Kommatrenner verarbeiten
			if (description.equals(".") && !operand.contains(".")) {
				operand = operand + ".";
			} else {
				operand = operand + Integer.parseInt(description);
			}

			topLabel.setText(operand);

			// hier gleiche Logik wie oben, nur zuweisung andersherum
			if (operator == null) {
				operand1 = operand;
			} else {
				operand2 = operand;
			}

		// Alle anderen eingaben verarbeiten
		} catch (NumberFormatException exception) {
			switch (description.charAt(0)) {
			case ('√'):
				// fängt den Fall ab, das zuvor bereits etwas berechnet wurde
				if (operand2.equals("")) {
					operand2 = operand1;
				}
				operator = description;// damit die Wurzel als Operator in der calculate methode verwendet werden kann
				// Kein break => '=' wird auch ausgeführt
			case ('='):
				calculate();
				operand2 = "";
				break;
			case ('C'):
				operand1 = "";
				operand2 = "";
				operator = null;
				topLabel.setText("0");
				break;
			default:
				operator = description;
			}
		}
	}

	// Berechnung durchführen
	private void calculate() {
		double ergebnis = 0;
		double operand1d = Double.parseDouble(operand1);
		double operand2d = Double.parseDouble(operand2);

		switch (operator.charAt(0)) {
		case ('√'):
			ergebnis = Math.sqrt(operand2d);
			break;
		case ('+'):
			ergebnis = operand1d + operand2d;
			break;
		case ('-'):
			ergebnis = operand1d - operand2d;
			break;
		case ('x'):
			ergebnis = operand1d * operand2d;
			break;
		case ('÷'):
			ergebnis = operand1d / operand2d;
			break;
		}

		topLabel.setText("" + ergebnis);

		// Ergebnis zu operand 1 zuweisen, damit weitergerechnet werden kann
		operand1 = "" + ergebnis;

	}

}
