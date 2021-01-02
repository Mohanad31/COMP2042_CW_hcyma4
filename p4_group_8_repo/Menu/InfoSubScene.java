package p4_group_8_repo.Menu;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


/**
 * The Class InfoSubScene.
 * 
 * @author Mohanad
 *@version Java 15 and JavaFX 15.0.1
 *Creates the subscene that shows the game's information on how to play 
 */
public class InfoSubScene extends SubScene {
	
	
	

	/**
	 * Instantiates a new subscene
	 */
	public InfoSubScene() {
		super(new AnchorPane(), 400, 400);
		 
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setStyle("-fx-background-color: darkturquoise");
		Text infotext = new Text();
		infotext.setText("\n Welcome to Frogger! \n How to play: \n Press W to move forward \n Press S to move backward \n Press A to go left \n Press D to go right \n\n The goal is to reach the end of \n each level without getting hit or drowning \n Avoid cars and make sure to be careful \n of the turtles! Only stand on them when they \n are above water");
		infotext.setFill(Color.DARKCYAN);
		infotext.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		


		root2.getChildren().add(infotext);
		root2.setOnMouseClicked(event -> {
			menuTransition(600);
		});
	}

	/**
	 * Menu transition.
	 *
	 * @param y represents how much many coordinates will the subscene move
	 */
	public void menuTransition(int y) {
		TranslateTransition trans = new TranslateTransition(); 
		trans.setDuration(Duration.seconds(0.2));
		trans.setNode(this);
		trans.setToY(y);
		
		trans.play();
	}
}
