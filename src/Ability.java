public abstract class Ability {
	private int id;
	private String name;
	private Entity source;
	
	protected Ability(int id, String name, Entity source) {
		setId(id);
		setName(name);
		setSource(source);
	}
	
	public abstract boolean cast(Entity target);

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Entity getSource() {
		return source;
	}

	public void setSource(Entity source) {
		this.source = source;
	}

}
