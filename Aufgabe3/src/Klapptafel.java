import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Klapptafel extends Application {

	char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ä', 'Ö', 'Ü', ' ' };

	TextField textField;
	Label[] labels;

	private Runnable klappern = () -> {

		String zielText = textField.getText();
		String newText = "";

		if (!(zielText.length() <= 10)) {
			throw new RuntimeException(":(");
		}

		zielText = zielText.toUpperCase();
		char[] zielTextArr = zielText.toCharArray();

		int count = 0;
		while (!zielText.trim().equals(newText.trim()) && count < 100) {
			count++;

			for (int i = 0; i < zielTextArr.length; i++) {
				if (zielTextArr[i] != labels[i].getText().charAt(0)) {
					next(labels[i]);
				}
			}

			StringBuilder sb = new StringBuilder();
			for (Label label : labels) {
				sb.append(label.getText());
			}
			newText = sb.toString();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox mainPane = new VBox();

		HBox labelsBox = new HBox();

		textField = new TextField();

		labels = new Label[10];

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label("Ö");
		}

		labelsBox.getChildren().addAll(labels);
		mainPane.getChildren().addAll(textField, labelsBox);

		Scene scene = new Scene(mainPane);

		scene.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				Thread thread = new Thread(klappern);
				thread.start();

			}
		});

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void next(Label labelToChange) { // nächste Zeichen
		int index;

		char oldText = labelToChange.getText().charAt(0);

		switch (oldText) {
		case 'Ä':
			index = 26;
			break;
		case 'Ö':
			index = 27;
			break;
		case 'Ü':
			index = 28;
			break;
		case ' ':
			index = 29;
			break;
		default:
			index = oldText - (int) 'A';
		}

		index = (index + 1) % alphabet.length;

		final String newText = "" + alphabet[index];

		Platform.runLater(() -> {
			labelToChange.setText(newText);
		});

	}

}
