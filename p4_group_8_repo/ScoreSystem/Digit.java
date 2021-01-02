package p4_group_8_repo.ScoreSystem;
import javafx.scene.image.Image;
import p4_group_8_repo.Obstacles.Actor;

// TODO: Auto-generated Javadoc
/**
 * The Class Digit.
 * 
 * Rpresents the score system
 */
public class Digit extends Actor{
	
	/** The dim. */
	int dim;
	
	/** The im 1. */
	Image im1;
	
	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Instantiates a new digit.
	 *
	 * @param n the n
	 * @param dim the dim
	 * @param x the x
	 * @param y the y
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/resources/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
