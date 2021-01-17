package Tiles;

import Graphics.Assets;

public class LeavesTile extends Tile {
	public LeavesTile(int id) {
		super(Assets.leaves,id);

	}
	
	//making tile solid
		public boolean isSolid() {
			return true;
		}
}
