package Tiles;

import Graphics.Assets;

public class WaterMLTile extends Tile {

	public WaterMLTile(int id) {
		super(Assets.waterML,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
