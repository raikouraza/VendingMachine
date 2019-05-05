package com.vm.controller;

import com.vm.MainApp;

import com.vm.dao.ItemDaoImpl;
import com.vm.dao.PenjualanDaoImpl;

import com.vm.entity.Item;
import com.vm.entity.Penjualan;
import com.vm.entity.PenjualanHasItem;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class MainMenuFormController implements Initializable {

    @FXML
    private VBox root;

    private ItemDaoImpl itemDaoImpl;

    private ObservableList<Item> items;

    private Stage secondStage;

    private Item selectedItem;
    @FXML
    private ImageView image1;
    @FXML
    private Label labelimage1;
    @FXML
    private ImageView image2;
    @FXML
    private Label labelimage2;
    @FXML
    private ImageView image3;
    @FXML
    private Label labelimage3;
    @FXML
    private ImageView image4;
    @FXML
    private Label labelimage4;
    @FXML
    private ImageView image5;
    @FXML
    private Label labelimage5;
    @FXML
    private ImageView image6;
    @FXML
    private Label labelimage6;
    @FXML
    private ImageView image7;
    @FXML
    private Label labelimage7;
    @FXML
    private ImageView image8;
    @FXML
    private Label labelimage8;
    @FXML
    private ImageView image9;
    @FXML
    private Label labelimage9;

    private Stage adminStage;

    private PenjualanDaoImpl penjualanDao;
    private ObservableList<Penjualan> penjualans;

    private PenjualanHasItem pHIDao;
    private ObservableList<PenjualanHasItem> pHIs;
    private PenjualanHasItem phi;
    @FXML
    private Tab alltab;

    public PenjualanHasItem getPhi() {
        return phi;
    }

    public PenjualanHasItem getpHIDao() {
        return pHIDao;
    }

    public ObservableList<PenjualanHasItem> getpHIs() {
        return pHIs;
    }

    public PenjualanDaoImpl getPenjualanDao() {
        if (penjualanDao == null) {
            penjualanDao = new PenjualanDaoImpl();
        }
        return penjualanDao;
    }

    public ObservableList<Item> getItems() {
        return items;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        this.initLanguage(rb);
        Image i1 = new Image("com/vm/image/RoyCola.png");
        image1.setImage(i1);
        labelimage1.setText(String.valueOf(10000));

        Image i2 = new Image("com/vm/image/milo.jpg");
        image2.setImage(i2);
        labelimage2.setText(String.valueOf(15000));

        Image i3 = new Image("com/vm/image/pocari.jpg");
        image3.setImage(i3);
        labelimage3.setText(String.valueOf(15000));

        Image i4 = new Image("com/vm/image/pulpy.jpg");
        image4.setImage(i4);
        labelimage4.setText(String.valueOf(10000));

        Image i5 = new Image("com/vm/image/pucuk.png");
        image5.setImage(i5);
        labelimage5.setText(String.valueOf(10000));

        Image i6 = new Image("com/vm/image/kitkat.jpg");
        image6.setImage(i6);
        labelimage6.setText(String.valueOf(25000));

        Image i7 = new Image("com/vm/image/pocky.jpg");
        image7.setImage(i7);
        labelimage7.setText(String.valueOf(20000));

        Image i8 = new Image("com/vm/image/lays.jpg");
        image8.setImage(i8);
        labelimage8.setText(String.valueOf(30000));

        Image i9 = new Image("com/vm/image/toblerone.jpg");
        image9.setImage(i9);
        labelimage9.setText(String.valueOf(50000));

        itemDaoImpl = new ItemDaoImpl();
        items = FXCollections.observableArrayList();
        try {
            items.addAll(itemDaoImpl.getAllData());
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    private void initLanguage(ResourceBundle rb) {
//        alltab.setText(rb.getString("mainform.alltab"));
    }

    @FXML
    private void closeClick(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    private void item1Click(MouseEvent event) {

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 1) {
                selectedItem = items.get(i);
                break;
            }

        }

        System.out.println(items);

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initStyle(StageStyle.UNDECORATED);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    @FXML
    private void item2Click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 2) {
                selectedItem = items.get(i);
                break;
            }

        }

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
//        }
//        if (secondStage.isShowing() && !secondStage.isFocused()) {
//            secondStage.show();
//        } else {
//            secondStage.show();
//        }

    }

    public ObservableList<Penjualan> getPenjualans() {
        return penjualans;
    }

    @FXML
    private void item3click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 3) {
                selectedItem = items.get(i);
                break;
            }

        }

//        if (secondStage == null) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    @FXML
    private void item4click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 4) {
                selectedItem = items.get(i);
                break;
            }

        }

//        if (secondStage == null) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    @FXML
    private void item5click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 5) {
                selectedItem = items.get(i);
                break;
            }

        }

//        if (secondStage == null) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    @FXML
    private void item6click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 6) {
                selectedItem = items.get(i);
                break;
            }

        }

//        if (secondStage == null) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    @FXML
    private void item7click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 7) {
                selectedItem = items.get(i);
                break;
            }

        }

//        if (secondStage == null) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    @FXML
    private void item8click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 8) {
                selectedItem = items.get(i);
                break;
            }

        }

//        if (secondStage == null) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    @FXML
    private void item9click(MouseEvent event) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getIdItem() == 9) {
                selectedItem = items.get(i);
                break;
            }

        }

//        if (secondStage == null) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/SecondFormView.fxml"));
            VBox pane = loader.load();
            SecondFormViewController controller = loader.getController();
            controller.setMenuController(this);
            Scene scene = new Scene(pane);
            secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Toko KPC");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.initOwner(root.getScene().getWindow());

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        secondStage.show();
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public ItemDaoImpl getItemDaoImpl() {
        return itemDaoImpl;
    }

    @FXML
    private void gearClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/adminLogin.fxml"));
//            ResourceBundle bundle = ResourceBundle.getBundle(
//                    "com/vm/bundles/myBundle");
//            loader.setResources(bundle);
            VBox pane;

            pane = loader.load();

            AdminLoginController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            adminStage = new Stage();
            adminStage.setScene(scene);
            adminStage.setTitle("Toko KPC");
            adminStage.initModality(Modality.APPLICATION_MODAL);
            adminStage.initOwner(root.getScene().getWindow());
            adminStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
