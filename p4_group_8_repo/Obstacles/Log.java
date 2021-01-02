package p4_group_8_repo.Obstacles;

import javafx.scene.image.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class Log.
 * 
 * Responsible for creating and moving logs 
 */
public class Log extends Actor {

	/** The speed. */
	private double speed;
	
	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/**
	 * Instantiates a new log.
	 *
	 * @param imageLink the image link
	 * @param size the size of the log 
	 * @param xpos the desired x position
	 * @param ypos the desired y position
	 * @param s speed of the log
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * Gets the left.
	 *
	 * @return true or false depending on if speed is less than 0 
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
