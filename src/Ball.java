
public class Ball extends Throwable {
	private double hitbox_xdiff = -0.125;
	private double hitbox_ydiff = 0.125;
	private double hitbox_radius = 0.125;
	private double hitbox_depth = 1;
	
	public Ball(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		
		setHitbox_xdiff(hitbox_xdiff);
		setHitbox_ydiff(hitbox_ydiff);
		setHitbox_radius(hitbox_radius);
		setHitbox_depth(hitbox_depth);
		addHitbox(new CircleHitbox(this, -0.125, 0.125, 0.125, 1));
		setSprite("res/ball.png");
		// toss(2, 4);
	}
	
	// TODO do dat in throwable class
}
