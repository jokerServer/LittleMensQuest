import java.awt.Image;

public class Throwable extends Entity{
	public Throwable(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		// TODO Auto-generated constructor stub
	}
	private double fancyWeight;
	private Image fancyIcon;
	@Override
	protected void updateSpeed() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean checkForCollision(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}
}
