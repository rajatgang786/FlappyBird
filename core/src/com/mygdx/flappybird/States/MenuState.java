package com.mygdx.flappybird.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.flappybird.FlappyBird;

/**
 * Created by Rajat on 8/31/2016.
 */
public class MenuState  extends State{
    private Texture background,playbutton;


    public MenuState(GameStateManager gsm){
        super(gsm);
        background = new Texture("bg.png");
        playbutton = new Texture("playbutton.png");
    }
    @Override
    public void handleInput() {
            if (Gdx.input.justTouched())
            {
                gsm.set(new PlayState(gsm));
                dispose();
            }
    }

    @Override
    public void update(float dt) {
            handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        sb.draw(playbutton,(FlappyBird.WIDTH / 2)-(playbutton.getWidth()/2),FlappyBird.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbutton.dispose();
    }
}
