package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import physics.Vector;

public class Floor extends GameObject{
	
	int length;
	int height;
	
	public Floor(Vector vector, ObjectID id, float frictionCoefficient, float mass, float coefficientOfResitution, int length, int height) {
		super(vector, id, frictionCoefficient, mass, coefficientOfResitution);
		this.length = length;
		this.height = height;
	}

	

	

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		/*g.setColor(Color.BLUE);
		g.fillRect((int)this.vector.xComp, (int)this.vector.yComp, length, height);*/
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.white);
		g2d.draw(new Rectangle((int)this.vector.xComp, (int)this.vector.yComp, length,height));
		
		
	}

	@Override
	public Rectangle getRightBound() {
		return new Rectangle((int)vector.xComp+(int)(length*.75),(int)vector.yComp,length/4, height);
		
	}

	
	public Rectangle getTopBound() {
		return new Rectangle((int)this.vector.xComp, (int)this.vector.yComp, length,height/4);
		
	}

	
	public Rectangle getBottomBound() {
		return new Rectangle((int)vector.xComp + height/2/2,(int)vector.yComp + height/2,length/2,height/2);
		
	}

	
	public Rectangle getLeftBound() {
		return new Rectangle((int)vector.xComp,(int)vector.yComp,length/4, height);
		
	}

	public Vector getPositionVector() {
		// TODO Auto-generated method stub
		return vector;
	}

	public void setx(float x) {
		// TODO Auto-generated method stub
		
	}

	public void sety(float y) {
		// TODO Auto-generated method stub
		
	}

	public Vector getVelocityVector() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
