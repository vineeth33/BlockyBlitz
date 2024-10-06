package com.tools.animations;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Animation {
	
	public static final String IDLE = "IDLE";
	public static final String DESTROY = "DESTROY";
	public static final String JUMP = "JUMP";
	
	
	private ArrayList<int[]> sizes;
	private ArrayList<Image> images;
	
	public Animation(String[] urls, int[][] sizes) {
		this.sizes = new ArrayList<>();
		this.images = new ArrayList<>();
		
		for(int i = 0; i < urls.length; i++) {
			// create image icon
			try {
				
				ImageIcon icon = new ImageIcon(urls[i]);
				if(i < sizes.length) {
					this.sizes.add(new int[]{sizes[i][0], sizes[i][1]});
				}
				else {
					this.sizes.add(new int[] {icon.getIconWidth(), icon.getIconHeight()});
				}
				
				// Create Image
				Image image = icon.getImage().getScaledInstance(this.sizes.get(i)[0], this.sizes.get(i)[1], 0);
				images.add(image);

			}
			catch(Exception e){
				System.out.println("Not found" + urls[i]);
			}
		}
	}
	
	public Animation(String[] urls) {
		this(urls, new int[][] {});
	}
	
	public Image getImage(int index) {
		return images.get(index);
	}
	
	public int spriteCount() {
		return images.size();
	}
	
	public void destroy() {
		sizes.clear();
		images.clear();
	}
}
