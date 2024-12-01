package day1;

import java.util.ArrayList;
import java.util.List;

public class Distance {
	gestorInput gestor;
	
	List<Integer> numListLeft = new ArrayList<Integer>();
	List<Integer> numListRight = new ArrayList<Integer>();
	
	List<Integer> distance = new ArrayList<Integer>();

	
	public Distance(gestorInput gestor) {
		this.gestor = gestor;
		
		
		numListLeft = this.gestor.getNumListLeft();
		numListRight = this.gestor.getNumListRight();
		distance = this.distaceElements();
		

	}
		

	// PRIMERA PARTE
	private List<Integer> distaceElements() {
		/* Calcula la distancia entre cada elemento de las dos listas y lo agrega a una lista nueva "distance".
		 * Retorna una lista tipo Integer.
		 * */
		
		List<Integer> distance = new ArrayList<Integer>();
			
		for(int num = 0 ; num < numListLeft.size() ; num++) {
			
			int numD = Math.abs(numListLeft.get(num) - numListRight.get(num));
			distance.add(numD);
			
		}
		return distance;
	}

		
	public int sumDist() {
		/* Suma los elementos de una lista.
		 * Retorta un int.
		 */
			int sumDistance = 0;
		
			for(int num : this.distaceElements()) {
				sumDistance = sumDistance + num;
			}
			
			return sumDistance;
		}
}
		

