package mx.itesm.caog.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

class PantallaMenu extends Pantalla {
    private final juego juego;
    private Texture texturaFondo;

    private Stage escenaMenu;

    public PantallaMenu(juego juego) {

        this.juego = juego;
    }

    @Override
    public void show() {

        texturaFondo = new Texture("fondo (2).jpg");
        crearMenu();

    }

    private void crearMenu() {
        escenaMenu = new Stage(vista);

        Texture texturaBotonJugar = new Texture("botonJugar.png");
        TextureRegionDrawable trdJugar = new TextureRegionDrawable(new TextureRegion(texturaBotonJugar));

        Texture texturaBotonJugarP = new Texture("botonJugarP.png");
        TextureRegionDrawable trdJugarP = new TextureRegionDrawable(new TextureRegion(texturaBotonJugarP));

        ImageButton botonJugar = new ImageButton(trdJugar, trdJugarP);


        botonJugar.setPosition(ANCHO/2-botonJugar.getWidth()/2, 2*ALTO/3);
        escenaMenu.addActor(botonJugar);

        botonJugar.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                juego.setScreen(new pantallaSpaceInvaders(juego));
            }
        });


        Gdx.input.setInputProcessor(escenaMenu);


    }

    @Override
    public void render(float delta) {

        borrarPantalla(0,0,0);
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        batch.draw(texturaFondo, 0, 0);
        batch.end();

        escenaMenu.draw();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        texturaFondo.dispose();

    }
}
