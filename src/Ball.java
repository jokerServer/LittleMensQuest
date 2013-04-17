import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball extends Throwable {
	public Image ballSprite;
	public Ball(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		try {
			ballSprite = ImageIO.read(new File("res/ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		toss(2, 4);
	}
	
	// TODO do dat in throwable class
	public void drawYourself(Graphics g, Component observer) {
		g.setColor(Color.BLACK);
		int xPosition = (int) (getxPosition() * 100) - ballSprite.getWidth(observer) / 2;
		int yPosition = (int) (getyPosition() * 100)
				+ (int) (getzPosition() * 40)
				+ ballSprite.getHeight(observer) / 2;
		yPosition = observer.getSize().height - yPosition;
		g.drawImage(ballSprite, xPosition, yPosition, observer);
		g.setColor(Color.BLUE);
		g.drawString("x: " + getxPosition(), xPosition, yPosition - 15);
		g.drawString("y: " + getyPosition(), xPosition, yPosition);
		g.drawString("z: " + getzPosition(), xPosition, yPosition + 15);
		getHitbox().show(g, observer);
	}
}
