package Entity;

import java.awt.Graphics;
import java.util.ArrayList;

import Entity.Creatures.Player;
import Game.PocketHandler;
import States.State;

public class EntityManager {
	
	private PocketHandler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	public EntityManager(PocketHandler handler, Player player) {
		this.handler=handler;
		this.player=player;
		entities = new ArrayList<Entity>();
		addEntity(player);

	}
	
	public void tick() {
		for (int i=0; i<entities.size();i++) {
			Entity e = entities.get(i);
			e.tick();
		}
		
	}
	
	public void render(Graphics graphics) {
		for(Entity e : entities) {
			e.render(graphics);
		}
	}
	public void addEntity(Entity e) {
		entities.add(e);
	}
	public PocketHandler getHandler() {
		return handler;
	}

	public void setHandler(PocketHandler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
}
