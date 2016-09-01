package com.mygdx.flappybird.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.flappybird.FlappyBird;
import com.mygdx.flappybird.Sprites.Bird;
import com.mygdx.flappybird.Sprites.Tube;

/**
 * Created by Rajat on 8/31/2016.
 */
public class PlayState extends State {
    private Bird bird;
    private Texture bg;
    private Tube tube;
    private Sprite mysprite;

public void create(){
    Sprite mysprite = new Sprite(new Texture("bg.png"));
    mysprite.setSize(480,800);
    mysprite.setX(cam.position.x - (cam.viewportWidth / 2));
    mysprite.setY(0);
}
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        //sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        mysprite.draw(sb);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.draw(tube.getTopTube(), tube.getPostopTube().x, tube.getPosbottomTube().y);
        sb.draw(tube.getBottomTube(), tube.getPosbottomTube().x, tube.getPosbottomTube().y);
        sb.end();

    }

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,300);
        cam.setToOrtho(false, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        bg = new Texture("bg.png");
        bg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tube = new Tube(100);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
        {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

    }



    @Override
    public void dispose() {

    }
}
