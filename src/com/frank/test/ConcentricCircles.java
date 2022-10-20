package com.frank.test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * 程序要求：新建一个600*600像素的应用程序窗口，并在窗口中绘制5个不同颜色的同心圆，所有圆心都是屏幕的中心点，相邻两个圆直接的半径相差50像素
 * 
 * @author kst
 *
 */
public class ConcentricCircles extends JFrame {

	int red, green, blue;
	Color color;

	public ConcentricCircles() {
		super("一个有5个不同颜色的同心圆"); // 显示窗口名称
		setSize(600, 600); // 设置窗口大小
		setVisible(true); // 设置为可见
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口关闭动作
	}

	public void paint(Graphics g) {
		// 第一个圆
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(175, 175, 250, 250);
		// 第二个圆
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(200, 200, 200, 200);
		// 第三个圆
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(225, 225, 150, 150);
		// 第四个圆
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(250, 250, 100, 100);
		// 第五个圆
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
