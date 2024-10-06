package com;

public class Constants {
	public static final String bgURL = "resources/images/com/bg-img.png";
	public static final String floorURL = "resources/images/com/lava-tile.jpg";
	
	public static final String titleURL = "resources/images/com/title.png";
	public static final String playButtonURL = "resources/images/com/play-button.png";
	public static final String helpButtonURL = "resources/images/com/help-button.png";
	
	public static final String[] cubeIdle1 = {"resources/images/cube/cube-1/0.png"};
	public static final String[] cubeIdle2 = {"resources/images/cube/cube-2/0.png"};
	public static final String[] cubeIdle3 = {"resources/images/cube/cube-3/0.png"};
	public static final int[][] cubeIdleSizes = {{43, 45}};
	
	public static final String[] cubeJump1 = {"resources/images/cube/cube-1/0.png", "resources/images/cube/cube-1/1.png", "resources/images/cube/cube-1/2.png", "resources/images/cube/cube-1/3.png", "resources/images/cube/cube-1/2.png", "resources/images/cube/cube-1/1.png", "resources/images/cube/cube-1/0.png"};
	public static final String[] cubeJump2 = {"resources/images/cube/cube-2/0.png", "resources/images/cube/cube-2/1.png", "resources/images/cube/cube-2/2.png", "resources/images/cube/cube-2/3.png", "resources/images/cube/cube-2/2.png", "resources/images/cube/cube-2/1.png", "resources/images/cube/cube-2/0.png"};
	public static final String[] cubeJump3 = {"resources/images/cube/cube-3/0.png", "resources/images/cube/cube-3/1.png", "resources/images/cube/cube-3/2.png", "resources/images/cube/cube-3/3.png", "resources/images/cube/cube-3/2.png", "resources/images/cube/cube-3/1.png", "resources/images/cube/cube-3/0.png"};
	public static final int[][] cubeJumpSizes = {{43, 45}, {39, 50}, {35, 57}, {35, 64}, {35, 57}, {39, 50}, {43, 45}};

	public static final String[] cubeDestroy1 = {"resources/images/cube/cube-1/4.png", "resources/images/cube/cube-1/5.png", "resources/images/cube/cube-1/6.png"};
	public static final String[] cubeDestroy2 = {"resources/images/cube/cube-2/4.png", "resources/images/cube/cube-2/5.png", "resources/images/cube/cube-2/6.png"};
	public static final String[] cubeDestroy3 = {"resources/images/cube/cube-3/4.png", "resources/images/cube/cube-3/5.png", "resources/images/cube/cube-3/6.png"};
	public static final int[][] cubeDestroySizes = {{43, 45}, {43, 45}, {60, 56}};
	
	public static final String[] vLaserIdle1 = {"resources/images/level/laser/1.png", "resources/images/level/laser/2.png", "resources/images/level/laser/3.png", "resources/images/level/laser/4.png"};
	public static final int[][] vLaserIdleSizes = {{20, 90}, {20, 90}, {20, 90}, {20, 90}};
	
	public static final String[] gunIdle = {"resources/images/level/gun/1.png"};
	public static final int[][] gunIdleSizes = {{50, 45}};
	
	public static final String blueBullet = "resources/images/level/gun/bullet-2.png";
	public static final int[] bulletSize = {20, 10};
	
	
	public static final String bgMusicURL = "resources/audios/bg-music.wav";
	
	public static final String highScoreURL = "src/level/highScore.txt";
}
