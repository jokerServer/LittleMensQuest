import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Entity {
	private double x; // in m
	private double y; // in m
	private double z; // in m
	private double xSpeed; // in m/s
	private double ySpeed; // in m/s
	private double zSpeed; // in m/s
	private boolean falling;
	private double fallBegin;
	private ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
	private static ArrayList<Entity> entitys = new ArrayList<Entity>();

	/**
	 * Creates a new Entity and adds it to the ArrayList of all Entitys
	 * 
	 * @param x
	 *            Center X Position (Based left)
	 * @param y
	 *            Center Y Position (Based on the ground)
	 * @param z
	 *            Z Position (Based front)
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

	private ArrayList<Entity> checkForCollisions() {
		ArrayList<Entity> collisions = new ArrayList<Entity>();
		for (Entity entity : entitys) {
			if (!entity.equals(this)) {
				if (this.checkForCollision(entity)) {
					collisions.add(entity);
				}
			}
		}
		return collisions;
	}

	public boolean checkForCollision(Entity e) {
		for (Hitbox hitbox: getHitboxes()){
			if (e.checkForCollision(hitbox)) return true;
		}
		return false;
	}

	public boolean checkForCollision(Hitbox h) {
		for (Hitbox hitbox : getHitboxes()){
			if (hitbox.intersects(h)) return true;
		}
		return false;
	}
	
	protected void showHitboxes(Graphics g, Component observer){
		for (Hitbox hb : getHitboxes()){
			hb.show(g,  observer);
		}
	}

	protected void updatePosition(double timeElapsed) {
		setX(getxPosition() + getxSpeed() * timeElapsed / 1000);
		setY(Math.max(getyPosition() + getySpeed() * timeElapsed / 1000, 0));
		setZ(getzPosition() + getzSpeed() * timeElapsed / 1000);
	}

	public void addHitbox(Hitbox hb) {
		getHitboxes().add(hb);
	}
	
	protected ArrayList<Hitbox> getHitboxes(){
		if (this.hitboxes.size() == 0){
			throw new IllegalStateException("Please specify at least one Hitbox for the Entity");
		} else {
			return this.hitboxes;
		}
	}

	protected abstract void updateSpeed();

	public void drawYourself(Graphics g, Component observer) { // TODO In Render
																// class //
																// abstract ?
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
