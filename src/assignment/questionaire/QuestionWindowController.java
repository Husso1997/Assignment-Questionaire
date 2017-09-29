/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.questionaire;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Hussain
 */
public class QuestionWindowController implements Initializable 
{
    
    /**
     * Initializes the controller class.
     */
    
    private int score;
    private String scoreAsString;
    
      
    
    
    @FXML 
    Label lblName;
    @FXML
    public ToggleGroup mathGroup;
    @FXML
    public ToggleGroup softwareGroup;
    @FXML
    public ToggleGroup teachersGroup;
    @FXML
    public ToggleGroup goodGroup;
    @FXML
    public ToggleGroup classmatesGroup;
    @FXML
    public ToggleGroup niceGroup;
    @FXML
    public ToggleGroup somethingGroup;
    @FXML
    public ToggleGroup forcedGroup;
    @FXML
    private Button calculateButton;
    @FXML
    public Label lblScoreCount;
    
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    // Takes the name from MainWindow and puts it into the label.
    public void changeName(String name)
    
    {
        lblName.setText(name);
    }
         // Calculates the score  
       @FXML
       public void calculateScore(ActionEvent event)
       {
           score = 0;
           ToggleGroup[] groups =   {mathGroup, 
                                    forcedGroup, 
                                    classmatesGroup, 
                                    goodGroup, 
                                    niceGroup,
                                    softwareGroup,
                                    somethingGroup, 
                                    teachersGroup};
           for(int i = 0;i < groups.length; i++){
           RadioButton rb = (RadioButton)groups[i].getSelectedToggle();
           if(rb != null)
           {
               getPoints(rb.getText());
           }
           }
       }
       // Checks if the answer is Agree or Disagree.
       public void getPoints(String answers)
       {
           if("Agree".equals(answers))
               ++score;
           else if("Disagree".equals(answers))
           {
                --score;
           }
           String scoreAsString = String.valueOf(score);
           lblScoreCount.setText(scoreAsString);
       }

}
