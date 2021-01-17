package Worlds;

import java.awt.Graphics;

import Entity.EntityManager;
import Entity.Creatures.Player;
import Entity.Statics.Brock;
import Game.PocketHandler;
import Tiles.Tile;
import Utilities.Utilities;

public class World {
	
	//world size
	private int width;
	private int height;

	//Spawn Location
	private int spawnX, spawnY;
	
	private int[][] tiles;
	private PocketHandler handler;
	
	//Entities
	private EntityManager entityManager;
	
	//loading tiles
	public World(PocketHandler handler, String path) {
		this.handler=handler;
		entityManager = new EntityManager(handler, new Player(handler,100,100));
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		entityManager.addEntity(new Brock(handler,792,576));
	}

	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics graphics) {
		//rending only tiles the game camera can see
		int xStart=(int)Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
		int xEnd=(int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/Tile.TILE_WIDTH +1);
		int yStart=(int)Math.max(0,handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
		int yEnd=(int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILE_HEIGHT +1);
		
		for (int y = yStart; y < yEnd; y++ ) {
			//contains far left visible tile and far right visible tile
			for (int x = xStart; x < xEnd; x++ ) {
				//making x and y the length of a tile and casting tiles to ints
				getTile(x,y).render(graphics,(int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),(int)(y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(graphics);
	}
	
	//getter for tiles
	public Tile getTile(int x,int y) {
		//making sure tile is on map
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		
		//indexing tiles max tiles array with tiles id array
		Tile t = Tile.tiles[tiles[x][y]];
		
		//making sure tile id is valid 
		if (t==null){
			return Tile.grassTile;
		}
		else {
			return t;
		}
	}
	
	//method for loading path for world off computer
	private void loadWorld(String path) {
		//Converting file to string
		String file = Utilities.loadFileAsString(path);
		
		//splitting file on blank spaces
		String[] tokens = file.split("\\s+");
		
		//setting height and width
		width = Utilities.parseInt(tokens[0]);
		height = Utilities.parseInt(tokens[1]);
		
		//setting starting location
		spawnX = Utilities.parseInt(tokens[2]);
		spawnY = Utilities.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y =0; y < height; y++) {
			for (int x =0; x < width; x++) {
				//turning text tiles into tiles
				tiles[x][y] = Utilities.parseInt(tokens[(x + y *width) + 4]);
			}
		}

	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
}
