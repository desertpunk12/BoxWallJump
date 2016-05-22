package com.cyberpixel.boxwallgame.core.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private boolean atLeft = true;
    private boolean canJump = true;
    private float vx = 0, vy = 0;
    private float gravity = 20;
    private float jumpHieght = 18;
    private float jumpWidth = 3;
    private float gameSpeed;

    private Rectangle rect;

    private Texture tex;

    private final int SCALE;

    private float timer = 0;


    public Player(int scale, float gameSpeed){
        this(0,0,scale,gameSpeed);
    }

    public Player(float x, float y, int scale, float gameSpeed) {
        rect = new Rectangle(x,y,scale,scale);
        this.tex = new Texture("box.png");
        this.SCALE = scale;
        this.gameSpeed=gameSpeed;
    }

    public void handleInput(){
        if(Gdx.input.justTouched() && canJump)
            jump();

    }

    public void update(float dt){
        if((timer+=dt)>1){
            timer-=1;
        }

        vy-=gravity * SCALE * dt * gameSpeed;

        rect.y+=vy * dt * gameSpeed;
        rect.x+=vx * dt * gameSpeed;
    }

    public void render(SpriteBatch sb){
        sb.draw(tex,rect.x,rect.y,-SCALE,0,SCALE,SCALE);
    }

    public void dispose(){
        tex.dispose();
    }

    private void jump(){
        if(atLeft) {
            vx = jumpWidth*SCALE;
            vy = jumpHieght*SCALE;
            atLeft=false;
        }else {
            vx = -jumpWidth*SCALE;
            vy = jumpHieght*SCALE;
            atLeft=true;
        }
        canJump = false;
    }

    public Rectangle getRect(){
        return rect;
    }

    public void collidedLeft(){
        if(vx<0)
            vx=0;
        rect.x++;
        canJump=true;
    }

    public void collidedRight(){
        if(vx>0)
            vx=0;
        rect.x--;
        canJump=true;

    }
}
