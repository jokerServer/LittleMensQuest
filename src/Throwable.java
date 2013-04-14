import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Throwable extends Entity{
	private double weight;
	private Image image;
	private double throwStartSpeed;
	private long tossStart;
	private double tossStrength;
	private boolean throwing;
	
	public Throwable(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void updateSpeed() {
		if (throwing) {
			if (getyPosition()>0) {
				setySpeed(tossStrength - 0.00981 * (System.currentTimeMillis() - tossStart));
			} else if (getyPosition()<=0 && getySpeed() <= 0) {
				setySpeed(0);
				throwing=false;
				// TODO Abstand zum Boden beachten
			}
		}
	}
	
	@Override
	public boolean checkForCollision(Entity e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void toss(int direction, int tossStrength) {
		this.tossStrength = tossStrength;
		throwing = true;
		tossStart = System.currentTimeMillis();
		if (direction==1) { // Links
			setxSpeed(tossStrength*(-1));
		} else if (direction==2)  { // Rechts
			setxSpeed(tossStrength);
		}
		setySpeed(tossStrength);
	}

	@Override
	public boolean checkForCollision(Rectangle rect, double zPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForCollision(double xPosition, double yPosition,
			double zPosition, double radius) {
		// TODO Auto-generated method stub
		return false;
	}
}
