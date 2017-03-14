package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import physics.Vector;

public abstract class GameObject {
	protected Vector vector;
	public Vector velocityVector;
	protected ObjectID id;
	public float frictionCoefficient;
	protected float mass;
	public float coefficientOfRestitution;
	
	public GameObject(Vector vector, ObjectID id, float frictionCoefficient, float mass, float coefficientOfResitution){
		this.vector = vector;
		this.id = id;
		this.frictionCoefficient = frictionCoefficient;
		this.mass = mass;
		this.coefficientOfRestitution = coefficientOfResitution;
	}
	
	public abstract void tick(LinkedList<GameObject> object);
	
	public abstract void render(Graphics g);
	
	public abstract Rectangle getRightBound();
	public abstract Rectangle getTopBound();
	public abstract Rectangle getBottomBound();
	public abstract Rectangle getLeftBound();
	public abstract Vector getPositionVector();

	public abstract void setx(float x);
	public abstract void sety(float y);
	
	public abstract Vector getVelocityVector();
	
	public void setVelx(float x){
		this.velocityVector.xComp = x;
	}
	public void setVely(float y){
		this.velocityVector.yComp = y;
	}
	
	public ObjectID getId(){
		return id;
	}
}
