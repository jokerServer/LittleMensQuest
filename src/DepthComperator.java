import java.util.Comparator;


public class DepthComperator implements Comparator<Entity> {

    @Override
    public int compare(Entity e1, Entity e2) {
    	return (int) (e1.getzPosition() - e2.getzPosition());
    }

}
