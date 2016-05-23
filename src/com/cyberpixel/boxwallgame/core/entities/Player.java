package com.cyberpixel.boxwallgame.core.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private boolean atLeft = true;
    private boolean canJump = true;

    private float gameSpeed;

    private float vx = 0, vy = 0;
    private float playerRot = 0;
    private float gravity = 20;
    private float jumpHieght = 16;
    private float jumpWidth = 4;
    private float rotSpd = 165;

    private Rectangle rect;

//    private Texture tex;
    private Sprite sprPlayer;

    private final int SCALE;

    private float timer = 0;


    public Player(int scale, float gameSpeed){
        this(0,0,scale,gameSpeed);
    }

    public Player(float x, float y, int scale, float gameSpeed) {
        rect = new Rectangle(x,y,scale,scale);
//        this.tex = new Texture("box.png");
        this.SCALE = scale;
        this.gameSpeed=gameSpeed;
        sprPlayer = new Sprite(new TextureRegion(new Texture("box.png"),1,1));
        sprPlayer.setScale(scale);
    }

    public void handleInput(){
        if(Gdx.input.justTouched() && canJump)
            jump();

    }

    public void update(float dt) {
        if ((timer += dt) > 1) {
            timer -= 1;
        }

        vy -= gravity * SCALE * dt * gameSpeed;

        rect.y += vy * dt * gameSpeed;
        rect.x += vx * dt * gameSpeed;

        if (canJump){
            sprPlayer.setRotation(0);
            playerRot = 0;
        }else {
            playerRot += rotSpd * dt * gameSpeed * (atLeft?1:-1);
            sprPlayer.setRotation(sprPlayer.getRotation() + playerRot * dt * gameSpeed);
        }
    }

    public void render(SpriteBatch sb){
//        sb.draw(tex,rect.x,rect.y,-SCALE,0,SCALE,SCALE,1,1,1);
        sprPlayer.setPosition(rect.x+SCALE/2,rect.y);
        sprPlayer.draw(sb);
    }


    public void dispose(){
        sprPlayer.getTexture().dispose();
    }


    public Rectangle getRect(){
        return rect;
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

    public void collidedLeft(){
        if (atLeft) {
//            if(vx<0)
                vx=0;
            rect.x++;
            canJump=true;
        }
    }

    public void collidedRight(){
        if (!atLeft) {
//            if(vx>0)
                vx=0;
            rect.x--;
            canJump=true;
        }
    }

}
