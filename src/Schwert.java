public class Schwert extends Equipment {
	private double hitbox_xdiff = -0.15;
	private double hitbox_ydiff = 0.4;
	private double hitbox_width = 0.3;
	private double hitbox_height = 0.8;
	private double hitbox_depth = 1;
	
	public Schwert() {
		setItemID(1000);
		setItemName("Schwert");
		setItemIcon("");
		setItemRenderPicture("res/schwert.png");
		
		setStat_Dmg(10);
		setStat_MagicDmg(0);
		setStat_atkSpeed(0.75);
		
		setStat_Type(1);
		
		setHitbox_xdiff(hitbox_xdiff);
		setHitbox_ydiff(hitbox_ydiff);
		setHitbox_width(hitbox_width);
		setHitbox_height(hitbox_height);
		setHitbox_depth(hitbox_depth);
	}
}
