package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Distance {
	
	List<Integer> numListLeft = new ArrayList<Integer>();
	List<Integer> numListRight = new ArrayList<Integer>();
	List<String> temp = new ArrayList<String>();
	//
	int sumDistance = 0;
	
	
	String[] listStr;
	
	public void numToList(String list) {
		listStr= list.split("\n"); // agarra el string y lo divide en renglones.
		
		//a
		temp = this.separeInTwo(listStr, 0);
		numListLeft = this.strToNum(temp);
		temp = this.separeInTwo(listStr, 1);
		numListRight = this.strToNum(temp);
		
		Collections.sort(numListLeft);
		Collections.sort(numListRight);
		
		
		// SEGUNDA PARTE
		
		System.out.println("Part two: " +numAppearSum());

		

		//PRIMERA PARTE
		
		for(int num : this.distaceElements()) {
			sumDistance = sumDistance + num;
		}

		System.out.println("Part One: " + sumDistance);
	}
	
	//LISTAS SEGUNDA PARTE
	public long numAppearSum() {
		long sum = 0;
		
		for(int n = 0; n < numListLeft.size(); n++) {
			
			int count = 0;
			
			//System.out.println("n " + numListLeft.get(n) + "sum: " +sum);
			
			for(int i = 0; i < numListRight.size(); i++) {
				
				if(numListLeft.get(n).equals(numListRight.get(i))) {
					//System.out.println( "i " + numListRight.get(i) + "count: "+ count);
					count++;
				}				
			}
			
			sum = sum + (numListLeft.get(n) * count);
		}
	
		
		return sum;
	}
	
	
	
	
	

	// LISTAS PRIMERA PARTE
	private List<Integer> distaceElements() {
		List<Integer> distance = new ArrayList<Integer>();
		
		for(int num = 0 ; num < numListLeft.size() ; num++) {
			int numD = Math.abs(numListLeft.get(num) - numListRight.get(num));
			distance.add(numD);
		}
			
		return distance;
	}



	
	
	
	// ARREGLO DE LISTAS
	private List<Integer> strToNum(List<String> strList) {
		/* Pasa cada elemento de una listaString a un Integer y lo pone dentro de una lista tipo int */
		List<Integer> numList = new ArrayList<Integer>();
		
		for(String str : strList) {
			numList.add(Integer.parseInt(str));
		}
		
		return numList;
	}

	
	
	public List<String> separeInTwo(String[] listLine, int index) {
		/*	Separa cada linea en dos index de una lista.
		 * "10   13" = 10,13
		 * "10   40" = 10,40
		 * etc...
		 * y agarra el index pedido y lo mete en la lista a retornar. */
		List<String> list = new ArrayList<String>();
		
		
		for(String n : listLine) {
			String[] l = n.split("   ");
			list.addAll(Arrays.asList(l[index]));
		}

		
		return list;

	}
	
	public void print(List<Integer> list) {
		for(int n : list) {
			System.out.println(n);
		}
	}

	
}
