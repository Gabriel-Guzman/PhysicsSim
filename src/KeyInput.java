import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import object.ObjectID;

public class KeyInput extends KeyAdapter{
	Handler handler;
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ObjectID.Player){
				if( keyCode == KeyEvent.VK_A){
					handler.object.get(i).setVelx(-4f);
				}
				else if( keyCode == KeyEvent.VK_D){
					handler.object.get(i).setVelx(4f);
				}
				else if ( keyCode == KeyEvent.VK_SPACE){
					handler.object.get(i).setVely(5);
				}
				
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		
	}
}
