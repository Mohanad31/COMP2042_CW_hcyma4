package p4_group_8_repo;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application {
	private GMenu gameMenu;
	@Override
	public void start(Stage mainStage) throws Exception {
		MyStage background = new MyStage();
		Pane root = new Pane();
		root.setPrefSize(600, 800);
		InputStream is = Files.newInputStream(Paths.get("src/p4_group_8_repo/menu.png"));
		Image bg = new Image(is);
		is.close();
		
		ImageView iv = new ImageView(bg);
		iv.setFitWidth(600);
		iv.setFitHeight(800);
		
		gameMenu = new GMenu(mainStage,background);
		
		root.getChildren().addAll(iv, gameMenu);
		
		Scene scene = new Scene(root);
		
		mainStage.setScene(scene);

		background.playMusic();
		mainStage.show();
	} 	
	private static class Button extends StackPane {
		
		private Text text;
		
		public Button(String name) {
			text = new Text(name);
			text.getFont();
			text.setFont(Font.font(20));
			text.setFill(Color.GREENYELLOW);
			
			
			 Rectangle textbg = new Rectangle(250,30);
			 textbg.setOpacity(0.6);
			 textbg.setFill(Color.ALICEBLUE);
			 
			 setAlignment(Pos.CENTER);
			 setRotate(-0.5);
			 getChildren().addAll(textbg, text);
			 
		}
	}
	
	private class GMenu extends Parent {
		public GMenu(Stage mainStage, MyStage background) {
			VBox menu1 = new VBox(10);
			menu1.setTranslateX(170);
			menu1.setTranslateY(300);
			
			Button startGame = new Button("Start Game");
			startGame.setOnMouseClicked(event -> {
				Main newgame = new Main();
				try {
					background.stopMusic();
					mainStage.close();
					newgame.start(mainStage);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			Button GameInfo = new Button("Info");

			menu1.getChildren().addAll(startGame, GameInfo);
			
			Rectangle bg = new Rectangle(600, 800);
			//bg.setFill(Color.AQUAMARINE);
			bg.setOpacity(0);
			
			getChildren().addAll(bg, menu1);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


} 
