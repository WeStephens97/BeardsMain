import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Node;

public class SceneTwoFXML {

    @FXML
    private Button sceneTwoLeft;

    @FXML
    private Button sceneTwoRight;

    @FXML
    void handleSceneTwoLeft(ActionEvent event) throws IOException
    {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TheGoodEndingFXML.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void handleSceneTwoRight(ActionEvent event) throws IOException
    {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("YouLostFXML.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
