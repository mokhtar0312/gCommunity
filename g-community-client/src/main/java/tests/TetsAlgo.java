package tests;

import delegate.ActiveMemberServicesDelegate;
import algorithm.BoostingApproximation;

public class TetsAlgo {

	public static void main(String[] args) {
		

//		String a= BoostingApproximation.DivisionFinder(1d);
//		System.out.println(a);
//		
		Double b= BoostingApproximation.XPFinder("Bronze 2");
//		System.out.println(b);
		Integer c =0;
//		Double s=1d;
//		Integer q=s.intValue();
//		System.out.println(q);
		 c=BoostingApproximation.numberOfDays(1d, b);
		 
		System.out.println("resultat 5edmet ye rjel"+c);
	}

}
