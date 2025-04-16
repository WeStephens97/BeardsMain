import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class TheForest extends Application
{
   public void start(Stage stage) throws IOException
   {
      AnchorPane root = FXMLLoader.load(getClass().getResource("MainMenuFXML.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("The Forest");
      stage.show();
   }
}