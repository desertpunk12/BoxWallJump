package com.cyberpixel.boxwallgame.core.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

public class MenuState extends State {

    private final String NAME = "Menu";

    public MenuState(GameStateManager gsm) {
        super(gsm);


    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void handleInput(float dt) {
        if(Gdx.input.isTouched()){
            gsm.push(new GameState(gsm));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public String getName(){
        return NAME;
    }
}
