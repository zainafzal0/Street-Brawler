package Tiles;

import Graphics.Assets;

public class WaterTRTile extends Tile {

	public WaterTRTile(int id) {
		super(Assets.waterTR,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
