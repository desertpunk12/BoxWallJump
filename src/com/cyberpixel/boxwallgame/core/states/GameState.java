package com.cyberpixel.boxwallgame.core.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.cyberpixel.boxwallgame.core.entities.Player;
import com.cyberpixel.boxwallgame.core.entities.WallBlock;

public class GameState extends State {

    private final String NAME="Game";

    OrthographicCamera cam;
    ExtendViewport vp;

    Player player;
    Pool<WallBlock> wallblocks;

    Texture tex;

    private final int SCALE = 64;

    public GameState(GameStateManager gsm) {
        super(gsm);

        cam = new OrthographicCamera(10*SCALE,20*SCALE);
        vp = new ExtendViewport(720,1280,cam);

        player = new Player(SCALE);
        wallblocks = new Pool<WallBlock>() {
            @Override
            protected WallBlock newObject() {
                return new WallBlock(SCALE);
            }
        };


        tex = new Texture("box.png");
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        for (int i = -10; i <= 9; i+=1) {
            sb.draw(tex, x+-3*SCALE, i*SCALE,SCALE-1,SCALE-1,SCALE,SCALE);
            sb.draw(tex, x+2*SCALE, i*SCALE,SCALE-1,SCALE-1,SCALE,SCALE);

        }
    }

    @Override
    public void update(float dt) {

    }

    float x = 0;
    @Override
    public void handleInput(float dt) {
        if(Gdx.input.isTouched())
            x++;
    }

    @Override
    public void resize(int width, int height) {
        vp.update(width,height,false);

    }

    @Override
    public void dispose() {

    }

    public String getName(){
        return NAME;
    }
}
