package com.rashidmayes.clairvoyance;

import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectController {
    @FXML private TextField host;
    @FXML private TextField port;
    @FXML private TextField username;
    @FXML private TextField password;
    
    @FXML protected void handleConnectAction(ActionEvent event) {
            	
    	try {
        	String user = username.getText();
        	String pass = password.getText();
        	int p = Integer.parseInt(port.getText());
        	String h = host.getText();
        	
        	App.setConnectionInfo(h, p, user, pass);
        	App.getClient();
        	
			Parent root = FXMLLoader.load(App.class.getResource("browser.fxml"));
	        Scene scene = new Scene(root);
	        
	        Stage stage = (Stage)(host.getScene().getWindow());
	        stage.setScene(scene);
	        //stage.centerOnScreen();
    	} catch (Exception e) {
    		App.APP_LOGGER.log(Level.SEVERE, e.getMessage(), e);
			Alert alert = new Alert(AlertType.ERROR, String.format("Error connecting: %s", e.getMessage()));
			alert.showAndWait().ifPresent(response -> {
			     if (response == ButtonType.OK) {
			         
			     }
			 });
    	}
    }
}