/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.vm.entity.Item;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author master
 */
public class SecondFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private MainMenuFormController menuController;
    @FXML
    private VBox root;
    @FXML
    private Label NamaImage;
    @FXML
    private Label Harga;
    @FXML
    private Button ButtonBayar;
    @FXML
    private TextField TxtNominal;

    @FXML
    private ImageView Imagessss;
    private ObservableList<Item> items;

    private Item selectedItem;

    private Image image;

    public void setMenuController(MainMenuFormController menuController) {
        this.menuController = menuController;
//        selectedItem = this.menuController.getSelectedItem();
//        Harga.setText(String.valueOf(selectedItem.getHarga()));
//        image = new Image(selectedItem.getGambar());
//        Imagessss.setImage(image);

//        TxtNominal.setText(String.valueOf(mainController.getSelectItem().getHarga()));
//        image1 = new Image(String.valueOf(mainController.getSelectItem().getGambar()));
//        Imagessss.setImage(image1);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void closeClick(MouseEvent event) {
        selectedItem = null;
        ((Stage) root.getScene().getWindow()).hide();
    }

}
