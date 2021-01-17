package Tiles;

import Graphics.Assets;

public class LeavesBLTile extends Tile {

	public LeavesBLTile(int id) {
		super(Assets.leavesBL,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
