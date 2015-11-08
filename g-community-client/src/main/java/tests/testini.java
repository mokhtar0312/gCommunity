package tests;

import java.util.Random;

public class testini {

	public static void main(String[] args) {
		Random ran = new Random();
		int top = 10;
		char data = ' ';
		String dat = "";

		for (int i=0; i<top; i++) {
		  data = (char)(ran.nextInt(25)+97);
		  dat = data + dat;
		}

		System.out.println(dat);
	}
}
