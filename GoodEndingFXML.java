import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.scene.control.Button;

public class GoodEndingFXML {

    @FXML
    private Button exitButton;

    @FXML
    private Button mainmenuButtton;

    @FXML
    void handleExitButton(ActionEvent event)
    {
         System.exit(0);
    }

    @FXML
    void handleMainMenuButton(ActionEvent event) throws IOException 
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainMenuFXML.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
