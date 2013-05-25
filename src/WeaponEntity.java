import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class WeaponEntity extends Entity {
	private int weaponType;
	private Image itemIcon;
//	private Image itemRenderPicture;
	
	private double hitbox_xdiff;
	private double hitbox_ydiff;
	private double hitbox_width;
	private double hitbox_height;
	private double hitbox_depth;
	
	private double graspX;
	private double graspY;
	
	private int weaponDepth = 1;
	private boolean gotOwner = false;
	
	public WeaponEntity(double xPosition, double yPosition, double zPosition, Equipment weapon) {
		super(xPosition, yPosition, zPosition);
		
		this.weaponType = weapon.getStat_Type();
		this.itemIcon = weapon.getItemIcon();
//		this.itemRenderPicture = weapon.getItemRenderPicture();
		
		this.hitbox_xdiff = weapon.getHitbox_xdiff();
		this.hitbox_ydiff = weapon.getHitbox_ydiff();
		this.hitbox_width = weapon.getHitbox_width();
		this.hitbox_height = weapon.getHitbox_height();
		this.hitbox_depth = weapon.getHitbox_depth();
		
		this.graspX = weapon.getWearPosX();
		this.graspY = weapon.getWearPosY();
		
		addHitbox(new RectangleHitbox(this, this.hitbox_xdiff, this.hitbox_ydiff, this.hitbox_width, this.hitbox_height, this.hitbox_depth));
		setSprite("res/" +weapon.getItemName() + ".png");
	}
	
	@Override
	protected void updateSpeed() {
		// TODO Auto-generated method stub
		// 
	}
}
