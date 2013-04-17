import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Entity {
	private double x; // in m
	private double y; // in m
	private double z; // in m
	private double xSpeed; // in m/s
	private double ySpeed; //in m/s
	private double zSpeed; // in m/s
	private static ArrayList<Entity> entitys = new ArrayList<Entity>();

	/**
	 * Creates a new Entity and adds it to the ArrayList of all Entitys
	 * @param x Center X Position (Based left)
	 * @param y Center Y Position (Based on the ground)
	 * @param z Z Position (Based front)
	 */
	public Entity(double x, double y, double z) {
		entitys.add(this);
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public void update(double timeElapsed) {
		updateSpeed();
		updatePosition(timeElapsed);
		checkForCollisions();
	}
		
	private boolean checkForCollisions(){
		//TODO just check nearby
		//TODO reaction
		for (Entity entity : entitys){
			if (!entity.equals(this)){
				if (this.checkForCollision(entity)){
					return true;
				}
			}
		}
		return false;
	}

	protected void updatePosition(double timeElapsed){
		setX(getxPosition() + getxSpeed() * timeElapsed / 1000);
		setY(Math.max(getyPosition() + getySpeed() * timeElapsed / 1000, 0));
		setZ(getzPosition() + getzSpeed() * timeElapsed / 1000);
	}
	
	protected abstract void updateSpeed();

	public abstract boolean checkForCollision(Entity e);
	
	public abstract boolean checkForCollision(Hitbox h);
	
	public void drawYourself(Graphics g, Component observer){ //TODO In Render class // abstract ?
		g.setColor(Color.BLUE);
		g.fillRect((int) getxPosition(), (int) getyPosition(), 40, 40);
	}

	public static ArrayList<Entity> getEntitys() {
		return entitys;
	}

	public double getxPosition() {
		return x;
	}

	public void setX(double xPosition) {
		this.x = xPosition;
	}

	public double getyPosition() {
		return y;
	}

	public void setY(double yPosition) {
		this.y = yPosition;
	}

	public double getzPosition() {
		return z;
	}

	public void setZ(double zPosition) {
		this.z = zPosition;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	protected void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	protected void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	public double getzSpeed() {
		return zSpeed;
	}

	protected void setzSpeed(double zSpeed) {
		this.zSpeed = zSpeed;
	}

	public double getFallBegin() {
		return fallBegin;
	}

	public void setFallBegin(double fallBegin) {
		this.fallBegin = fallBegin;
	}

	private boolean falling;
	private double fallBegin;

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		if (falling) {
			fallBegin = System.currentTimeMillis();
		}
		this.falling = falling;
	}
}
