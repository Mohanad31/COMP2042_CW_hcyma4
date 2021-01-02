package p4_group_8_repo.Obstacles;

import javafx.scene.image.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class Obstacle.
 * 
 * General class that defines the behavior of obstacles on the screen
 */
public class Obstacle extends Actor {
	
	
	private int speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/**
	 * Instantiates a new obstacle.
	 *
	 * @param imageLink the image link
	 * @param xpos the x position
	 * @param ypos the y position
	 * @param s the speed
	 * @param w the width
	 * @param h the height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
