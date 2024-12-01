package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DistanceNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Distance dist = new Distance();
		
		try {
			String input = Files.readString(Path.of("input.txt"));
			
			dist.numToList(input);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
