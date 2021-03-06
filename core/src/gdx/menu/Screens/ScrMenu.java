package gdx.menu.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.OrthographicCamera;
import gdx.menu.GamMenu;

public class ScrMenu implements Screen, InputProcessor {

    Button btnPlay, btnAni, btnScr1, btnScr2, btnScr3;
    GamMenu gamMenu;
    Texture txButtonP, txButtonT, txNamM;
    OrthographicCamera oc;
    SpriteBatch batch;
    Sprite sprNamM;

    public ScrMenu(GamMenu _gamMenu) {  //Referencing the main class.
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        btnScr1 = new Button(100, 50, 100, Gdx.graphics.getHeight() - 50, "scratch1.png");
        btnScr2 = new Button(100, 50, 205, Gdx.graphics.getHeight() - 50, "scratch2.png");
        btnScr3 = new Button(100, 50, 310, Gdx.graphics.getHeight() - 50, "scratch3.png");
        btnPlay = new Button(100, 50, 0, Gdx.graphics.getHeight() - 50, "controls_button.png");
        btnAni = new Button(100, 50, Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 50, "start_button.png");
        txNamM = new Texture("main_menu.png");
        sprNamM = new Sprite(txNamM);
        sprNamM.setFlip(false, true);
        sprNamM.setSize(60, 80);
        sprNamM.setPosition(Gdx.graphics.getWidth() / 2 - 30, Gdx.graphics.getHeight() / 2 - 40);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        batch.draw(txNamM, 0, Gdx.graphics.getHeight(), Gdx.graphics.getWidth(), -Gdx.graphics.getHeight());
        btnPlay.draw(batch);
        btnAni.draw(batch);
        btnScr1.draw(batch);
        btnScr2.draw(batch);
        btnScr3.draw(batch);
        batch.end(); 
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        txNamM.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            if (isHit(screenX, screenY, btnPlay)) {
                System.out.println("Hit Play");
                gamMenu.updateState(8);
            } else if (isHit(screenX, screenY, btnAni)) {
                System.out.println("Hit Animation");
                gamMenu.updateState(3);
            }
            else if (isHit(screenX, screenY, btnScr1)) {
                System.out.println("Hit Scratch 1");
                gamMenu.updateState(1);
            }
            else if (isHit(screenX, screenY, btnScr2)) {
                System.out.println("Hit Scratch 2");
                gamMenu.updateState(4);
            }
            else if (isHit(screenX, screenY, btnScr3)) {
                System.out.println("Hit Scratch 3");
                gamMenu.updateState(5);
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public boolean isHit(int nX, int nY, Sprite sprBtn) {
        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
            return true;
        } else {
            return false;
        }
    }
}