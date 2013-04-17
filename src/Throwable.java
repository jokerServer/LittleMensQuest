import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class Throwable extends Entity {
	private double weight;
	private Image image;
	private long tossStart;
	private double tossStrength;
	private boolean throwing;

	private double hitbox_xdiff = -0.125;
	private double hitbox_ydiff = 0.125;
	private double hitbox_radius = 0.125;
	private double hitbox_depth = 1;
	
	public Throwable(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
	}

	@Override
	protected void updateSpeed() {
		if (throwing) {
			if (getyPosition() > 0) {
				setySpeed(tossStrength - 0.00981
						* (System.currentTimeMillis() - tossStart));
			} else if (getyPosition() <= 0 && getySpeed() <= 0) {
				setySpeed(0);
				setxSpeed(0);
				throwing = false;
				// TODO Abstand zum Boden beachten
			}
		}
	}

	public void toss(int direction, int tossStrength) {
		this.tossStrength = tossStrength;
		throwing = true;
		tossStart = System.currentTimeMillis();
		if (direction == 1) { // Links
			setxSpeed(tossStrength * (-1));
		} else if (direction == 2) { // Rechts
			setxSpeed(tossStrength);
		}
		setySpeed(tossStrength);
	}

	@Override
	public void drawYourself(Graphics g, Component observer) {
		g.setColor(Color.BLACK);
		int xPosition = (int) (getxPosition() * 100) - image.getWidth(observer) / 2;
		int yPosition = (int) (getyPosition() * 100)
				+ (int) (getzPosition() * 40)
				+ image.getHeight(observer) / 2;
		yPosition = observer.getSize().height - yPosition;
		g.drawImage(image, xPosition, yPosition, observer);
		g.setColor(Color.BLUE);
		g.drawString("x: " + getxPosition(), xPosition, yPosition - 15);
		g.drawString("y: " + getyPosition(), xPosition, yPosition);
		g.drawString("z: " + getzPosition(), xPosition, yPosition + 15);
		showHitboxes(g, observer);
	}

	public double getWeight() {
		return weight;
	}

	public Image getImage() {
		return image;
	}

	public double getTossStrength() {
		return tossStrength;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setTossStrength(double tossStrength) {
		this.tossStrength = tossStrength;
	}

	public double getHitbox_xdiff() {
		return hitbox_xdiff;
	}

	public double getHitbox_ydiff() {
		return hitbox_ydiff;
	}

	public double getHitbox_radius() {
		return hitbox_radius;
	}

	public double getHitbox_depth() {
		return hitbox_depth;
	}

	public void setHitbox_xdiff(double hitbox_xdiff) {
		this.hitbox_xdiff = hitbox_xdiff;
	}

	public void setHitbox_ydiff(double hitbox_ydiff) {
		this.hitbox_ydiff = hitbox_ydiff;
	}

	public void setHitbox_radius(double hitbox_radius) {
		this.hitbox_radius = hitbox_radius;
	}

	public void setHitbox_depth(double hitbox_depth) {
		this.hitbox_depth = hitbox_depth;
	}
}
