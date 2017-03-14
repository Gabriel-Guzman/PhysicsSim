package physics;

import object.GameObject;

public class PhysicsHandlerFloor {
	//This class returns the net acceleration for only object1
	private static float grav = -9.8f;
	
	private static Vector friction(GameObject object){
		Vector tempVelocity = object.getVelocityVector();
		//float friction = grav * object.frictionCoefficient * 1f/60f;
		Vector friction = new Vector(grav * object.frictionCoefficient * 1f/60f, 0);
		//System.out.printf("friction: %f", friction.xComp);
		
		if(Math.signum(tempVelocity.xComp) > 0 && tempVelocity.addVector(friction).xComp > 0){
			
			tempVelocity = tempVelocity.addVector(friction);
			
		}
		
		else if(Math.signum(tempVelocity.xComp) < 0 && tempVelocity.addVector(friction).xComp < 0){
			
			tempVelocity = tempVelocity.subVector(friction);
			
		}
		else {
			
			tempVelocity.xComp = 0;
			
		}
		return tempVelocity;
		
	}
	
	private static Vector bounce(GameObject object){
		
		Vector tempVelocity = object.getVelocityVector();
		tempVelocity.yComp = -1f * object.coefficientOfRestitution * tempVelocity.yComp;
		
		if(tempVelocity.yComp < 1.5f){
			tempVelocity.yComp = 0;
			
		}
		
		return tempVelocity;
	}
	
	public static Vector netForce(GameObject object){
		Vector tempVelocity = friction(object);
		object.velocityVector = tempVelocity;
		tempVelocity = bounce(object);
		return tempVelocity;
	}
	
}
