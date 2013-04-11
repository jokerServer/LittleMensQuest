
public abstract class Ability {
	private int id;
	private String name;
	
	protected Ability(int id, String name) {
		setId(id);
		setName(name);
	}
	
	public abstract boolean cast(Entity target);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
