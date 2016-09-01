package com.mygdx.flappybird.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Rajat on 9/1/2016.
 */
public class Tube {
    private static final int FLUCTUATION = 130,TUBE_GAP = 100,LOWEST_OPENING =120;
    private Texture topTube,bottomTube;
    private Vector2 postopTube,posbottomTube;
    private Random rand;

    public Tube(float x) {
        topTube = new Texture("top_tube.jpg");
        bottomTube = new Texture("bottom_tube.jpg");
        rand = new Random();

        postopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posbottomTube=new Vector2(x,postopTube.y-TUBE_GAP-bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPostopTube() {
        return postopTube;
    }

    public Vector2 getPosbottomTube() {
        return posbottomTube;
    }
}
