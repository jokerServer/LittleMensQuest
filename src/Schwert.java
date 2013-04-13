import java.awt.Image;

public class Schwert extends Equipment {
	private Image itemIcon;
	private Image itemRenderPicture;
	public Schwert() {
		setItemID(1000);
		setItemName("Schwert");
		setItemIcon(itemIcon);
		setItemRenderPicture(itemRenderPicture);
		
		setStat_Dmg(10);
		setStat_MagicDmg(0);
		setStat_atkSpeed(0.75);
		
		setStat_Type(1);
	}
}
