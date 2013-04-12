import java.util.ArrayList;

public class LittleMensQuest {
	public static final int ticksPerSecond = 60;

	public static void main(String args[]) {
		new LittleMensQuest();
	}

	public LittleMensQuest() {
		long loopBegin;
		long lastUpdate = System.currentTimeMillis();
		while (true) {
			loopBegin = System.currentTimeMillis();
			update(System.currentTimeMillis() - lastUpdate);
			lastUpdate = System.currentTimeMillis();
			render();
			try {
				Thread.sleep(Math.max(1 / ticksPerSecond * 1000 - (loopBegin - System.currentTimeMillis()), 0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void update(long timeElapsed) {
		ArrayList<Entity> entitys = Entity.getEntitys();
		for (int i = 0; i < entitys.size(); i++){
			entitys.get(i).update(timeElapsed);
		}
	}

	private void render() {

	}
}
