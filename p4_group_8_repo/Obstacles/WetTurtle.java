package p4_group_8_repo.Obstacles;

import javafx.scene.image.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class WetTurtle.
 * Controls the behavior of turles above water
 */
public class WetTurtle extends Actor{
	
	/** The turtle 1. */
	Image turtle1;
	
	/** The turtle 2. */
	Image turtle2;
	
	/** The turtle 3. */
	Image turtle3;
	
	/** The turtle 4. */
	Image turtle4;
	
	/** The speed. */
	private int speed;
	
	/** The i. */
	int i = 1;
	
	/** The bool. */
	boolean bool = true;
	
	/** The sunk. */
	boolean sunk = false;
	
	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	/**
	 * Instantiates a new wet sturtle.
	 *
	 * @param xpos the x position 
	 * @param ypos the y position
	 * @param s the speed
	 * @param w the width
	 * @param h the height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/resources/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	/**
	 * Checks if is sunk.
	 *
	 * @return true, if is sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
}
