package com.frank.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

/**
 * ����88�����1000�������ݵ�MySQL���ݿ��
 * 
 * @author kst
 * @date 2018-11-21 20:43:10
 */
public class TestInsertMysqlBigData {

	private static final String url = "jdbc:mysql://127.0.0.1/test_db";
	private static final String name = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "123456";

	public static void main(String[] args) throws Exception {
		Class.forName(name); // ָ����������
		Connection conn = DriverManager.getConnection(url, user, password);
		// ��ȡ����
		if (conn == null) {
			System.out.println("��ȡ����ʧ��");
			return;
		}
		System.out.println("��ȡ���ӳɹ�");
		insert(conn);
	}

	public static void insert(Connection conn) {
		// ��ʼʱ��
		Long begin = new Date().getTime();
		// sqlǰ׺
		String prefix = "insert into t_teacher (id,t_name,t_password,sex,description,pic_url,school_name,regist_date,remark) values ";
		try {
			// ����sql��׺
			StringBuffer suffix = new StringBuffer();
			// ��������Ϊ���Զ��ύ
			conn.setAutoCommit(false);
			// ����st��pst�����Щ
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(""); // ׼��ִ�����
			// ���ѭ�������ύ�������
			for (int i = 1; i <= 100; i++) {
				suffix = new StringBuffer();
				// ��j���ύ����
				for (int j = 1; j <= 100000; j++) {
					// ����SQL��׺
					suffix.append("('" + TestInsertMysqlBigData.getUuid() + "','" + i * j + "','123456'" + ",'��'"
							+ ",'��ʦ'" + ",'www.bbk.com'" + ",'�Ͼ���ѧ'" + ",'" + "2016-08-12 14:43:26" + "','��ע'" + "),");
				}
				// ��������SQL
				String sql = prefix + suffix.substring(0, suffix.length() - 1);
				// ���ִ��SQL
				pst.addBatch(sql);
				// ִ�в���
				pst.executeBatch();
				// �ύ����
				conn.commit();
				// �����һ����ӵ�����
				suffix = new StringBuffer();
			}
			// ͷ������
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ����ʱ��
		Long end = new Date().getTime();
		// ��ʱ
		System.out.println("1000�������ݲ��뻨��ʱ�� : " + (end - begin) / 1000 + " s");
		System.out.println("�������");
	}

	/**
	 * ��ȡuuid
	 * 
	 * @return str
	 */
	private static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
