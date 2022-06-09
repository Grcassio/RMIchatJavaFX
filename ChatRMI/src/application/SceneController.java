package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.Node;

public class SceneController {

	@FXML
	TextField nameTextField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void login(ActionEvent event) throws IOException{
		
		String username = nameTextField.getText();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
		root = loader.load();
		
		Scene2Controller scene2Controller = loader.getController();

    	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}