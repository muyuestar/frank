package com.frank.test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * ����Ҫ���½�һ��600*600���ص�Ӧ�ó��򴰿ڣ����ڴ����л���5����ͬ��ɫ��ͬ��Բ������Բ�Ķ�����Ļ�����ĵ㣬��������Բֱ�ӵİ뾶���50����
 * 
 * @author kst
 *
 */
public class ConcentricCircles extends JFrame {

	int red, green, blue;
	Color color;

	public ConcentricCircles() {
		super("һ����5����ͬ��ɫ��ͬ��Բ"); // ��ʾ��������
		setSize(600, 600); // ���ô��ڴ�С
		setVisible(true); // ����Ϊ�ɼ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô��ڹرն���
	}

	public void paint(Graphics g) {
		// ��һ��Բ
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(175, 175, 250, 250);
		// �ڶ���Բ
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(200, 200, 200, 200);
		// ������Բ
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(225, 225, 150, 150);
		// ���ĸ�Բ
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(250, 250, 100, 100);
		// �����Բ
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(275, 275, 50, 50);

	}

	public static void main(String[] args) {
		ConcentricCircles cc = new ConcentricCircles();
	}
}
