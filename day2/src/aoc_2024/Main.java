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
			System.out.println("Part One: " + saf.getCount());
			
			List<Integer> test = new ArrayList<Integer>();
			test.add(10);
			test.add(7);
			test.add(5);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
