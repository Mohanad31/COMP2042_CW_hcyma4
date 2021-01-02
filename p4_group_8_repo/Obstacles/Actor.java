package p4_group_8_repo.Obstacles;
import java.util.ArrayList;

import javafx.scene.image.ImageView;
import p4_group_8_repo.Stage.World;


// TODO: Auto-generated Javadoc
/**
 * The Class Actor.
 * 
 * Represents how each element on screen interacts with each other. In other words, it controls collision logic.
 */
public abstract class Actor extends ImageView{

    /**
     * Changes the location of the element.
     *
     * @param dx a double that represents how many points to translate the element along the X-axis
     * @param dy a double that represents how many points to translate the element along the Y-axis
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

/**
 * Converts the Parent object to a World object and returns it 
 * @return World
 */
    public World getWorld() {
        return (World) getParent();
    }

/**
 * Gets width and returns it
 * @return width 
 */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Gets height and returns it
     * @return height 
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Gets the intersecting objects.
     *
     * @param <A> the generic type
     * @param cls the cls
     * @return the intersecting objects
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
   

    /**
     * Gets one intersecting object.
     *
     * @param <A> the generic type
     * @param cls the cls
     * @return the one intersecting object
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

/**
 *  abstract Act method
 * 
 * @param now a long
 */
    public abstract void act(long now);

}
