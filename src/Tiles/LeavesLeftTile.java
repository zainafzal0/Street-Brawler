package Tiles;

import Graphics.Assets;

public class LeavesLeftTile extends Tile {
	
	public LeavesLeftTile(int id) {
		super(Assets.leavesLeft,id);

	}
	
	//making tile solid
		public boolean isSolid() {
			return true;
		}
}
