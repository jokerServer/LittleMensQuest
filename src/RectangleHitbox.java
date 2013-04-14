public class RectangleHitbox extends Hitbox {
	private double width;
	private double height;

	public RectangleHitbox(double x, double y, double z, double width,
			double height, double depth) {
		super(x, y, z, depth);
		setWidth(width);
		setHeight(height);
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
		return 0; // Rectangle
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
