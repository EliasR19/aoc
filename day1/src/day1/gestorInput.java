package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class gestorInput {
	List<Integer> numListLeft = new ArrayList<Integer>();
	List<Integer> numListRight = new ArrayList<Integer>();
	List<String> temp = new ArrayList<String>();
	int sumDistance = 0;
	
	
	String[] listStr;
	
	public gestorInput(String list) {
		listStr= list.split("\n"); // agarra el string y lo divide en renglones.
		
		
		temp = this.separeInTwo(listStr, 0);
		numListLeft = this.strToNum(temp);

		temp = this.separeInTwo(listStr, 1);
		numListRight = this.strToNum(temp);
		
		Collections.sort(numListLeft);
		Collections.sort(numListRight);
	}
	
	
	
	public List<Integer> getNumListLeft(){
		return numListLeft;
	}
	public List<Integer> getNumListRight(){
		return numListRight;
	}
	
	private List<Integer> strToNum(List<String> strList) {
		/* Pasa cada elemento String de la lista "strList" a data_type int y lo almacena en una nueva lista.
		 * Retorna una lista tipo Integer
		 * */
		
		List<Integer> numList = new ArrayList<Integer>();
		
		for(String str : strList) {
			numList.add(Integer.parseInt(str));
		}
		
		return numList;
	}

	
	
	private List<String> separeInTwo(String[] listLine, int index) {
		/*	Divide cada renglon del array "listaLine" en un array nueva donde cada renglon ocupa un indice nuevo, se queda con el idice "index" y lo almacena en una nueva lista.
		 * Retorna Una lista de tipo String
		 * */
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
