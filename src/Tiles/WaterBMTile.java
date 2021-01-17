package Tiles;

import Graphics.Assets;

public class WaterBMTile extends Tile {

	public WaterBMTile(int id) {
		super(Assets.waterBM,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
