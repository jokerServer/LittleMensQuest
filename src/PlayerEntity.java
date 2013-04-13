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
		this.runningSpeed = runningSpeed;
	}

	private int vitality;
	private int intelligence;
	private double runningSpeed = 10 / 3.6;
	private double attackSpeed;
	private double jumpPower = 5;
	private boolean running = true;
	private boolean sprinting = false;
	private boolean crouching;
	private boolean jumping;
	private long jumpStart;
	private Direction xDirection;
	public Image playerSprite;
	private Equipment chest;
	private Equipment head;
	private Equipment legs;
	private Equipment boots;
	private Equipment necklace;
	private Equipment ring;
	
	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getVitality() {
		return vitality;
	}

	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public double getJumpPower() {
		return jumpPower;
	}

	public void setJumpPower(double jumpPower) {
		this.jumpPower = jumpPower;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isSprinting() {
		return sprinting;
	}

	public void setSprinting(boolean sprinting) {
		this.sprinting = sprinting;
	}

	public boolean isCrouching() {
		return crouching;
	}

	public void setCrouching(boolean crouching) {
		this.crouching = crouching;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public long getJumpStart() {
		return jumpStart;
	}

	public void setJumpStart(long jumpStart) {
		this.jumpStart = jumpStart;
	}

	public Equipment getChest() {
		return chest;
	}

	public void setChest(Equipment chest) {
		this.chest = chest;
	}

	public Equipment getHead() {
		return head;
	}

	public void setHead(Equipment head) {
		this.head = head;
	}

	public Equipment getLegs() {
		return legs;
	}

	public void setLegs(Equipment legs) {
		this.legs = legs;
	}

	public Equipment getBoots() {
		return boots;
	}

	public void setBoots(Equipment boots) {
		this.boots = boots;
	}

	public Equipment getNecklace() {
		return necklace;
	}

	public void setNecklace(Equipment necklace) {
		this.necklace = necklace;
	}

	public Equipment getRing() {
		return ring;
	}

	public void setRing(Equipment ring) {
		this.ring = ring;
	}

	public PlayerEntity(double xPosition, double yPosition, double zPosition, Equipment head, Equipment chest, Equipment legs, Equipment boots, Equipment necklace, Equipment ring) {
		super(xPosition, yPosition, zPosition);
		try {
			playerSprite = ImageIO.read(new File("res/Player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setChest(chest);
		setHead(head);
		setLegs(legs);
		setBoots(boots);
		setNecklace(necklace);
		setRing(ring);
	}

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
	
	public boolean pickUp(){
		//TODO Pick up
		return false;
	}

	private Direction zDirection;

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
		g.drawString("x: " + getxPosition(), xPosition, yPosition);
		g.drawString("y: " + getyPosition(), xPosition, yPosition + 15);
		g.drawString("z: " + getzPosition(), xPosition, yPosition + 30);
	}

}
