package p4_group_8_repo.Stage;

import javafx.scene.image.Image;
import p4_group_8_repo.Obstacles.Actor;

// TODO: Auto-generated Javadoc
/**
 * The Class BackgroundImage.
 * 
 * Object for the background image 
 */
public class BackgroundImage extends Actor{


	@Override
	public void act(long now) {
		
		
	}
	
	/**
	 * Instantiates a new background image.
	 *
	 * @param imageLink the image link
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
