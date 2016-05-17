package com.cyberpixel.boxwallgame.core.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    protected GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void render(SpriteBatch sb);
    public abstract void update(float dt);
    public abstract void handleInput(float dt);
    public abstract void resize(int width, int height);
    public abstract void dispose();

}
