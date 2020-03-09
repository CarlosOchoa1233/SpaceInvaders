package mx.itesm.caog.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

class pantallaSpaceInvaders extends Pantalla {
    private juego juego;
    private Array<Alien> arrAliens;
    private Texture enemigoAlien;
    private Texture nave;
    private Texture bala;

    public pantallaSpaceInvaders(juego juego) {
        this.juego = juego;
    }

    @Override
    public void show() {
        crearAliens();
        cargarTexturas();
        crearNave();
    }

    private void cargarTexturas() {
        enemigoAlien = new Texture("space/enemigoArriba.png");
        nave = new Texture("space/nave.png");
        bala = new Texture("space/bala.png");
    }

    private void crearAliens() {
        int COLUMNAS = 11;
        int RENGLONES = 5;

        arrAliens = new Array<>(55);
        float dx = ANCHO*0.8f / COLUMNAS;
        float dy = ALTO*0.4f / RENGLONES;

        for (int x = 0; x<COLUMNAS; x++){
            for (int y = 0; y < RENGLONES; y++){
             Alien alien = new Alien(enemigoAlien, x*dx+ANCHO*0.1f, y*dy+ALTO*0.45f);
             arrAliens.add(alien);
            }
        }
    }

    private void crearNave() {
      Nave prota = new Nave(nave, ANCHO/2, ALTO*0.05f);
    }

    @Override
    public void render(float delta) {

        Gdx.app.log("DELTA", delta+"");
        borrarPantalla(0,0,0 );
        moverNave();
        moverBala();

        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        for (Alien alien : arrAliens){
            alien.render(batch);
        }
        batch.end();

    }

    private void moverBala() {
        if (bala != null){

        }
    }

    private void moverNave() {

    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
