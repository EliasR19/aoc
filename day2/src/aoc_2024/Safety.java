package aoc_2024;

import java.util.ArrayList;
import java.util.List;

public class Safety {
	int count = 0;
	String[] input;
	List<Integer> lineInt = new ArrayList<Integer>();
	
	public Safety(String[] list) {
		input = list;
	}
	
	public void toInt() {
		for(String line : input) {
			
			String[] numsLine = line.split("\s");
			
			for(String numLine : numsLine) {
				int num = Integer.parseInt(numLine);
				lineInt.add(num);
				
			}		
			
			this.countIfSafe(lineInt);
			lineInt.removeAll(lineInt);
			
			
		}

		
	}
	
	
	public void countIfSafe(List<Integer> numsLines) {
	
		if(this.increasOrDecreas(numsLines) && this.lessThan3(numsLines)) {
			this.count();
		}
		System.out.println(count);
		
	}
	
	private boolean lessThan3(List<Integer> numsLines) {
		int temp = numsLines.get(0);
		for(int n = 1; n < numsLines.size() ; n++) {
			//System.out.println("temp: " + temp + " curr: " + numsLines.get(n));
			if(Math.abs(numsLines.get(n) - temp) < 1 || Math.abs(numsLines.get(n) - temp) > 3) {
				System.out.println("aca");
				return false;
			}
			temp = numsLines.get(n);
		}
		return true;
	}
	
	private boolean increasOrDecreas(List<Integer> numsLines) {
		if(this.listIncreast(numsLines) || this.listDecreast(numsLines)) {
			return true;
		}
		return false;
	}

	private boolean listIncreast(List<Integer> numsLines) {
		
		int temp = numsLines.get(0);
		
		for(int n = 1; n < numsLines.size(); n++) {
		
			if(temp >= numsLines.get(n)) {
				return false;
			}
			
			temp = numsLines.get(n);
		}
		
		return true;
	}
	
	public int getCount() {
		return count;
	}


	
	
	private boolean listDecreast(List<Integer> numsLines) {
		int temp = numsLines.get(0);
		
		for(int n = 1; n < numsLines.size(); n++) {
		
			if(temp <= numsLines.get(n)) {
				return false;
			}
			
			temp = numsLines.get(n);
		}
		
		return true;
	}

	public void count() {
		count++;
	}
	

	public void printListInt(List<Integer> list) {
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println("\n");
	}
	public void printListStr(String[] list) {
		for (String s : list) {
			System.out.print(s + " ");
		}
		System.out.println("\n");
	}
	
}
