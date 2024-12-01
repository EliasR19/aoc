package day1;

import java.util.ArrayList;
import java.util.List;

public class AppearsNum {
	
	gestorInput gestor;
	
	List<Integer> numListLeft = new ArrayList<Integer>();
	List<Integer> numListRight = new ArrayList<Integer>();
	
	
	public AppearsNum(gestorInput gestor) {
		this.gestor = gestor;
		
		
		numListLeft = this.gestor.getNumListLeft();
		numListRight = this.gestor.getNumListRight();

	}
		
	//LISTAS SEGUNDA PARTE
	public long numAppearSum() {
		/* Cuenta la cantidad de veces que un numero en la primer lista aparece en la segunda lista y lo multiplica por esa cantidad y lo va sumando.
		 * Retorna un long.
		 * */
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
	

}
