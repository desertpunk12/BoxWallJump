package com.cyberpixel.boxwallgame.core.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class WallBlock {

    private final int SCALE;
    private int unitsHigh;
    private Rectangle rect;

    private Texture tex;



    public WallBlock(int scale){
        this(0,0,1);
    }

    public WallBlock(float x, float y,int scale) {
        this.rect = new Rectangle(x,y,scale,scale);
        this.SCALE = scale;
        this.tex = new Texture("box.png");
    }

    public void update(float dt){

    }

    public void render(SpriteBatch sb){
        sb.draw(tex,rect.x,rect.y,-SCALE,0,SCALE,SCALE-2);
    }



    public Rectangle getRect(){
        return rect;
    }


}
