package aoc_2024.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day3 {

	public static void main(String[] args) throws IOException {
		
		
		
		String input = Files.readString(Path.of("inputday3.txt"));
		String inputTest = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
		
		String inputCurr = input;
		
		Pattern patt = Pattern.compile("mul\\((\\d{1,3})\\,(\\d{1,3})\\)");
		Pattern doMul = Pattern.compile("do\\(\\)\\p{Graph}*?" + patt);
		Pattern dontMul = Pattern.compile("don't\\(\\)\\p{Graph}*?" + patt);
		
		
		Matcher matMul = patt.matcher(inputCurr);
		Matcher matDo = doMul.matcher(inputCurr);
		Matcher matDont = dontMul.matcher(inputCurr);
		
		Matcher estado = matMul;
		
				
		String str = "";
		long count = 0;
		
		System.out.println("Part 1" + partOne(inputCurr));
		System.out.println("Part 2: " + partTwo(inputCurr));
		
		
	}
	
	public static long partOne(String input) {
		Pattern patt = Pattern.compile("mul\\((\\d{1,3})\\,(\\d{1,3})\\)");
		Matcher matMul = patt.matcher(input);
		long count = 0;
		while(matMul.find()) {

			
			long a = Long.parseLong(matMul.group(1));
			long b = Long.parseLong(matMul.group(2));
		//	System.out.println("MUL: " + a + " * " + b);
			
			count = count + (a * b);
		}
		return count;
	}
	
	public static long partTwo(String input) {

		Pattern dontMul = Pattern.compile("don't\\(\\).*?do\\(\\)");
		
		for(String s :dontMul.split(input) ) {
			System.out.println(s);
		}
		
		return partOne(String.join("", dontMul.split(input)));


	}

}
