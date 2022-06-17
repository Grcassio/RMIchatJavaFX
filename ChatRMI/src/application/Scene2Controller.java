package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.rmi.*;

public class Scene2Controller {

	@FXML
	Label nameLabel;
	
	@FXML
	TextArea textoChat  = new TextArea();
	
	@FXML
	TextField inputText;
	
	ChatClient chatClient;
	ChatServerIF chatServer;
	
	private String username;
	
	@FXML
	public void displayName(String username) {
		this.username = username;
		nameLabel.setText("Hello: " + username);
	}
	
	@FXML
	public void displayMessage(ActionEvent e) throws RemoteException {

		textoChat.setWrapText(true);
		textoChat.setEditable(false);
		String message = inputText.getText();
		String username = this.username;
				
		System.out.println("displayMessage");
		
		if(this.chatClient != null) {
			
			try {
				this.chatServer.broadcastMessage(username + ": " + message);
			} catch (Exception error) {
				error.printStackTrace();
			}
		}
		
	}
	
	public void displayMessageRetrieved(String message) throws RemoteException {

		textoChat.setWrapText(true);
		textoChat.setEditable(false);

		textoChat.appendText(message + "\n");
		//System.out.println("displayMessage");
					
	}
		
	
	public void startClient(String username) throws MalformedURLException, RemoteException, NotBoundException{
        String chatServerURL = "rmi://localhost/RMIChatServer";
        this.chatServer = (ChatServerIF) Naming.lookup(chatServerURL);
        this.chatClient = new ChatClient(username, chatServer, this);
        		
	}
	
	
}
