package com.frank.test;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * 编写一个Applet的小程序，准备5幅图片和三个音乐文件，绘制到Applet中，并增加几个按钮，控制图片的切换、放大、缩小和音乐文件的播放。
 * 
 * @author kst 未实现
 *
 */
public class PlayImgAndMusic extends Applet implements ActionListener, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 创建三个面板
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	// 声音对象
	AudioClip[] sound = new AudioClip[3];
	int playingSong = 0;
	// 切换图片的按钮
	JButton lastPic = new JButton("上一张");
	JButton setLarge = new JButton("放大");
	JButton setLittle = new JButton("缩小");
	JButton nextPic = new JButton("下一张");
	// 切换歌曲的按钮
	JButton lastSound = new JButton("上一首");
	JButton play = new JButton("播放");
	JButton loop = new JButton("连续");
	JButton stop = new JButton("停止");
	JButton nextSound = new JButton("下一首");
	// 曲目下拉列表
	@SuppressWarnings("rawtypes")
	JComboBox xx;
	String[] names = { "曲目1.wav", "曲目2.wav", "曲目3.wav" };
	// 创建画布对象
	MyCanvasl showPhotos;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void init() {
		// 窗口布局
		this.setLayout(new BorderLayout());
		// 为图片控制按钮注册监听器
		lastPic.addActionListener(this);
		setLarge.addActionListener(this);
		setLittle.addActionListener(this);
		nextPic.addActionListener(this);
		// 向面板p1添加组件
		p1.add(lastPic);
		p1.add(setLarge);
		p1.add(setLittle);
		p1.add(nextPic);
		p1.repaint();
		// 实例化下拉列表对象
		xx = new JComboBox(names);
		xx.addItemListener(this);
		// 为控制播放音乐按钮注册监听器
		lastSound.addActionListener(this);
		play.addActionListener(this);
		loop.addActionListener(this);
		stop.addActionListener(this);
		nextSound.addActionListener(this);
		for (int i = 0; i < 3; i++) {
			sound[i] = getAudioClip(getCodeBase(), "music/" + "曲目" + Integer.toString(i + 1) + ".wav");
		}
		// 向面板p2添加组件
		p2.add(xx);
		p2.add(lastSound);
		p2.add(play);
		p2.add(loop);
		p2.add(stop);
		p2.add(nextSound);
		p2.repaint();
		showPhotos = new MyCanvasl();
		p3.add(showPhotos);
		p3.repaint();
		// 把面板p1和p2分别布置到窗口的北部和南部
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.CENTER);
		this.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		sound[playingSong].stop();
		sound[playingSong] = getAudioClip(getCodeBase(), "music/" + xx.getSelectedItem());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lastPic) {
			showPhotos.changePhotoShow('P');
		} else if (e.getSource() == nextPic) {
			showPhotos.changePhotoShow('N');
		} else if (e.getSource() == setLarge) {
			showPhotos.changePhotoSize('B');
		} else if (e.getSource() == setLittle) {
			showPhotos.changePhotoSize('S');
		} else if (e.getSource() == lastSound) { // 上一首
			sound[playingSong].stop();
			playingSong = (playingSong - 1 + 3) % 3;
			xx.setSelectedIndex(playingSong);
			sound[playingSong].play();
		} else if (e.getSource() == play) { // 按下播放按钮
			sound[playingSong].play();
		} else if (e.getSource() == loop) { // 按下循环按钮
			sound[playingSong].loop();
		} else if (e.getSource() == stop) { // 按下停止按钮
			sound[playingSong].stop();
		} else { // 下一首
			sound[playingSong].stop();
			playingSong = (playingSong + 1) % 3;
			xx.setSelectedIndex(playingSong);
			sound[playingSong].play();
		}
	}

	@SuppressWarnings("serial")
	class MyCanvasl extends Canvas {
		public Image[] img = new Image[5];

		int MaxWidth = 600;
		int MaxHeight = 500;
		int nowImageIndex = 0;
		int coordinateX = 0;
		int coordinateY = 0;
		int currentWidth = MaxWidth;
		int currentHeight = MaxHeight;

		MyCanvasl() {
			setSize(MaxWidth, MaxHeight);
			// 获取当前目录下的图片
			for (int i = 0; i < 5; i++) {
				img[i] = getImage(getCodeBase(), "image/" + Integer.toString(i + 1) + ".jpg");
			}
		}

		private void changePhotoIndex(int index) {
			nowImageIndex = index;
			changePhotoSize('M');
		}

		public void changePhotoShow(char command) {
			if ('P' == command) {
				changePhotoIndex((nowImageIndex + 5 - 1) % 5);
			} else if ('N' == command) {
				changePhotoIndex((nowImageIndex + 1) % 5);
			}
		}

		public void changePhotoSize(char command) {
			if ('M' == command) {
				currentWidth = MaxWidth;
				currentHeight = MaxHeight;
			} else if ('B' == command) {
				if (MaxWidth >= (currentWidth + 100) && MaxHeight >= (currentHeight + 100)) {
					currentWidth += 100;
					currentHeight += 100;
				}
			} else if ('S' == command) {
				if ((0 < (currentWidth - 100)) && (0 < (currentHeight - 100))) {
					currentWidth = currentWidth - 100;
					currentHeight = currentHeight - 100;
				}
			}
			coordinateX = (MaxWidth - currentWidth) / 2;
			coordinateY = (MaxHeight - currentHeight) / 2;
			repaint();
		}

		// paint方法用来在窗口显示图片
		public void paint(Graphics g) {
			g.drawImage(img[nowImageIndex], coordinateX, coordinateY, currentWidth, currentHeight, this);

		}
	}
}
