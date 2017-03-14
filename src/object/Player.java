package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import physics.Vector;

public class Player extends GameObject {
	
	

	public Player(Vector vector, ObjectID id, float frictionCoefficient, float mass, float coefficientOfResitution) {
		super(vector, id, frictionCoefficient, mass, coefficientOfResitution);
		this.velocityVector = new Vector(0,0);
	}

	float acc = -9.8f;
	LinkedList<GameObject> object;

	
	public final int length = 100;
	public final int height = 100;
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)vector.getX(), (int)vector.getY(), length, height);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		
		g2d.draw(getBottomBound());
		g2d.draw(getTopBound());
		g2d.draw(getLeftBound());
		g2d.draw(getRightBound());
	}
	
	public void physics(LinkedList<GameObject> object){
		for(int i = 0; i < object.size(); i++){
			if(object.get(i).id == ObjectID.Floor && this.getBottomBound().intersects(object.get(i).getTopBound())){
				this.sety((float)object.get(i).getTopBound().getY()-100);
				physics.PhysicsHandlerFloor.netForce(this);
			}
		}
	}


	public void tick(LinkedList<GameObject> object) {
		this.vector.sety(vector.getY() - velocityVector.getY());
		velocityVector.yComp = (float) (velocityVector.getY() + acc*(float)(1f/60f));
		this.vector.xComp += velocityVector.getX();
		physics(object);
	}
	@Override
	public Rectangle getRightBound() {
		return new Rectangle((int)vector.getX()+(int)(length*.75),(int)vector.getY(),length/4, height);
	}
	@Override
	public Rectangle getTopBound() {
		return new Rectangle((int)vector.getX(),(int)vector.getY(),length,height/2);
	}
	@Override
	public Rectangle getBottomBound() {
		return new Rectangle((int)vector.getX(),(int)vector.getY() + height/2,length,height/2);
	}
	@Override
	public Rectangle getLeftBound() {
		return new Rectangle((int)vector.getX(),(int)vector.getY(),length/4, height);
	}

	@Override
	public void setx(float x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sety(float y) {
		this.vector.yComp = y;
		
	}

	public Vector getVelocityVector() {
		return velocityVector;
	}

	public Vector getPositionVector() {
		// TODO Auto-generated method stub
		return null;
	}



}
