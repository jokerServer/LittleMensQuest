import java.util.ArrayList;

public abstract class Entity {
	private double xPosition; // in m
	private double yPosition; // in m
	private double zPosition; // in m
	private double xSpeed; // in m/s
	private double ySpeed; // in m/s
	private double zSpeed; // in m/s
	private static ArrayList<Entity> entitys;

	public Entity(double xPosition, double yPosition, double zPosition) {
		entitys.add(this);
		setxPosition(xPosition);
		setyPosition(yPosition);
		setzPosition(zPosition);
	}
	
	public static ArrayList<Entity> getEntitys(){
		return entitys;
	}
	
	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}
	
	public double getzPosition() {
		return zPosition;
	}

	public void setzPosition(double zPosition) {
		this.zPosition = zPosition;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	private void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	private void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public double getzSpeed() {
		return zSpeed;
	}

	private void setzSpeed(double zSpeed) {
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

	public void update(double timeElapsed) {
		applyGravity(timeElapsed);
		updatePosition(timeElapsed);
	}

	protected void applyGravity(double timeElapsed) {
		if (isFalling()) {
			double fallTime = fallBegin - System.currentTimeMillis();
			ySpeed = fallTime / 1000 * 9.81;
		} else {
			ySpeed = 0;
		}
	}

	protected void updatePosition(double timeElapsed) {

	}

	public void toss(double angle, double speed) {
		setFalling(true);
		setxSpeed(speed * Math.cos(angle));
		setySpeed(speed * Math.sin(angle));
		setzSpeed(speed * Math.tan(angle));
	}
	
	public abstract boolean checkForCollision(Entity e);
}
