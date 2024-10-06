package gameObject;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.exception.ImageNotFoundException;
import com.tools.physics.Vector;

public abstract class Visible extends GameObject implements Entity{
	protected ImageIcon icon;
	protected Image image;
	protected boolean isDestroyed = false;
	private Vector<Integer> imgSize;
	
	public Visible(String url, int width, int height) {
		super(width, height);
		imgSize = new Vector<>(width, height);
		setImage(url, width, height);
	}
	
	public Visible(String url, int width, int height, int x, int y) {
		this(url, width, height);
		this.setPosition(x, y);
	}
	
	public int getImgWidth() {
		return this.imgSize.x;
	}
	
	public int getImgHeight() {
		return this.imgSize.y;
	}
	
	public void setImageSize(int imgWidth, int imgHeight) {
		this.imgSize.set(imgWidth, imgHeight);
		this.image = icon.getImage().getScaledInstance(imgWidth, imgHeight, 0);
	}

	public void setImage(String url, int imgWidth, int imgHeight) {
		try {
			this.icon = new ImageIcon(url);
			this.setImageSize(imgWidth, imgHeight);
			if(icon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
				throw new ImageNotFoundException("Source Image not found");
			}
		}
		catch(ImageNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setImage(Image image) {
		this.image = image;
		this.imgSize.set(image.getWidth(null), image.getHeight(null));
	}
	
	public Image getImage() {
		return this.image;
	}
	
	@Override
	public void destroy() {
		super.destroy();
		icon = null;
		image = null;
		imgSize = null;
	}
	
	public abstract void update();
	public abstract void draw(Graphics g);
}
