
public class RectangleHitbox extends Hitbox {
	private double x;
	private double y;
	private double z;
	private double width;
	private double height;
	private double depth;

	public RectangleHitbox(double x, double y, double z, double width, double height, double depth) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	@Override
	public boolean intersects(Hitbox hb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getShape() {
		return 0; //Rectangle
	}

}
