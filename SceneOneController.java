import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.sql.SQLException;
import java.util.ArrayList;

public class SceneOneController
{
    Map map = new Map();
    AllowedWords allowedWords = new AllowedWords();
    ArrayList<String> directions = allowedWords.getList();
    
    @FXML
    private TextField textField;
    
    @FXML
    private TextArea textArea;

    @FXML
    void queryDatabase(ActionEvent event) throws IOException //Checks database for the entered word
    {  
      String textString = textField.getText();   
      if(directions.contains(textString) == false) //Verifies if the word is a valid direction to go
         {
            textArea.setText(String.format(textArea.getText() + "\nYou entered %s, please try again.", textField.getText()));
         }
      else
         {
            try
            {
               String place = map.queryDatabase(map.getLevel(), textString);
               textArea.setText(place);
               textField.setText("");
               if(place.equals("Win"))
               {
               //Occurs in a win
                  FXMLLoader loader = new FXMLLoader();
                  loader.setLocation(getClass().getResource("TheGoodEndingFXML.fxml"));
                  Parent parent = loader.load();
                  Scene scene = new Scene(parent);
                  Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                  window.setScene(scene);
                  window.show();
               }
               if(place.equals("Lose"))
               {
               //Occurs in a loss
                  FXMLLoader loader = new FXMLLoader();
                  loader.setLocation(getClass().getResource("YouLostFXML.fxml"));
                  Parent parent = loader.load();
                  Scene scene = new Scene(parent);
                  Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                  window.setScene(scene);
                  window.show();
               }
   
            }
            catch(SQLException e)
            {
               System.out.printf("SQL ERROR: %s%n", e.getMessage());
            }
         }
    }

}
