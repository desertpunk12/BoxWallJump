package com.cyberpixel.boxwallgame.core.states;

import com.badlogic.gdx.Gdx;
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

    public void dispose(){
        for(State state: states)
            state.dispose();
    }



    public void push(State state){
        states.add(state);
        System.out.println("Pushed State: "+state.getName());
        resize();
    }

    public void pop(){
        states.peek().dispose();
        System.out.println("Popped State: "+ states.peek().getName());
        states.pop();
        states.peek();

        resize();
    }

    private void resize(){
        resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    public void set(State state){
        pop();
        push(state);
    }



}
