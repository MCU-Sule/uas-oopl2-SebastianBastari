/**
 * Sebastian Giovanni Bastari 1972006
 */
package com.example.uaspbo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class loginController {
    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtId;

    @FXML
    private PasswordField txtPass;

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        if (txtId.getText().equals("1972006")&&txtPass.getText().equals("a123")){
            Stage new_stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main-view.fxml"));
            loader.setResources(ResourceBundle.getBundle("bundle"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            new_stage.setTitle("Login");
            new_stage.initModality(Modality.WINDOW_MODAL);
            new_stage.initOwner(txtPass.getScene().getWindow());
            new_stage.setScene(scene);
            new_stage.show();


        }
    }
}
