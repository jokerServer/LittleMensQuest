import java.awt.Image;

public abstract class Item {
	private int itemID;
	private String itemName;
	private Image itemIcon; 
	private Image itemRenderPicture;
	
	public int getItemID() {
		return itemID;
	}
	private void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	private void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Image getItemIcon() {
		return itemIcon;
	}
	private void setItemIcon(Image itemIcon) {
		this.itemIcon = itemIcon;
	}
	public Image getItemRenderPicture() {
		return itemRenderPicture;
	}
	private void setItemRenderPicture(Image itemRenderPicture) {
		this.itemRenderPicture = itemRenderPicture;
	}
	
	
}
