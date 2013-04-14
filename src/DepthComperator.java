import java.util.Comparator;


public class DepthComperator implements Comparator<Entity> {

    @Override
    public int compare(Entity e1, Entity e2) {
    	return (e2.getzPosition() - e1.getzPosition() < 0) ? -1 : 1;
    }

}
