import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	protected void setItemIcon(String path) {
		try {
			this.itemRenderPicture = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Image getItemRenderPicture() {
		return itemRenderPicture;
	}
	protected void setItemRenderPicture(String path) {
		try {
			this.itemRenderPicture = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
