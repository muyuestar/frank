package com.frank.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
* @author kst  
* @date 2019-02-01 09:00:29
* ����A�ļ�����д�뵽B�ļ�
*/
public class TestFileInputStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\kst\\1.txt");
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\kst\\2.txt",true);
			byte[] buffer = new byte[2048];
			int length = 0;
			while((length = fis.read(buffer))>0){
				fos.write(buffer, 0, length);
			}
			fos.flush();
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
				
	}
}
