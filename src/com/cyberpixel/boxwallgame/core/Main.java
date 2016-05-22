package com.cyberpixel.boxwallgame.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cyberpixel.boxwallgame.core.states.GameStateManager;
import com.cyberpixel.boxwallgame.core.states.MenuState;

public class Main extends ApplicationAdapter {

	public final String TITLE = "Box Wall Jump";
	public final int WIDTH = 360;
	public final int HEIGHT = 640;
	private final boolean showTitleFPS = true;

	private SpriteBatch sb;
	private GameStateManager gsm;

	private float bgColor = 24f/255f;

    private float timer = 0;

	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new GameStateManager();

		gsm.push(new MenuState(gsm));
	}



	@Override
	public void render () {
        float dt = Gdx.graphics.getDeltaTime();
        if((timer+=dt)>1) {
            if (showTitleFPS)
                Gdx.graphics.setTitle(TITLE + "," + bgColor + ", FPS:" + Gdx.graphics.getFramesPerSecond());
            timer-=1;
        }
		gsm.update(dt);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(bgColor, bgColor, bgColor, 1);

		sb.begin();
		gsm.render(sb);
		sb.end();
	}

    @Override
    public void resize(int width, int height) {
        gsm.resize(width,height);
    }

    @Override
	public void dispose() {
		super.dispose();
        sb.dispose();
        gsm.dispose();
	}

}
