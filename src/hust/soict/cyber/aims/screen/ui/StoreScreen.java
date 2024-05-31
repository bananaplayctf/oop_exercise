package hust.soict.cyber.aims.screen.ui;

import hust.soict.cyber.aims.screen.controller.StoreScreenController;
import hust.soict.cyber.aims.cart.Cart;
import hust.soict.cyber.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class StoreScreen extends JFrame {
    private Store store;

    public StoreScreen(Store store) {
        super();
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Store");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cyber/aims/screen/fxml/store.fxml"));
                loader.setController(new StoreScreenController(store, new Cart()));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

