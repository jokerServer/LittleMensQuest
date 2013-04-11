
public class PlayerEntity extends Entity {
	private int health;
	
	public PlayerEntity(double xPosition, double yPosition) {
		super(xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}
	
	public void jump(){
		
	}

	@Override
	public boolean checkForCollision(Entity e) {
		// TODO Add collision detection
		return false;
	}

}
