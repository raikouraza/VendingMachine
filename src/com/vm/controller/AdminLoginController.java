/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.vm.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AdminLoginController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private Label adminloginlbl;
    @FXML
    private Label usernamelbl;
    @FXML
    private Label passwordlbl;
    @FXML
    private Button LoginBtn;
    private MainMenuFormController mainController;
    private Stage restockStage;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        this.initLanguage(rb);
    }

    public void setMainController(MainMenuFormController mainController) {
        this.mainController = mainController;
    }

    private void initLanguage(ResourceBundle rb) {
//        adminloginlbl.setText(rb.getString("adminform.adminloginlbl"));
//        usernamelbl.setText(rb.getString("adminform.usernamelbl"));
//        passwordlbl.setText(rb.getString("adminform.passwordlbl"));
//        LoginBtn.setText(rb.getString("adminform.LoginBtn"));
    }

    @FXML
    private void LoginAction(ActionEvent event) {
        if (txtUsername.getText() != "admin" && txtPassword.getText() != "admin") {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/updateFormView.fxml"));
                VBox pane;
                pane = loader.load();
                UpdateFormViewController controller = loader.getController();
                controller.setMainController(this);
                Scene scene = new Scene(pane);
                restockStage = new Stage();
                restockStage.setScene(scene);
                restockStage.setTitle("Toko KPC");
                restockStage.initModality(Modality.APPLICATION_MODAL);
                restockStage.initOwner(root.getScene().getWindow());
                restockStage.show();
            } catch (IOException ex) {
                Logger.getLogger(AdminLoginController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setTitle("Pemberitahuan");
            a.setHeaderText("Kesalahan Username atau Password");
            a.setContentText(
                    "Username atau Password yang anda masukkan salah");
            a.show();

        }

    }
}
