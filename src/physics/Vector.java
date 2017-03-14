package physics;

public class Vector {
	public float xComp;
	public float yComp;
	
	public Vector(){
		xComp = 0;
		yComp = 0;
	}
	public Vector(float x, float y){
		xComp = x;
		yComp = y;
	}
	
	public Vector addVector(Vector vector){
		
		Vector temp = new Vector(this.xComp + vector.xComp, this.yComp + vector.yComp);
		return temp;
		
	}
	
	public Vector subVector(Vector vector){
		
		Vector temp = new Vector(this.xComp - vector.xComp, this.yComp - vector.yComp);
		return temp;
		
	}
	
	public float getX(){
		return xComp;
	}
	public float getY(){
		return yComp;
	}
	
	public void setx(float x){
		this.xComp = x;
	}
	
	public void sety(float y){
		this.yComp = y;
	}
}
