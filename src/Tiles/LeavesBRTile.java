package Tiles;

import Graphics.Assets;

public class LeavesBRTile extends Tile {

	public LeavesBRTile(int id) {
		super(Assets.leavesBR,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
