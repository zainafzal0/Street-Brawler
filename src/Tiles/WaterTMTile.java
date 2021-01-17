package Tiles;

import Graphics.Assets;

public class WaterTMTile extends Tile {

	public WaterTMTile(int id) {
		super(Assets.waterTM,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
