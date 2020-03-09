package mx.itesm.caog.spaceinvaders;

import com.badlogic.gdx.graphics.Texture;

public class Bala extends Objeto {

    private float vy;

    public Bala(Texture textura, float x, float y) {
        super(textura, x, y);
    }

    public void mover(float dt){
        float dy = vy*dt;
        sprite.setY(sprite.getY() + dy);
    }
}
