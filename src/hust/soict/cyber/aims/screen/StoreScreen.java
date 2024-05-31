//package hust.soict.cyber.aims.screen;
//
//import hust.soict.cyber.aims.cart.Cart;
//import hust.soict.cyber.aims.media.Media;
//import hust.soict.cyber.aims.store.Store;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//import java.util.ArrayList;
//
//public class StoreScreen extends Application {
//    private Store store;
//    private Cart cart;
//
//    @Override
//    public void start(Stage primaryStage) {
//        store = new Store();
//        cart = new Cart();
//
//        BorderPane root = new BorderPane();
//        root.setTop(createMenuBar());
//        root.setCenter(createCenter());
//        root.setPadding(new Insets(10));
//
//        primaryStage.setTitle("Store");
//        primaryStage.setScene(new Scene(root, 1024, 768));
//        primaryStage.show();
//    }
//
//    private MenuBar createMenuBar() {
//        Menu optionsMenu = new Menu("Options");
//        Menu updateStoreMenu = new Menu("Update Store");
//
//        MenuItem addBookItem = new MenuItem("Add Book");
//        MenuItem addCDItem = new MenuItem("Add CD");
//        MenuItem addDVDItem = new MenuItem("Add DVD");
//
//        addBookItem.setOnAction(e -> {
//            // AddBookToStoreScreen logic
//            System.out.println("Add Book action");
//        });
//
//        addCDItem.setOnAction(e -> {
//            // AddCompactDiscToStoreScreen logic
//            System.out.println("Add CD action");
//        });
//
//        addDVDItem.setOnAction(e -> {
//            // AddDigitalVideoDiscToStoreScreen logic
//            System.out.println("Add DVD action");
//        });
//
//        updateStoreMenu.getItems().addAll(addBookItem, addCDItem, addDVDItem);
//
//        MenuItem viewStoreItem = new MenuItem("View store");
//        viewStoreItem.setOnAction(e -> {
//            // View store logic
//            System.out.println("View store action");
//        });
//
//        MenuItem viewCartItem = new MenuItem("View cart");
//        viewCartItem.setOnAction(e -> {
//            // Open CartScreen logic
//            new CartScreen(cart).show();
//            System.out.println("View cart action");
//        });
//
//        optionsMenu.getItems().addAll(updateStoreMenu, viewStoreItem, viewCartItem);
//
//        MenuBar menuBar = new MenuBar();
//        menuBar.getMenus().add(optionsMenu);
//
//        return menuBar;
//    }
//
//    private GridPane createCenter() {
//        GridPane center = new GridPane();
//        center.setPadding(new Insets(10));
//        center.setHgap(10);
//        center.setVgap(10);
//
//        ArrayList<Media> mediaInStore = (ArrayList<Media>) store.getItemsInStore();
//        for (int i = 0; i < mediaInStore.size() && i < 9; i++) {
//            MediaStore cell = new MediaStore(mediaInStore.get(i));
//            center.add(cell, i % 3, i / 3);
//        }
//
//        return center;
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
