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
		String inputTest = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
		
		String inputCurr = input;
		
		Pattern patt = Pattern.compile("mul\\(\\d{1,3}\\,\\d{1,3}\\)");
		Pattern doMul = Pattern.compile("do\\(\\)\\p{Graph}*?" + patt);
		Pattern dontMul = Pattern.compile("don't\\(\\)\\p{Graph}*?" + patt);
		
		
		Matcher matMul = patt.matcher(inputCurr);
		Matcher matDo = doMul.matcher(inputCurr);
		Matcher matDont = dontMul.matcher(inputCurr);
		
		Matcher estado = matMul;
		
				
		String str = "";
		long count = 0;
		
		while(estado.find()) {

			str = inputCurr.substring(estado.start(), estado.end());
			System.out.println("str: " + str + " |Start: " + estado.start() + " |End: " + estado.end());
			
			int start = str.length() - 8;
			
			String post = str.substring(start, str.length());

			
			String numsStr = str.replace("mul(", "").replace(")", "");

			String[] numsInt = numsStr.split(",");
			int num1 = Integer.parseInt(numsInt[0]);
			int num2 = Integer.parseInt(numsInt[1]);
			
			//System.out.println("a: " + num1 + " |b: " + num2);
			
			count = count + (num1 * num2);
		}
		
		System.out.println("AlL: " + count);
		System.out.println("dont: " + dont(inputCurr));
		
		
		count = count - dont(inputCurr);
		System.out.println(count);
		
	}
	
	public static long dont(String input) {
		long count = 0;
		Pattern patt = Pattern.compile("mul\\(\\d{1,3}\\,\\d{1,3}\\)");
		Pattern dontMul = Pattern.compile("don't\\(\\)\\p{Graph}*?" + patt);
		Matcher matDont = dontMul.matcher(input);
		
		while(matDont.find()) {

			String str = input.substring(matDont.start(), matDont.end());
			//System.out.println("str: " + str + " |Start: " + matDont.start() + " |End: " + matDont.end());
			
			
			String post = str.replaceAll("don't\\(\\)\\p{Graph}*?", "");
			
			//System.out.println("post: " + post);
			
			String numsStr = post.replaceAll("\\p{Graph}*mul\\(", "").replace(")", "");
//			
			//System.out.println("strNums: " + numsStr);
//
			String[] numsInt = numsStr.split(",");

			int num1 = Integer.parseInt(numsInt[0]);
			int num2 = Integer.parseInt(numsInt[1]);
//			
			//System.out.println("a: " + num1 + " |b: " + num2);
//			
			count = count + (num1 * num2);
			
			
		}
		return count;
	}

}
