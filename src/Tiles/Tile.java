package Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//static variables
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile leavesTile = new LeavesTile(1);
	public static Tile leavesUpTile = new LeavesUpTile(2);
	public static Tile leavesLeftTile = new LeavesLeftTile(3);
	public static Tile leavesRightTile = new LeavesRightTile(4);
	public static Tile leavesDownTile = new LeavesDownTile(5);
	public static Tile bushTile = new BushTile(6);
	public static Tile leavesTRTile = new LeavesTRTile(7);
	public static Tile leavesTLTile = new LeavesTLTile(8);
	public static Tile leavesBRTile = new LeavesBRTile(9);
	public static Tile leavesBLTile = new LeavesBLTile(10);
	public static Tile waterTLTile = new WaterTLTile(11);
	public static Tile waterTMTile = new WaterTMTile(12);
	public static Tile waterTRTile = new WaterTRTile(13);
	public static Tile waterMLTile = new WaterMLTile(14);
	public static Tile waterTile = new WaterTile(15);
	public static Tile waterMRTime = new WaterMRTile(16);
	public static Tile waterBLTile = new WaterBLTile(17);
	public static Tile waterBMTile = new WaterBMTile(18);
	public static Tile waterBRTile = new WaterBRTile(19);



	//Default tile size
	public static final int TILE_WIDTH = 48;
	public static final int TILE_HEIGHT = 48;
	
	protected BufferedImage texture;
	
	//tile id
	protected final int id; 
	
	//Tile constructor links id with texture
	public Tile(BufferedImage texture, int id) {
		this.texture=texture;
		this.id=id;
		
		//tile at specific id will be equal to this tile
		tiles[id] = this;
	}
	
	//sets tile to solid or walkable
	public boolean isSolid() {
		return false;
	}
	
	public void tick() {
		
	}
	
	//drawing tile
	public void render(Graphics graphics,int x, int y) {
		graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	//tile id getter
	public int getId() {
		return id;
	}
}
