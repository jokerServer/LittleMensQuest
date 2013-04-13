import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerEntity extends Entity {
	public enum Direction {
		FORWARDS, STRAIGHT, BACKWARDS
	}

	private int agility;
	private int strength;
	public double getRunningSpeed() {
		return runningSpeed;
	}

	public void setRunningSpeed(double runningSpeed) {
		this.runningSpeed = runningSpeed;
	}

	private int vitality;
	private int intelligence;
	private double runningSpeed = 100;
	private double attackSpeed;
	private double jumpPower;
	private boolean running;
	private boolean sprinting;
	private boolean crouching;
	private boolean jumping;
	private long jumpStart;
	private Direction xDirection;

	public Direction getxDirection() {
		return xDirection;
	}

	public void setxDirection(Direction xDirection) {
		this.xDirection = xDirection;
	}

	public Direction getzDirection() {
		return zDirection;
	}

	public void setzDirection(Direction zDirection) {
		this.zDirection = zDirection;
	}

	private Direction zDirection;

	public PlayerEntity(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		// TODO Auto-generated constructor stub
	}

	public void jump() {
		crouching = false;
		jumping = true;
		jumpStart = System.currentTimeMillis();
	}

	public void sprint() {
		running = false;
		sprinting = true;
	}

	public void run() {
		sprinting = false;
		running = true;
	}

	public void stop() {
		sprinting = false;
		running = false;
	}

	@Override
	public boolean checkForCollision(Entity e) {
		// TODO Add collision detection
		return false;
	}

	@Override
	protected void updateSpeed() {
		if (getxDirection() == Direction.FORWARDS) {
			setxSpeed(getRunningSpeed());
		} else if (getxDirection() == Direction.BACKWARDS) {
			setxSpeed(-getRunningSpeed());
		} else {
			setxSpeed(0);
		}
		if (getzDirection() == Direction.FORWARDS) {
			setzSpeed(getRunningSpeed());
		} else if (getzDirection() == Direction.BACKWARDS) {
			setzSpeed(-getRunningSpeed());
		} else {
			setzSpeed(0);
		}
		if (jumping){
			setySpeed(jumpPower - 0.00981 * (System.currentTimeMillis() - jumpStart));
		}
	}
	
	@Override
	public void drawYourself(Graphics g, Component observer) {
		Image img = null;
		try {
			img = ImageIO.read(new File("res/Player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, (int) getxPosition(), (int) getyPosition(), observer);
	}

}
