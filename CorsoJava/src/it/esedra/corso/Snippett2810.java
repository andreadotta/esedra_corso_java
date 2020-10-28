package it.esedra.corso;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Snippett2810 {

	public Snippett2810() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Snippett2810 sn = new Snippett2810();
		try {
			assert 0 > 1;
			//sn.cat(new File("/tmp/test"));			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("ciao");

	}
	public static void cat(File file) throws IOException {
		RandomAccessFile input = null;
		String line = null;

		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
				if (input != null) {
					input.close();
				}
		}
	}
	
}
