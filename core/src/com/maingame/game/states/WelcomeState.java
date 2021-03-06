package com.maingame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maingame.game.MainGame;

public class WelcomeState extends State {
	private final Texture background;
	private final Texture playBtn;
	private final Texture title;
	private final Texture advance;
	

	public WelcomeState(GameStateManager gsm) {
		super(gsm);
		background = new Texture("background.PNG");
		playBtn = new Texture("play.PNG");
		title = new Texture("title.PNG");
		advance = new Texture("advance.PNG");
	}

	@Override
	public void handleInput() {
	
		if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
			gsm.set(new MenuState(gsm));
			dispose();
		}
		if(Gdx.input.justTouched()) {
			gsm.set(new MenuState(gsm));
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
		sb.draw(background, 0, 0, MainGame.WIDTH , MainGame.HEIGHT);
		sb.draw(playBtn, (MainGame.WIDTH / 3) - (playBtn.getWidth() / 10), MainGame.HEIGHT / 50);
		sb.draw(title, (MainGame.WIDTH / 5) - (title.getWidth() / 10), MainGame.HEIGHT / 50);
		sb.draw(advance, (MainGame.WIDTH / 20) - (advance.getWidth() / 250), MainGame.HEIGHT / 50);
		sb.end();
	}
	

	@Override
	public void dispose() {
		background.dispose();
		playBtn.dispose();
		title.dispose();
		advance.dispose();
	}
}

