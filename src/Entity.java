import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Entity {
	private double x; // in m
	private double y; // in m
	private double z; // in m
	private double xSpeed; // in m/s
	private double ySpeed; // in m/s
	private double zSpeed; // in m/s
	private boolean falling;
	private double fallBegin;
	private Image sprite;
	private int rotation = 0;
	private int rotationX = 0;
	private int rotationY = 0;
	private ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
	private static ArrayList<Entity> entitys = new ArrayList<Entity>();
	private double health;
	private final double maxHealth;

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
		this.maxHealth = 100; //TODO parameter
		this.health = maxHealth;
		setX(x);
		setY(y);
		setZ(z);
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

	public void update(double timeElapsed) {
		updateSpeed();
		updatePosition(timeElapsed);
		checkForCollisions();
	}
	
	protected void updatePosition(double timeElapsed) {
		setX(getxPosition() + getxSpeed() * timeElapsed / 1000);
		setY(Math.max(getyPosition() + getySpeed() * timeElapsed / 1000, 0));
		setZ(getzPosition() + getzSpeed() * timeElapsed / 1000);
	}
	
	protected abstract void updateSpeed();
	
	protected void showHitboxes(Graphics g, Component observer){ //DEBUG
		for (Hitbox hb : getHitboxes()){
			hb.show(g,  observer);
		}
	}

	public void drawYourself(Graphics g, Component observer) { // TODO In Render // class // abstract ?
		Image lSprite = getSprite();
		g.setColor(Color.BLACK);
		double pixelsPerMeter = 100; //TODO von Auflösung abhängig
		int spritePositionX = (int) (getxPosition() * pixelsPerMeter)
				- getSprite().getWidth(observer) / 2;
		int spritePositionY = (int) (getyPosition() * pixelsPerMeter)
				+ (int) (getzPosition() * pixelsPerMeter/2)
				+ getSprite().getHeight(observer) / 2;
		spritePositionY = observer.getSize().height - spritePositionY;

		double rotation = Math.toRadians(this.getRotation());
		//double locationX = lSprite.getWidth(observer) / 2;
		//double locationY = lSprite.getHeight(observer) / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotation, this.getRotationX(), this.getRotationY());
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		g.drawImage(op.filter((BufferedImage) lSprite, null), spritePositionX, spritePositionY, observer);
		
		//g.drawImage(lSprite, xPosition, yPosition, observer);
		showHitboxes(g, observer);
		g.setColor(Color.BLUE);
		//DEBUG
		g.drawString("x: " + getxPosition(), spritePositionX, spritePositionY);
		g.drawString("y: " + getyPosition(), spritePositionX, spritePositionY + 15);
		g.drawString("z: " + getzPosition(), spritePositionX, spritePositionY + 30);
		g.drawString("hp: " + this.health, spritePositionX, spritePositionY + 45);
	}
	
	public void destroy(){
		entitys.remove(this);
	}
	
	public boolean getDamaged(double value){
		this.health = this.health - value;
		if (health <= 0){
			destroy();
		}
		return true;
	}
	
	public boolean getHealed(double value){
		this.health = Math.min(this.health + value, this.maxHealth);
		return true;
	}

	
	
	
	public static ArrayList<Entity> getEntitys() {
		@SuppressWarnings("unchecked")
		ArrayList<Entity> clone = (ArrayList<Entity>) entitys.clone();
		return clone;
	}
	
	protected ArrayList<Hitbox> getHitboxes(){
		if (this.hitboxes.size() == 0){
			throw new IllegalStateException("Please specify at least one Hitbox for the Entity");
		} else {
			return this.hitboxes;
		}
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
	
	public int getRotationX() {
		return rotationX;
	}

	public int getRotationY() {
		return rotationY;
	}
	
	public int getRotation() {
		return this.rotation;
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
	
	public void setRotation(int rotation, int rotationY, int rotationX) {
		this.rotation = rotation;
		this.rotationY = rotationY;
		this.rotationX = rotationX;
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
	
	public Image getSprite() {
		if (sprite == null)
			throw new IllegalStateException("No sprite specified");
		else
			return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	
	public void setSprite(String path){
		try{
			setSprite(ImageIO.read((new File(path))));
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void addHitbox(Hitbox hb) {
		this.hitboxes.add(hb);
	}
}
