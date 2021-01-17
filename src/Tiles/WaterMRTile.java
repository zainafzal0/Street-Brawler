package Tiles;

import Graphics.Assets;

public class WaterMRTile extends Tile {

	public WaterMRTile(int id) {
		super(Assets.waterMR,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
