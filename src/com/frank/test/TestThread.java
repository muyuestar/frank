package com.frank.test;

/**
 * ���Զ��߳�
 * 
 * @author kst
 * @date 2018-12-03 18:51:32
 */
public class TestThread {

	public static void main(String[] args) {
		// ʵ����վ̨���󣬲�Ϊÿһ��վ̨ȡ����
		Station station1 = new Station("����1");
		Station station2 = new Station("����2");
		Station station3 = new Station("����3");

		// ��ÿһ��վ̨������Կ�ʼ����
		station1.start();
		station2.start();
		station3.start();
	}
}

class Station extends Thread {
	// ͨ�����췽�����߳����ָ�ֵ
	public Station(String name) {
		super(name);// ���߳����ָ�ֵ
	}

	// Ϊ�˱���Ʊ����һ�£�Ʊ��Ҫ��̬
	static int tick = 20;
	// ����һ����̬Կ��
	static Object ob = "aa";// ֵ�������
	// ��дrun������ʵ����Ʊ����

	@Override
	public void run() {
		while (tick > 0) {
			synchronized (ob) {// �������Ҫ������ʹ��һ������
				// ��ȥ���˻��Կ���������ϣ�������Ű�Կ�����ó���
				if (tick > 0) {
					System.out.println(getName() + "�����˵�" + tick + "��Ʊ");
					tick--;
				} else {
					System.out.println("Ʊ������");
				}
			}
			try {
				sleep(1000);// ��Ϣһ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}