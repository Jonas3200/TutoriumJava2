import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Laufschrift extends Application {

	public static final int WIDTH_PER_NODE = 300;

	private Label leftLabel = new Label();
	private TextField rightTextfield = new TextField();

	private boolean terminated = true;

	private Runnable laufschrift = () -> {

		String leftText = this.leftLabel.getText();
		String rightText = this.rightTextfield.getText();

		while (rightText.length() > 0 && !this.terminated) {
			leftText = leftText + rightText.charAt(0);

			rightText = rightText.substring(1, rightText.length());

			
			final String finalLeftText = leftText;
			final String finalRightText = rightText;

			Platform.runLater(() -> {
				this.leftLabel.setText(finalLeftText);
				this.rightTextfield.setText(finalRightText);
			});

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.terminated = true;

	};

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox mainPane = new HBox();

		mainPane.getChildren().addAll(this.leftLabel, this.rightTextfield);

		this.leftLabel.setMinWidth(WIDTH_PER_NODE);
		this.rightTextfield.setMinWidth(WIDTH_PER_NODE);

		Scene scene = new Scene(mainPane);

		scene.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				this.toggleLaufschrift();
			}
		});

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void toggleLaufschrift() {
		if (this.terminated) {
			this.terminated = !this.terminated;
			this.leftLabel.setText("");
			Thread laufschriftThread = new Thread(this.laufschrift);
			laufschriftThread.start();

		} else {
			this.terminated = true;
		}
	}

}
