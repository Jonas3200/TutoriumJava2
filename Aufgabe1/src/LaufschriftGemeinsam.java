import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LaufschriftGemeinsam extends Application {

	private TextField textField;
	private Label label;
	private boolean threadRunning;

	private Runnable laufschrift = () -> {
		String rightText = this.textField.getText();
		String leftText = "";

		// thread Running
		// TextFeld nicht leer

		// Andere Variante rightText.isEmpty()
		while (rightText.length() > 0 && this.threadRunning) {

			leftText += rightText.charAt(0);
			rightText = rightText.substring(1);

			final String leftTextFinal = leftText;
			final String rightTextFinal = rightText;

			Platform.runLater(() -> {
				this.label.setText(leftTextFinal);
				this.textField.setText(rightTextFinal);
			});

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		this.threadRunning = false;

	};

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) {
		HBox mainPane = new HBox();

		this.textField = new TextField();
		this.label = new Label();
		
		this.label.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

		this.label.setMinWidth(300);
		this.textField.setMinWidth(300);

		mainPane.getChildren().addAll(this.label, this.textField);

		Scene scene = new Scene(mainPane);

		// Geht beides
//		scene.addEventHandler(KeyEvent.KEY_PRESSED, null);
		scene.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				if (this.threadRunning) {
					this.threadRunning = false;
				} else {
					this.threadRunning = true;
					Thread thread = new Thread(laufschrift);
					thread.start();
				}
			}
		});

		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
