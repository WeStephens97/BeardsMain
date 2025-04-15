package JavaGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class GameController {

    @FXML
    private Line doorLine1;

    @FXML
    private Line doorLine2;

    @FXML
    private Line doorLine3;

    @FXML
    private Button testDoor;

    @FXML
    private TextArea textArea;

    @FXML
    private Polygon woodenDoor;

    @FXML
    void showDoor(ActionEvent event) 
    {
      woodenDoor.setVisible(true);
      doorLine1.setVisible(true);
      doorLine2.setVisible(true);
      doorLine3.setVisible(true);
    }

}
