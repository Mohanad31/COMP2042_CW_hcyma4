package p4_group_8_repo.Menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;


/**
 * The Class ViewMenu.
 * 
 * @author Mohanad
 * @version Java 15 and JavaFX 15.0.1
 * 
 * This class is responsible for the main menu screen. It creates an anchor pane for all the buttons and assigns events for each button.
 */
public class ViewMenu extends Application {
	
	
	private AnchorPane aPane;
	
	
	private Scene mainMenu;
	
	/** The main stage. */
	private Stage mainStage;
	
	
	private InfoSubScene info;
	
	/**  Makes a list with all the buttons in it */
	List<MenuButton> buttons;
	
	/**
	 * Instantiates a new view menu.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ViewMenu() throws IOException {
		buttons = new ArrayList<>();
		aPane = new AnchorPane();
		mainMenu = new Scene(aPane, 600, 800);
		mainStage = new Stage();
		mainStage.setScene(mainMenu);
		createMenuButtons();
		createBackground();
		createSubScene();
		

		aPane.getChildren().add(info);
	}
	
	/**
	 * Creates the subscene with the game information on it while also hiding it away from the main screen in order to create an animation effect
	 */
	private void createSubScene() {
		info = new InfoSubScene();
		info.setLayoutX(100);
		info.setLayoutY(800);
	}
	
	/**
	 * Gets the primary stage.
	 *
	 * @return the primary stage
	 */
	public Stage getPrimaryStage() {
		return mainStage;
	}
	
	/**
	 * Creates the menu.
	 *
	 * @param button Anchors the buttons into the anchor pane.
	 */
	private void createMenu(MenuButton button) {
		button.setLayoutX(200);
		button.setLayoutY(300 + buttons.size() * 100);
		buttons.add(button);
		aPane.getChildren().add(button);
		
	}
	
	/**
	 * Creates the two menu buttons.
	 */
	private void createMenuButtons() {
		createStartButton();
		createInfoButton();
	}
	
	/**
	 * Creates the start button and assigns an event to it so that it opens the main game when clicked.
	 */
	private void createStartButton() { 
		MenuButton startButton = new MenuButton("Start Game"); 
		createMenu(startButton);
		
		startButton.setOnMouseClicked(event -> {
			
				Main newgame = new Main();
				try {
					mainStage.close();
					newgame.start(mainStage);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
				); 
		}


	
	/**
	 * Creates the info button and assigns a transitioning animation as an event to the button if clicked
	 */
	private void createInfoButton() { 
		MenuButton infoButton = new MenuButton("Game Info"); 
		createMenu(infoButton);
		
		infoButton.setOnMouseClicked(event -> {
			info.menuTransition(-600);
		});
	}
	
	/**
	 *
	 *
	 * @param primaryStage the primary stage
	 * @throws Exception the exception
	 */
	public void start(Stage primaryStage) throws Exception {
	ViewMenu menu = new ViewMenu();
	primaryStage = menu.getPrimaryStage();
	primaryStage.show();
	
	
	}
	
	
	/**
	 * Creates the background by assigning a background image to it 
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void createBackground() throws IOException {
		Image backgroundImage = new Image(Files.newInputStream(Paths.get("src/resources/menu.png")), 600,800, false, true);
		 BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		 aPane.setBackground(new Background(background));
	}
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}


