/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.vm.entity.Item;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.beans.binding.Bindings.or;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class SecondFormViewController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private ImageView imageView;
    @FXML
    private Label namaLabel;
    @FXML
    private Label hargaLabel;
    @FXML
    private TextField txtNominal;

    private MainMenuFormController mainController;

    private Image image;
    private int hargabeverage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closeClick(MouseEvent event) {
        this.mainController.setSelectedItem(null);
        ((Stage) root.getScene().getWindow()).close();
    }

    public void setMenuController(MainMenuFormController mainController) {
        this.mainController = mainController;
        namaLabel.setText(this.mainController.getSelectedItem().getNama());
        image = new Image(this.mainController.getSelectedItem().getGambar());
        imageView.setImage(image);

        hargaLabel.setText(String.valueOf(this.mainController.getSelectedItem().
                getHarga()));

        hargabeverage = this.mainController.getSelectedItem().
                getHarga();
//        Harga.setText(String.valueOf(selectedItem.getHarga()));
//        image = new Image(selectedItem.getGambar());
//        Imagessss.setImage(image);

//        TxtNominal.setText(String.valueOf(mainController.getSelectItem().getHarga()));
//        image1 = new Image(String.valueOf(mainController.getSelectItem().getGambar()));
//        Imagessss.setImage(image1);
    }

    @FXML
    private void bayarClick(ActionEvent event) {
        if (hargabeverage > Integer.parseInt(txtNominal.getText())) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setAlertType(Alert.AlertType.WARNING);
            a.setTitle("Pemberitahuan");
            a.setHeaderText("Results:");
            a.setContentText("Uang yang anda masukan tidak cukup! ");
            a.show();

        } else if (Integer.parseInt(txtNominal.getText()) == hargabeverage) {

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setAlertType(Alert.AlertType.CONFIRMATION);
            a.setTitle("Pemberitahuan");
            a.setHeaderText("Results:");
            a.setContentText(
                    "Transaksi Berhasil");
            a.show();

        } else if (Integer.parseInt(
                txtNominal.getText())
                != 5000 || Integer.parseInt(txtNominal.getText()) != 10000
                || Integer.parseInt(txtNominal.getText())
                != 20000 || Integer.parseInt(txtNominal.getText()) != 50000
                || Integer.parseInt(
                        txtNominal.getText()) != 100000) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setAlertType(Alert.AlertType.WARNING);
            a.setTitle("Pemberitahuan");
            a.setHeaderText("Results:");
            a.setContentText(
                    "Uang yang anda masukan harus dalam pecahan 5000, 10000, 20000, 50000 dan 100000 an ");
            a.show();

        } else {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setAlertType(Alert.AlertType.CONFIRMATION);
            a.setTitle("Pemberitahuan");
            a.setHeaderText("Results:");
            a.setContentText(
                    "Transaksi Berhasil");
            a.show();

        }
    }

}
