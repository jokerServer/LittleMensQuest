
public class CircleHitbox extends Hitbox {
	private double radius;
	
	public CircleHitbox(double x, double y, double z, double radius, double depth) {
		super(x, y, z, depth);
		this.radius = radius;
	}

	@Override
	public boolean intersects(Hitbox hb) {
		if (hb.getShape() == 0) {
			return Hitbox.intersects(this, (RectangleHitbox) hb);
		} else if (hb.getShape() == 1) {
			return Hitbox.intersects((CircleHitbox) hb, this);
		}
		return false;
	}

	@Override
	public int getShape() {
		return 1; //Cirlce
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
