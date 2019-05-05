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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class UpdateFormViewController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private TextField txtidField;
    @FXML
    private TextField txtRestock;
    @FXML
    private Button applyBtn;
    private AdminLoginController mainController;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMainController(AdminLoginController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void RestockingAction(ActionEvent event) {

    }

}
