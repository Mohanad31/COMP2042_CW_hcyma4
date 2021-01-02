package p4_group_8_repo.Stage;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.Obstacles.Actor;


// TODO: Auto-generated Javadoc
/**
 * The Class World.
 * 
 * The main scene with all the different elements in it 
 */
public abstract class World extends Pane {
    
    /** The timer. */
    private AnimationTimer timer;
    
    /**
     * Instantiates a new world.
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * Creates the timer.
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * Start.
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * Stop.
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * Adds the.
     *
     * @param actor the actor
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Removes the.
     *
     * @param actor the actor
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Gets the objects.
     *
     * @param <A> the generic type
     * @param cls the cls
     * @return the objects
     */
    @SuppressWarnings("unchecked")
	public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * Act.
     *
     * @param now the now
     */
    public abstract void act(long now);
}
