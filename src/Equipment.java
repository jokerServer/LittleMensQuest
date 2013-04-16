import java.awt.Image;

public abstract class Equipment extends Item {
	private int stat_Dmg;
	private int stat_MagicDmg;
	private double stat_atkSpeed;
	
	private int stat_Armor;
	private int stat_MagicResistance;
	
	private int stat_Type; // zB (!!!) 0 = Blau ; 1 = Einhänder ; 2 = Zweihänder ; 3 = Dolch ; 4 = Zauberstab; 
	
	private int emt_Dmg; 		// emt = EnchantMenT //
	private int emt_MagicDmg;
	private int emt_atkSpeedBonus;
	private int emt_Armor;
	private int emt_MagicResistance;
	private int emt_LP;
	private int emt_MP;
	private double emt_Lifereg;
	private double emt_Manareg;
	private int emt_vitality; 	// Life
	private int emt_strenght;	// Melee Dmg +	// Melee Physical Skills Dmg+
	private int emt_magic;		// MagicDmg +	// Magical Skill Dmg+
	private int emt_agility;	// Attackspeed+ // Ranged/Assassins Physical Skills Dmg+
	
	private double hitbox_xdiff = 0.15;
	private double hitbox_ydiff = 0.4;
	private double hitbox_width = 0.3;
	private double hitbox_height = 0.8;
	private double hitbox_depth = 1;
	// TODO loadStats(itemID)
	// TODO customize setter
	
	// TODO recalcStats() (PlayerEntity?)
	// TODO Player Tabelle 
	// TODO Inventory Tabelle
	
	// setters
	
	protected void setStat_Dmg(int stat_Dmg) {
		this.stat_Dmg = stat_Dmg;
	}
	protected void setStat_MagicDmg(int stat_MagicDmg) {
		this.stat_MagicDmg = stat_MagicDmg;
	}
	protected void setStat_atkSpeed(double stat_atkSpeed) {
		this.stat_atkSpeed = stat_atkSpeed;
	}
	protected void setStat_Type(int stat_weaponType) {
		this.stat_Type = stat_weaponType;
	}
	protected void setEmt_Dmg(int emt_Dmg) {
		this.emt_Dmg = emt_Dmg;
	}
	protected void setEmt_MagicDmg(int emt_MagicDmg) {
		this.emt_MagicDmg = emt_MagicDmg;
	}
	protected void setEmt_atkSpeed(int emt_atkSpeed) {
		this.emt_atkSpeedBonus = emt_atkSpeed;
	}
	protected void setEmt_Armor(int emt_Armor) {
		this.emt_Armor = emt_Armor;
	}
	protected void setEmt_MagicResistance(int emt_MagicResistance) {
		this.emt_MagicResistance = emt_MagicResistance;
	}
	protected void setEmt_LP(int emt_LP) {
		this.emt_LP = emt_LP;
	}
	protected void setEmt_MP(int emt_MP) {
		this.emt_MP = emt_MP;
	}
	protected void setEmt_Lifereg(int emt_Lifereg) {
		this.emt_Lifereg = emt_Lifereg;
	}
	protected void setEmt_Manareg(int emt_Manareg) {
		this.emt_Manareg = emt_Manareg;
	}
	protected void setEmt_vitality(int emt_vitality) {
		this.emt_vitality = emt_vitality;
	}
	protected void setEmt_strenght(int emt_strenght) {
		this.emt_strenght = emt_strenght;
	}
	protected void setEmt_magic(int emt_magic) {
		this.emt_magic = emt_magic;
	}
	protected void setEmt_agility(int emt_agility) {
		this.emt_agility = emt_agility;
	}
	
	// Getters
	
	public int getStat_Dmg() {
		return stat_Dmg;
	}
	public int getStat_MagicDmg() {
		return stat_MagicDmg;
	}
	public double getStat_atkSpeed() {
		return stat_atkSpeed;
	}
	public int getStat_Type() {
		return stat_Type;
	}
	public int getEmt_Dmg() {
		return emt_Dmg;
	}
	public int getEmt_MagicDmg() {
		return emt_MagicDmg;
	}
	public int getEmt_atkSpeed() {
		return emt_atkSpeedBonus;
	}
	public int getEmt_Armor() {
		return emt_Armor;
	}
	public int getEmt_MagicResistance() {
		return emt_MagicResistance;
	}
	public int getEmt_LP() {
		return emt_LP;
	}
	public int getEmt_MP() {
		return emt_MP;
	}
	public double getEmt_Lifereg() {
		return emt_Lifereg;
	}
	public double getEmt_Manareg() {
		return emt_Manareg;
	}
	public int getEmt_vitality() {
		return emt_vitality;
	}
	public int getEmt_strenght() {
		return emt_strenght;
	}
	public int getEmt_magic() {
		return emt_magic;
	}
	public int getEmt_agility() {
		return emt_agility;
	}
	public double getHitbox_xdiff() {
		return hitbox_xdiff;
	}
	
	public double getHitbox_ydiff() {
		return hitbox_ydiff;
	}
	
	public double getHitbox_width() {
		return hitbox_width;
	}
	
	public double getHitbox_height() {
		return hitbox_height;
	}
	
	public double getHitbox_depth() {
		return hitbox_depth;
	}
}
