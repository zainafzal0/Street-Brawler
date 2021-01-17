package Tiles;

import Graphics.Assets;

public class LeavesUpTile extends Tile {
	public LeavesUpTile(int id) {
		super(Assets.leavesUp,id);

	}
	
	//making tile solid
		public boolean isSolid() {
			return true;
		}
}
