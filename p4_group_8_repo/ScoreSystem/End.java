package p4_group_8_repo.ScoreSystem;
import javafx.scene.image.Image;
import p4_group_8_repo.Obstacles.Actor;

// TODO: Auto-generated Javadoc
/**
 * The Class End.
 * 
 * Represents the end of each round by showing a frog in each end slot that the player reaches
 */
public class End extends Actor{
	
	boolean activated = false;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method 
	}
	
	/**
	 * Instantiates a new end.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/resources/End.png", 60, 60, true, true));
	}
	
	/**
	 * Sets the end.
	 */
	public void setEnd() {
		setImage(new Image("file:src/resources/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	/**
	 * Checks if is activated.
	 *
	 * @return true, if is activated
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
