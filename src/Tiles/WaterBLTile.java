package Tiles;

import Graphics.Assets;

public class WaterBLTile extends Tile {

	public WaterBLTile(int id) {
		super(Assets.waterBL,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
