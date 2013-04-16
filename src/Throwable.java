import java.awt.Image;

public class Throwable extends Entity {
	private double weight;
	private Image image;
	private double throwStartSpeed;
	private long tossStart;
	private double tossStrength;
	private boolean throwing;
	private CircleHitbox hitbox;

	public CircleHitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(CircleHitbox hitbox) {
		this.hitbox = hitbox;
	}

	public Throwable(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		hitbox = new CircleHitbox(this, -0.025, 0.025, 0.175, 0.5);
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

	@Override
	public boolean checkForCollision(Entity e) {
		return e.checkForCollision(hitbox);
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
	public boolean checkForCollision(Hitbox h) {
		return hitbox.intersects(h);
	}
}
