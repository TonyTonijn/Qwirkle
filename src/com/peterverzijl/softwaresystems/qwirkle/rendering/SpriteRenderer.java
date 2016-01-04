package com.peterverzijl.softwaresystems.qwirkle.rendering;

import com.peterverzijl.softwaresystems.qwirkle.gameengine.Component;
import com.peterverzijl.softwaresystems.qwirkle.gameengine.GameEngineComponent;
import com.peterverzijl.softwaresystems.qwirkle.ui.Sprite;

/**
 * A class that contains the sprite that is due for rendering.
 * @author Peter Verzijl
 * @version 1.0a
 */
public class SpriteRenderer extends RenderComponent {
	
	/**
	 * The sprite that gets rendered
	 */
	private Sprite mSprite;
	
	/**
	 * Sets the sprite for the rendering.
	 * @param sprite
	 */
	public void setSprite(Sprite sprite) {
		mSprite = sprite;
		GameEngineComponent.renderers.add(this);
	}
	
	@Override
	public Sprite getSprite() {
		return mSprite;
	}	
}
