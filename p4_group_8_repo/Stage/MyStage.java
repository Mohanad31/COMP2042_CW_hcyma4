package p4_group_8_repo.Stage;
import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class MyStage.
 * 
 * Plays the music of the stage
 */
public class MyStage extends World{
	
	/** The media player. */
	MediaPlayer mediaPlayer;
	
	/**
	 * Act.
	 *
	 * @param now the now
	 */
	@Override
	public void act(long now) {
		
	}
	

	
	/**
	 * Play music.
	 */
	public void playMusic() {
		String musicFile = "src/resources/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * Stop music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
