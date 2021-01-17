package Tiles;

import Graphics.Assets;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Assets.water,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
