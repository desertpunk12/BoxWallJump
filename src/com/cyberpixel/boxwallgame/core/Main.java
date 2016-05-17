package com.cyberpixel.boxwallgame.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cyberpixel.boxwallgame.core.states.GameState;
import com.cyberpixel.boxwallgame.core.states.GameStateManager;

public class Main extends ApplicationAdapter {

	public final String TITLE = "Box Wall Jump";
	public final int WIDTH = 360;
	public final int HEIGHT = 640;
	private final boolean showTitleFPS = true;

	private SpriteBatch sb;
	private GameStateManager gsm;

	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new GameState(gsm));
	}

	@Override
	public void render () {
		if(showTitleFPS) Gdx.graphics.setTitle(TITLE+", FPS:"+Gdx.graphics.getFramesPerSecond());

		gsm.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		gsm.render(sb);
		sb.end();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
