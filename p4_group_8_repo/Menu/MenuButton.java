package p4_group_8_repo.Menu;

import javafx.scene.control.Button;
import javafx.scene.text.Font;


/**
 * The Class MenuButton.
 * 
 * Sets a unified format for the main menu buttons
 *@author Mohanad
 *@version Java 15 and JavaFX 15.0.1
 */
public class MenuButton extends Button {
	
	/**
	 * Instantiates a new menu button.
	 *
	 * @param text The text that would be displayed on the button
	 */
	public MenuButton(String text) {
		 setText(text);
		 setFont(Font.font("Verdana", 23));
		 setPrefWidth(200);
		 setPrefHeight(50);
	}
	
	
}
