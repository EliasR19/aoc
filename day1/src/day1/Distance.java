package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Distance {
	
	List<Integer> numListLeft = new ArrayList<Integer>();
	List<Integer> numListRight = new ArrayList<Integer>();
	List<String> temp = new ArrayList<String>();
	
	int sumDistance = 0;
	
	
	String[] listStr;
	
	public void numToList(String list) {
		listStr= list.split("\n"); // agarra el string y lo divide en renglones.
		
		//a
		temp = this.separeInLeft(listStr, 0);
		numListLeft = this.strToNum(temp);
		temp = this.separeInLeft(listStr, 1);
		numListRight = this.strToNum(temp);
		
		Collections.sort(numListLeft);
		Collections.sort(numListRight);
		

		
		
		for(int num : this.distaceElements()) {
			sumDistance = sumDistance + num;
		}

		System.out.println(sumDistance);
	}
	
	
	
	
	private List<Integer> distaceElements() {
		List<Integer> distance = new ArrayList<Integer>();
		
		for(int num = 0 ; num < numListLeft.size() ; num++) {
			int numD = Math.abs(numListLeft.get(num) - numListRight.get(num));
			distance.add(numD);
		}
			
		return distance;
	}





	private List<Integer> strToNum(List<String> strList) {
		/* Pasa cada elemento de una listaString a un Integer y lo pone dentro de una lista tipo int */
		List<Integer> numList = new ArrayList<Integer>();
		
		for(String str : strList) {
			numList.add(Integer.parseInt(str));
		}
		
		return numList;
	}

	
	
	public List<String> separeInLeft(String[] listLine, int index) {
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
