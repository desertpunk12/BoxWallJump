package com.cyberpixel.boxwallgame.core.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class GameStateManager {


    private Array<State> states;

    public GameStateManager(){
        states = new Array<>();
    }

    public void update(float dt){
        states.peek().handleInput(dt);
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

    public void resize(int width, int height){
        states.peek().resize(width, height);
    }



    public void push(State state){
        states.add(state);
    }

    public void pop(){
        states.peek().dispose();
        states.pop();
    }

    public void set(State state){
        pop();
        push(state);
    }



}
