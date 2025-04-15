package JavaGame;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class Main extends Application
{
   @Override
   public void start(Stage stage) throws IOException
   {
      Parent root = FXMLLoader.load(getClass().getResource("TitleController.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Title Pending");
      stage.setResizable(false);
      stage.show();
   }
}