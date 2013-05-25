public abstract class Ability {
	private int id;
	private String name;
	private Equipment source;
	
	protected Ability(int id, String name, Equipment weapon) {
		setId(id);
		setName(name);
		setSource(weapon);
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

	public Equipment getSource() {
		return source;
	}

	public void setSource(Equipment weapon) {
		this.source = weapon;
	}

}
