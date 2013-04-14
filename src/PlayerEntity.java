import java.awt.Color;
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

	public double getSprintingSpeed() {
		return runningSpeed + 3;
	}

	public void setRunningSpeed(double runningSpeed) {
		this.runningSpeed = runningSpeed; // 
	}

	private int vitality;
	private int intelligence;
	private double runningSpeed = 10 / 3.6;
	private double attackSpeed;
	private double jumpPower = 4;
	private boolean running = true;
	private boolean sprinting = false;
	private boolean crouching;
	private boolean jumping;
	private long jumpStart;
	private Direction xDirection;
	public Image playerSprite;

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
		try {
			playerSprite = ImageIO.read(new File("res/Player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jump() {
		if (!jumping) {
			crouching = false;
			jumping = true;
			jumpStart = System.currentTimeMillis();
		}
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
		double speed = 0;
		if (sprinting) {
			speed = getSprintingSpeed();
		} else if (running) {
			speed = getRunningSpeed();
		}
		if (getxDirection() == Direction.FORWARDS) {
			setxSpeed(speed);
		} else if (getxDirection() == Direction.BACKWARDS) {
			setxSpeed(-speed);
		} else {
			setxSpeed(0);
		}
		if (getzDirection() == Direction.FORWARDS) {
			setzSpeed(speed);
		} else if (getzDirection() == Direction.BACKWARDS) {
			setzSpeed(-speed);
		} else {
			setzSpeed(0);
		}
		if (jumping) {
			if (getyPosition() == 0 && getySpeed() < 0) {
				setySpeed(0);
				jumping = false;
			} else {
				setySpeed(jumpPower - 0.00981
						* (System.currentTimeMillis() - jumpStart));
			}
		}
	}

	@Override
	public void drawYourself(Graphics g, Component observer) {
		g.setColor(Color.BLACK);
		int xPosition = (int) (getxPosition() * 100) + 50
				+ (int) (getzPosition() * 10);
		int yPosition = (int) (getyPosition() * 100) + 100
				+ (int) (getzPosition() * 40);
		yPosition = observer.getSize().height - yPosition;
		g.drawImage(playerSprite, xPosition, yPosition, observer);
		g.setColor(Color.BLUE);
		g.drawString("x: " + getxPosition(), xPosition, yPosition - 15);
		g.drawString("y: " + getyPosition(), xPosition, yPosition);
		g.drawString("z: " + getzPosition(), xPosition, yPosition + 15);
	}

}
