import java.awt.Image;

public class Throwable extends Entity{
	private double fancyWeight;
	private Image fancyIcon;
	private double throwStartSpeed;
	private long tossStart;
	private double tossStrength;
	
	public Throwable(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void updateSpeed() {
		setySpeed(tossStrength - 0.00981
				* (System.currentTimeMillis() - tossStart));
	}
	@Override
	public boolean checkForCollision(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void toss(int direction, int tossStrength) {
		this.tossStrength = tossStrength;
		if (direction==1) { // Links
			tossStart = System.currentTimeMillis();
			setxSpeed(tossStrength*(-1));
		} else if (direction==2)  { // Rechts
			tossStart = System.currentTimeMillis();
			setxSpeed(tossStrength);
		}
	}
}
