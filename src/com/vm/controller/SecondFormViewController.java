/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.controller;

import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import com.vm.dao.PenjualanDaoImpl;
import com.vm.entity.Item;
import com.vm.entity.Penjualan;
import com.vm.entity.PenjualanHasItem;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javafx.scene.control.Button;

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

    private PenjualanDaoImpl penjualanDao;
    private ObservableList<Penjualan> penjualans;

    private Penjualan penjualan;

    private Item tempItem;

    private Penjualan tempPenjualan;
    private Date date;

    private PenjualanHasItem pHI;
    @FXML
    private Button bayarbtn;

    private static int idPenjualan;

    /**
     * Initializes the controller class.
     *
     * @return
     */
    public PenjualanDaoImpl getPenjualanDao() {
        if (penjualanDao == null) {
            penjualanDao = new PenjualanDaoImpl();
        }
        return penjualanDao;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        initLanguage(rb);
    }

    private void initLanguage(ResourceBundle rb) {
        bayarbtn.setText(rb.getString("secondform.bayarbtn"));
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
    private void bayarClick(ActionEvent event) throws SQLException {

        //cek nominal uang
        if (Integer.parseInt(
                txtNominal.getText())
                == 5000 || Integer.parseInt(txtNominal.getText()) == 10000
                || Integer.parseInt(txtNominal.getText())
                == 20000 || Integer.parseInt(txtNominal.getText()) == 50000
                || Integer.parseInt(
                        txtNominal.getText()) == 100000) {

            //cek stock
            if (this.mainController.getSelectedItem().getStock() <= 0) {
                Alert ab = new Alert(Alert.AlertType.WARNING);
                ab.setAlertType(Alert.AlertType.WARNING);
                ab.setTitle("Pemberitahuan");
                ab.setHeaderText("Transaksi :");
                ab.setContentText(
                        "Stock Habis");
                ab.show();
            } else {

                //cek duit cukup
                if (hargabeverage > Integer.parseInt(txtNominal.getText())) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setTitle("Pemberitahuan");
                    a.setHeaderText("Results:");
                    a.setContentText(
                            "Uang yang anda masukan tidak cukup! Uang dikembalikan ");
                    a.show();

                } else {

//               penjualans = FXCollections.observableArrayList();
//               penjualans.addAll(getPenjualanDao().UpdateData(Penjualan.class.);
//               return students;
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setTitle("Pemberitahuan");
                    a.setHeaderText("Results:");
                    a.setContentText(
                            "Transaksi Berhasil, Kembalian : " + String.valueOf(
                                    0
                            )
                            + " lembar 50rb, " + String.valueOf(0)
                            + " lembar 20rb, " + String.valueOf(0)
                            + " lembar 10rb, " + String.valueOf(0)
                            + " lembar 5rb ");
                    a.show();
                    //Ngurangin Stock
                    tempItem = this.mainController.getSelectedItem();

                    int stock = this.mainController.getSelectedItem().getStock();

                    tempItem.setStock(
                            stock - 1);

                    System.out.println(tempItem.getStock());

                    this.mainController.getItemDaoImpl().UpdateData(
                            tempItem);
                    //
//                    penjualan = new Penjualan();
//                    long time = date.getTime();
//                    Timestamp ts = new Timestamp(time);
//                    penjualan.setTanggalPenjualan(ts);
//                    DateTimeFormatter f = DateTimeFormatter.ofPattern(
//                            "MMMM dd, yyyy");
//                    LocalDate localDate = LocalDate.from(f.parse(
//                            "January 13, 2012"));
//                    penjualan.setTanggalPenjualan();
//                    penjualan.setIdPenjualan(idPenjualan++);
//                    penjualan.setTotalSales(hargaLabel.getText());
//                    System.out.println(Calendar.getInstance());
//                    penjualan.setTanggalPenjualan(date.);
                    mainController.getPenjualanDao().AddData(penjualan);
                    mainController.getPenjualans().clear();
                    mainController.getPenjualans().addAll(mainController.
                            getPenjualanDao().getAllData());

                    //Nambah Penjualan By 1
//                int Quantity = this.mainController.getPhi().getQuantity();
//                pHI.setQuantity(Quantity + 1);
//                pHI.setHarga(tempItem.getHarga());
                    //Nambahin data Penjualan
//            Department department = new Department();
//            department.setCode(txtCode.getText().trim());
//            department.setName(txtName.getText().trim());
//            mainController.getDepartmentDao().addData(department);
//            mainController.getDepartments().clear();
//            mainController.getDepartments().addAll(mainController.getDepartmentDao().showAllData());
//            txtCode.clear();
//            txtName.clear();
//                    inventory = inventories.get(i);
                    //                this.mainController.getInventories()
                    //                this.mainController.getInventoryDao().UpdateData(
                    //                        this.mainController.getSelectedItem());
                    //
                    //                inventory.setIdInventory(mainController.getSelectedItem().
                    //                        getIdItem());
                    //                inventory.setStock(inventory.getStock() - 1);
                    //                mainController.getInventoryDao().UpdateData(inventory);
                    //                mainController.getInventories().clear();
                    //                mainController.getInventories().addAll(mainController.
                    //                        getInventoryDao().getAllData());
                }
            }

//                inventory.getIdInventory();
//                int number;
//                number = inventory.getStock() - 1;
//                inventory.setStock(number);
//                int bayaran;
//                bayaran = penjualan.getTotalSales() + hargabeverage;
//                penjualan.setTotalSales(bayaran);
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setAlertType(Alert.AlertType.WARNING);
            a.setTitle("Pemberitahuan");
            a.setHeaderText("Results:");
            a.setContentText(
                    "Uang yang anda masukan harus dalam pecahan 5000, 10000, 20000, 50000 dan 100000 an ");
            a.show();

        }
    }

//    public void Kembalian(int kembalian) {
//        int NilaiKembalian;
//        int c50 = 0;
//        int c20 = 0;
//        int c10 = 0;
//        int c5 = 0;
//        int NilaiSisa1 = 0;
//        int NilaiSisa2 = 0;
//        int NilaiSisa3 = 0;
//        NilaiKembalian
//                = Integer.valueOf(hargaLabel.getText())
//                - Integer.valueOf(txtNominal.getText());
//        if (NilaiKembalian > 50000) {
//            c50 = 1;
//            NilaiSisa1 = NilaiKembalian - 50000;
//
//        } else if (NilaiSisa1 > 40000) {
//            c20 = 2;
//            NilaiSisa2 = NilaiSisa1 - 40000;
//        } else if (NilaiSisa1 > 20000) {
//            c20 = 1;
//            NilaiSisa2 = NilaiSisa1 - 20000;
//        } else if (NilaiSisa2 > 10000) {
//            c10 = 1;
//            NilaiSisa3 = NilaiSisa2 - 10000;
//        } else if (NilaiSisa3 > 5000) {
//            c5 = 1;
//        }
//        System.out.println(String.valueOf(c50) + ' ' + String.
//                valueOf(c20) + ' ' + String.valueOf(c10) + ' '
//                + String.valueOf(c5));
//
//    }
}
