import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {

	public final String TITLE = "Box Wall Jump";
	public final int WIDTH = 360;
	public final int HEIGHT = 640;

	SpriteBatch sb;


	@Override
	public void create () {
		sb = new SpriteBatch();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		sb.begin();
//
//		sb.end();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
