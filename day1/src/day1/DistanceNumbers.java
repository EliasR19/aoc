package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class DistanceNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		try {
			String input = Files.readString(Path.of("input.txt"));
			
			gestorInput gestor = new gestorInput(input);
			
			Distance dist = new Distance(gestor);
			AppearsNum numAppears = new AppearsNum(gestor);
			
			System.out.println("Part One: " + dist.sumDist());
			System.out.println("Part Two: " + numAppears.numAppearSum());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

}
