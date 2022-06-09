package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Scene2Controller {

	@FXML
	Label nameLabel;
	
	@FXML
	TextArea textoChat  = new TextArea();
	@FXML
	public void displayName(String username) {
		nameLabel.setText("Hello: " + username);
	}
	
	@FXML
	public void displayMessage(ActionEvent e) {
		textoChat.setWrapText(false);
		textoChat.setEditable(false);
		
		textoChat.appendText("Teste\n");
		System.out.println("displayMessage");
		
	}
	
}
