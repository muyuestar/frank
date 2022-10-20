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
 * ��дһ��Applet��С����׼��5��ͼƬ�����������ļ������Ƶ�Applet�У������Ӽ�����ť������ͼƬ���л����Ŵ���С�������ļ��Ĳ��š�
 * 
 * @author kst δʵ��
 *
 */
public class PlayImgAndMusic extends Applet implements ActionListener, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �����������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	// ��������
	AudioClip[] sound = new AudioClip[3];
	int playingSong = 0;
	// �л�ͼƬ�İ�ť
	JButton lastPic = new JButton("��һ��");
	JButton setLarge = new JButton("�Ŵ�");
	JButton setLittle = new JButton("��С");
	JButton nextPic = new JButton("��һ��");
	// �л������İ�ť
	JButton lastSound = new JButton("��һ��");
	JButton play = new JButton("����");
	JButton loop = new JButton("����");
	JButton stop = new JButton("ֹͣ");
	JButton nextSound = new JButton("��һ��");
	// ��Ŀ�����б�
	@SuppressWarnings("rawtypes")
	JComboBox xx;
	String[] names = { "��Ŀ1.wav", "��Ŀ2.wav", "��Ŀ3.wav" };
	// ������������
	MyCanvasl showPhotos;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void init() {
		// ���ڲ���
		this.setLayout(new BorderLayout());
		// ΪͼƬ���ư�ťע�������
		lastPic.addActionListener(this);
		setLarge.addActionListener(this);
		setLittle.addActionListener(this);
		nextPic.addActionListener(this);
		// �����p1������
		p1.add(lastPic);
		p1.add(setLarge);
		p1.add(setLittle);
		p1.add(nextPic);
		p1.repaint();
		// ʵ���������б����
		xx = new JComboBox(names);
		xx.addItemListener(this);
		// Ϊ���Ʋ������ְ�ťע�������
		lastSound.addActionListener(this);
		play.addActionListener(this);
		loop.addActionListener(this);
		stop.addActionListener(this);
		nextSound.addActionListener(this);
		for (int i = 0; i < 3; i++) {
			sound[i] = getAudioClip(getCodeBase(), "music/" + "��Ŀ" + Integer.toString(i + 1) + ".wav");
		}
		// �����p2������
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
		// �����p1��p2�ֱ��õ����ڵı������ϲ�
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
		} else if (e.getSource() == lastSound) { // ��һ��
			sound[playingSong].stop();
			playingSong = (playingSong - 1 + 3) % 3;
			xx.setSelectedIndex(playingSong);
			sound[playingSong].play();
		} else if (e.getSource() == play) { // ���²��Ű�ť
			sound[playingSong].play();
		} else if (e.getSource() == loop) { // ����ѭ����ť
			sound[playingSong].loop();
		} else if (e.getSource() == stop) { // ����ֹͣ��ť
			sound[playingSong].stop();
		} else { // ��һ��
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
			// ��ȡ��ǰĿ¼�µ�ͼƬ
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

		// paint���������ڴ�����ʾͼƬ
		public void paint(Graphics g) {
			g.drawImage(img[nowImageIndex], coordinateX, coordinateY, currentWidth, currentHeight, this);

		}
	}
}
