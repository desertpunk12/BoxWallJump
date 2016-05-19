package com.cyberpixel.boxwallgame.core.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class WallBlock {

    private final int SCALE;
    private float x,y,w,h;
    private int unitsHigh;
    private Rectangle rect;

    private Texture tex;



    public WallBlock(int scale){
        this(0,0,1);
    }

    public WallBlock(float y, float x,int scale) {
        this(x,y,1,1,scale);
    }

    public WallBlock(float x, float y, float w, float h,int scale) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.SCALE = scale;
    }

    private void update(){

    }

    private void render(SpriteBatch sb){
        sb.draw(tex,x,y,w*SCALE,h*SCALE);
    }






}
