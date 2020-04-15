package kg.megacom.okhttptest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/layout/lotHttpRequest.fxml"));
        primaryStage.setTitle("Lot management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

/*
public class Main {

    public static void main(String[] args) {
        try {
         //   OkhttpHelper.getInstance().get();
            OkhttpHelper.getInstance().post();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
