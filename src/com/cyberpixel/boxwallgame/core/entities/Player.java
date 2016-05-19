package com.cyberpixel.boxwallgame.core.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private float gravity;
    private boolean atLeft = true;

    private Rectangle rect;

    private Texture tex;

    private final int SCALE;

    public Player(int scale){
        this(0,0,scale);
    }

    public Player(float x, float y, int scale) {
        this(x,y,1,1,scale);
    }

    public Player(float x, float y, float w, float h, int scale) {
        this(x,y,w,h,1,scale);
    }

    public Player(float x, float y, float w, float h, float gravity, int scale) {
        rect = new Rectangle(x,y,w,h);
        this.gravity = gravity;
        this.tex = new Texture("box.png");
        this.SCALE = scale;
    }

    public void handleInput(){

    }

    public void update(){

    }

    public void render(){

    }

}
