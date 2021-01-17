package Tiles;

import Graphics.Assets;

public class WaterBRTile extends Tile {

	public WaterBRTile(int id) {
		super(Assets.waterBR,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
