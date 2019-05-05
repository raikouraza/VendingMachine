/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.initLanguage(rb);
    }

    private void initLanguage(ResourceBundle rb) {
        adminloginlbl.setText(rb.getString("adminform.adminloginlbl"));
        usernamelbl.setText(rb.getString("adminform.usernamelbl"));
        passwordlbl.setText(rb.getString("adminform.passwordlbl"));
        LoginBtn.setText(rb.getString("adminform.LoginBtn"));
    }

    @FXML
    private void LoginAction(ActionEvent event) {
    }
}
