package com.cyberpixel.boxwallgame.core.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.cyberpixel.boxwallgame.core.entities.Player;
import com.cyberpixel.boxwallgame.core.entities.WallBlock;

import java.util.Random;

public class GameState extends State {

    private final String NAME="Game";

    OrthographicCamera cam;
    ExtendViewport vp;

    Player player;
    Array<WallBlock> lwallblocks;
    Array<WallBlock> rwallblocks;

    Texture tex;
    Random rand;

    private final int SCALE = 64;

    private final int wallPoolSize = 30;
    private final int unitWidth = 10;
    private final int unitHeight = 20;

    private final float gameSpeed = 2.25f;

    private float camY = 0;
    private float vy = 0;

    public GameState(GameStateManager gsm) {
        super(gsm);
        tex = new Texture("box.png");

        cam = new OrthographicCamera(unitWidth*SCALE,unitHeight*SCALE);
        vp = new ExtendViewport(unitWidth*SCALE,unitHeight*SCALE,720,1280,cam);
        vp.update(360,640);
        cam.position.x=SCALE/2;

        player = new Player(-2*SCALE,5*SCALE,SCALE,gameSpeed);
        lwallblocks = new Array<>(wallPoolSize);
        rwallblocks = new Array<>(wallPoolSize);

        initWalls();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);

        for (int i = 0; i < wallPoolSize; i++) {
            lwallblocks.get(i).render(sb);
            rwallblocks.get(i).render(sb);
        }

        player.render(sb);
    }

    @Override
    public void update(float dt) {
        setCamera(dt);
        reuseWalls();
        playerCollision();
        playerDeath();

        player.update(dt);
    }

    @Override
    public void handleInput(float dt) {
        player.handleInput();

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            resetGame();
    }

    @Override
    public void resize(int width, int height) {
        vp.update(width,height,false);
    }

    @Override
    public void dispose() {
        tex.dispose();
        player.dispose();
    }

    @Override
    public String getName(){
        return NAME;
    }


    private void resetGame(){
        gsm.set(new GameState(gsm));
    }

    private void setCamera(float dt){
        camY += vy * dt * gameSpeed;
        vy = Math.max(0,player.getRect().y-(camY -(unitHeight/8)*SCALE));
        cam.position.set(cam.position.x, camY,cam.position.z);
        cam.update();

    }

    private void reuseWalls(){
        for(int i=0;i<wallPoolSize;i++){
            if(lwallblocks.get(i).getRect().y<(camY -((unitHeight+3)*SCALE*.5f)))
                lwallblocks.get(i).getRect().setY(lwallblocks.get(i).getRect().y+((2+wallPoolSize)*SCALE));
            if(rwallblocks.get(i).getRect().y<(camY -((unitHeight+3)*SCALE*.5f)))
                rwallblocks.get(i).getRect().setY(rwallblocks.get(i).getRect().y+(wallPoolSize*SCALE));
        }
    }

    private void playerCollision(){
        for(int i=0;i < wallPoolSize; i++){
            if(lwallblocks.get(i).getRect().overlaps(player.getRect())){
                player.collidedLeft();
                break;
            }else if(rwallblocks.get(i).getRect().overlaps(player.getRect())){
                player.collidedRight();
                break;
            }
        }
    }

    private void playerDeath(){
        if(player.getRect().y<(camY-(unitHeight*SCALE)/2))
            resetGame();
    }

    private void initWalls(){
        for (int i = -12; i <=17 ; i++) {
            lwallblocks.add(new WallBlock(tex,-3*SCALE,i*SCALE,SCALE));
            rwallblocks.add(new WallBlock(tex,3*SCALE,i*SCALE,SCALE));
        }

    }

}
