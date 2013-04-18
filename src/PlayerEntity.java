public class PlayerEntity extends Entity {
	public enum Direction {
		FORWARDS, STRAIGHT, BACKWARDS
	}

	private int agility;
	private int strength;
	private int vitality;
	private int intelligence;
	private double runningSpeed = 10 / 3.6;
	private double attackSpeed;
	private Direction xDirection;
	private Direction zDirection;
	private boolean running = true;
	private boolean sprinting = false;
	private boolean crouching;
	private boolean jumping;
	private double jumpPower = 4;
	private long jumpStart;
	private Equipment helmet;
	private Equipment chest;
	private Equipment legs;
	private Equipment boots;
	private Equipment necklace;
	private Equipment ring;
	private Equipment weapon;

	private WeaponEntity igTestSchwert;
	private int weaponHandX;
	private int weaponHandY;
	
	public PlayerEntity(double xPosition, double yPosition, double zPosition,
			int agility, int strength, int vitality, int intelligence,
			Equipment helmet, Equipment chest, Equipment legs, Equipment boots,
			Equipment necklace, Equipment ring, Equipment weapon) {
		super(xPosition, yPosition, zPosition);
		addHitbox(new RectangleHitbox(this, -0.25, 0.9, 0.6, 0.5, 1)); // Head
		addHitbox(new RectangleHitbox(this, -0.4, +0.4, 0.8, 1, 1)); // Body
		setSprite("res/Player.png");
		setAgility(agility);
		setStrength(strength);
		setVitality(vitality);
		setIntelligence(intelligence);
		setChest(chest);
		setHead(helmet);
		setLegs(legs);
		setBoots(boots);
		setNecklace(necklace);
		setRing(ring);
		setWeapon(weapon);
	}

	public boolean pickUp() {
		// TODO Pick up
		return false;
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

	@Override
	protected void updateSpeed() {
		double speed = 0;
		this.updateWeapon();
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

//	@Override
//	public void drawYourself(Graphics g, Component observer) {
//		g.setColor(Color.BLACK);
//		int xPosition = (int) (getxPosition() * 100)
//				- playerSprite.getWidth(observer) / 2;
//		int yPosition = (int) (getyPosition() * 100)
//				+ (int) (getzPosition() * 40)
//				+ playerSprite.getHeight(observer) / 2;
//		yPosition = observer.getSize().height - yPosition;
//		g.drawImage(playerSprite, xPosition, yPosition, observer);
//		showHitboxes(g, observer);
//		g.setColor(Color.BLUE);
//		g.drawString("x: " + getxPosition(), xPosition, yPosition);
//		g.drawString("y: " + getyPosition(), xPosition, yPosition + 15);
//		g.drawString("z: " + getzPosition(), xPosition, yPosition + 30);
//	}

	public double getRunningSpeed() {
		return runningSpeed;
	}

	public double getSprintingSpeed() {
		return runningSpeed + 3;
	}

	public void setRunningSpeed(double runningSpeed) {
		this.runningSpeed = runningSpeed;
	}

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
		return helmet;
	}

	public void setHead(Equipment head) {
		this.helmet = head;
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

	public Equipment getWeapon() {
		return weapon;
	}

	public void setWeapon(Equipment weapon) {
		this.weapon = weapon;
		this.igTestSchwert = new WeaponEntity(this.getxPosition()-0.3,this.getyPosition()+0.5,this.getzPosition(),this.weapon);
	}
	
	// TODO Griff Koordinate
	// TODO Umdrehen, Waffe mitdrehen
	// TODO Update Equipment ?
	// TODO Skill: Hit/Schlag '^'
	
	public void updateWeapon() {
		if (this.weapon!=null) {
			this.igTestSchwert.setX(this.getxPosition()-0.3);
			this.igTestSchwert.setY(this.getyPosition()+0.5);
			this.igTestSchwert.setZ(getzPosition());
		}
	}
}
