import java.awt.Graphics;
import java.util.LinkedList;

import object.GameObject;

public class Handler{
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(LinkedList<GameObject> List){
		for(int i = 0; i < object.size(); i++){
			object.get(i).tick(List);
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			object.get(i).render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}