package aoc_2024;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String input = Files.readString(Path.of("input.txt"));
			String[] inputLines = input.split("\n");
			
			Safety saf = new Safety(inputLines);
			saf.toInt();
			System.out.println("Part Two: " + saf.getCount());
			
			List<Integer> test = new ArrayList<Integer>();
			test.add(8);
			test.add(6);
			test.add(4);
			test.add(4);
			test.add(1);

			
			
			//saf.countIfSafeTwo(test);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
