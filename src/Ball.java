import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball extends Throwable {
	public Image ballSprite;
	private double hitbox_xdiff = -0.125;
	private double hitbox_ydiff = 0.125;
	private double hitbox_radius = 0.125;
	private double hitbox_depth = 1;
	
	public Ball(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		try {
			ballSprite = ImageIO.read(new File("res/ball.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setImage(ballSprite);
		setHitbox_xdiff(hitbox_xdiff);
		setHitbox_ydiff(hitbox_ydiff);
		setHitbox_radius(hitbox_radius);
		setHitbox_depth(hitbox_depth);
		// toss(2, 4);
	}
	
	// TODO do dat in throwable class
}
