/**
 * 
 */
package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author yuxiang
 * 
 */
public class TestFileIO {

	public static void main(String[] args) {
		Reader in;
		FileOutputStream out;
		int tem;
		String content = "";
		try {
			in = new InputStreamReader(new FileInputStream("e://123.txt"));
			out = new FileOutputStream("e://321.txt");
			while ((tem = in.read()) != -1) {
				if ((char)tem != '\r') {
					content += (char)tem;
				}
			}
			System.out.println(content);
			in.close();
			byte[] contentInBytes = content.getBytes();
			out.write(contentInBytes);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileInputStream in2;
		try {
			in2 = new FileInputStream("e://321.txt");
			int tem2;
			String content2 = "";
			while (( tem2 = in2.read()) != -1) {
				if ((char)tem2 != '\r') {
					content2 += (char)tem2;
					
				}
			}
			System.out.println(content2);
			in2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
