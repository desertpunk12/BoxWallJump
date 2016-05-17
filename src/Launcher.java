import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		Main m = new Main();
		cfg.title = m.TITLE;
		cfg.width = m.WIDTH;
		cfg.height = m.HEIGHT;

		new LwjglApplication(new Main(), cfg);
	}
}
