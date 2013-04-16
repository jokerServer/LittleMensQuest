import java.awt.Image;

public abstract class Item {
	private int itemID;
	private String itemName;
	private Image itemIcon; 
	private Image itemRenderPicture;
	
	public int getItemID() {
		return itemID;
	}
	
	protected void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	protected void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Image getItemIcon() {
		return itemIcon;
	}
	protected void setItemIcon(Image itemIcon) {
		this.itemIcon = itemIcon;
	}
	public Image getItemRenderPicture() {
		return itemRenderPicture;
	}
	protected void setItemRenderPicture(Image itemRenderPicture) {
		this.itemRenderPicture = itemRenderPicture;
	}
	
	
}
