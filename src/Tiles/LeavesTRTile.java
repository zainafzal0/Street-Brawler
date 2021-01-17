package Tiles;

import Graphics.Assets;

public class LeavesTRTile extends Tile {

	public LeavesTRTile(int id) {
		super(Assets.leavesTR,id);

	}
	
	//making tile solid
	public boolean isSolid() {
		return true;
	}
}
