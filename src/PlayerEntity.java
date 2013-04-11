import java.util.ArrayList;

public class PlayerEntity extends Entity {

	public enum State {
		CROUCHING, JUMPING, RUNNING_LEFT, RUNNING_RIGHT, SPRINTING_LEFT, SPRINTING_RIGHT, MOVING_FORWARD, MOVING_BACKWARD;
	}

	private int health;
	private boolean turningLeft;
	private boolean turningRight;
	private boolean sprinting;
	private boolean jumping;
	public ArrayList<State> state;

	public PlayerEntity(double xPosition, double yPosition, double zPosition) {
		super(xPosition, yPosition, zPosition);
		// TODO Auto-generated constructor stub
	}

	public void jump() {

	}

	@Override
	public boolean checkForCollision(Entity e) {
		// TODO Add collision detection
		return false;
	}

	@Override
	protected void updatePosition(double timeElapsed) {
		if (state.contains(State.RUNNING_LEFT)) {
			move(Direction.LEFT, 0.1 * timeElapsed);
		} else if (state.contains(State.RUNNING_RIGHT)) {
			move(Direction.RIGHT, 0.1 * timeElapsed);
		} else if (state.contains(State.SPRINTING_LEFT)) {
			move(Direction.LEFT, 0.3 * timeElapsed);
		} else if (state.contains(State.SPRINTING_RIGHT)) {
			move(Direction.RIGHT, 0.3 * timeElapsed);
		}
	}

}
