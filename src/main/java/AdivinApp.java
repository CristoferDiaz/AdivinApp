import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	private TextField nombreText;
	private Button saludarButton;
	private Label saludoLablel;
	int contador=0;
	private int num = (int) ((Math.random()*100)+1);
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		nombreText = new TextField();
		nombreText.setPromptText("Introduce un numero del 1 al 100");
		nombreText.setMaxWidth(150);
		
		saludoLablel= new Label("Introduce un numero del 1 al 100");
		
		saludarButton = new Button("Comprobar");
		saludarButton.setDefaultButton(true);
		saludarButton.setOnAction(e -> onSaludarButtonAction(e));
		
		VBox root =  new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(saludoLablel,nombreText,saludarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
 
	}
	private void onSaludarButtonAction(ActionEvent e) {
		try {
		String nombre = nombreText.getText();
		int valor = Integer.parseInt(nombre);
		
		//saludoLablel.setText("¡hola "+nombre+ "!");
		//saludoLablel.setStyle("-fx-text-fill: green; -fx-font: italic bold 30 consolas");
		
			if(num!=valor) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				if(num<valor) {
				alert.setContentText(String.format("El mumero es menor que %d \n \n Vuelve a intentarlo", valor));
				}
				else
				alert.setContentText(String.format("El mumero es mayor que %d \n \n Vuelve a intentarlo", valor));
				alert.showAndWait();
				contador++;
			}
			else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText(String.format("Solo has necesitado %d intentos \n \n Vuelve y hazlo mejor", contador+1));
			alert.showAndWait();
			contador=0;
			num = (int) ((Math.random()*100)+1);
			}
			
		} catch (NumberFormatException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El numero no es valido");

			alert.showAndWait();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
