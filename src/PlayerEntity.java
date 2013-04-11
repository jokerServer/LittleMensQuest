
public class PlayerEntity extends Entity {

	private int health;
	private boolean turningLeft;
	private boolean turningRight;
	private boolean sprinting;
	private boolean jumping;
	
	public PlayerEntity(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		// TODO Auto-generated constructor stub
	}
	
	public void jump(){
		
	}

	@Override
	public boolean checkForCollision(Entity e) {
		// TODO Add collision detection
		return false;
	}

	@Override
	protected void updatePosition(double timeElapsed) {
		if (turningLeft){
			
		} else if (turningRight){
			
		}
	}
	

}
