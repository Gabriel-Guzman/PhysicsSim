import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import object.Floor;
import object.GameObject;
import object.ObjectID;
import object.Player;
import physics.Vector;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private Thread thread = new Thread();
	private boolean running = false;	
	Handler handler;
	
	private void init(){
		
		handler = new Handler();
		
		//Player(Position Vector, Object ID, Friction Coefficient, mass, Coefficient of Restitution)
		handler.addObject(new Player(new Vector(50f,500f),ObjectID.Player, 3f, 1f,.5f));
		handler.addObject(new Floor(new Vector(0f, 670f), ObjectID.Floor, 0f, 0f, 0f, 1280, 10));
		handler.addObject(new Floor(new Vector (490f, 180f), ObjectID.Floor, 0f, 0f, 0f, 200, 25));
		this.addKeyListener(new KeyInput(handler));
		
	}

	public synchronized void start(){
		
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}

	public void run() {
		this.requestFocus();
		init();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(running && delta >= 1){
				frames++;
				render();
			}
				
			while(delta >= 1){
				tick(handler.object);
				delta--;
				updates++;
			}
			
			
			
			
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + "Ticks, FPS, "+ frames + " ");
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}

	private void tick(LinkedList<GameObject> object) {
		handler.tick(object);
	}

	public static void main(String[] args) {
		new GameWindow(1280,720, "Bad Physics", new Game());
	}

}
