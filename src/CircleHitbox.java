
public class CircleHitbox extends Hitbox {
	private double x;
	private double y;
	private double z;
	private double radius;
	private double depth;
	
	public CircleHitbox(double x, double y, double z, double radius, double depth) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
		this.depth = depth;
	}

	@Override
	public boolean intersects(Hitbox hb) {
		return false;
	}

	@Override
	public int getShape() {
		return 1; //Cirlce
	}

}
