package algorithm;

public class BoostingApproximation {
	
	
	
	public BoostingApproximation() {
		
		
	}
	public static String DivisionFinder(Double a )
	{
		String Div;
		if(a==0) 
			{
			Div="Bronze 5";
			return Div;
			}
		else if(a==5)
				{
			Div="Bronze 4";
			return Div;
				}
		else if(a==10)
		{
	Div="Bronze 3";
	return Div;
		}
		else if(a==15)
		{
	Div="Bronze 2";
	return Div;
		}
		else if(a==20)
		{
	Div="Bronze 1";
	return Div;
		}
		else if(a==25)
		{
	Div="Silver 5";
	return Div;
		}
		else if(a==30)
		{
	Div="Silver 4";
	return Div;
		}
		else if(a==35)
		{
	Div="Silver 3";
	return Div;
		}
		else if(a==40)
		{
	Div="Silver 2";
	return Div;
		}
		else if(a==45)
		{
	Div="silver 1";
	return Div;
		}
		else if(a==50)
		{
	Div="Gold 5";
	return Div;
		}
		else if(a==55)
		{
	Div="Gold 4";
	return Div;
		}
		else if(a==60)
		{
	Div="Gold 3";
	return Div;
		}
		else if(a==65)
		{
	Div="Gold 2";
	return Div;
		}
		else if(a==70)
		{
	Div="Gold 1";
	return Div;
		}
		
		else return "No Division";
		
	}
	public static Double XPFinder(String a)
	{
		String z=new String("Silver 3");
		if(a.equalsIgnoreCase("Bronze 5"))
		{
			return 0d;
		}
		else if (a.equalsIgnoreCase("Bronze 4")){
			return 5d;
		}
		else if (a.equalsIgnoreCase("Bronze 3")){
			return 10d;
		}
		else if (a.equals("Bronze 2"))
		{
			return 15d;
		}
		else if (a.equalsIgnoreCase("Bronze 1")){
			return 20d;
		}
		else if (a.equalsIgnoreCase("Silver 5"))
		{
			return 25d;
		}
		else if (a.equalsIgnoreCase("Silver 4"))
		{
			System.out.println("ouir silver 4 ");
			return 30d;
		}
		else if (a.equalsIgnoreCase(z)){
			System.out.println("ouir silver 3 ");
			return 35d;
		}
		else if (a.equalsIgnoreCase("Silver 2")){
			return 40d;
		}
		else if (a.equalsIgnoreCase("Silver 1")){
			return 45d;
		}
		else if (a.equalsIgnoreCase("Gold 5")){
			return 50d;
		}
		else if (a.equalsIgnoreCase("Gold 4")){
			return 55d;
		}
		else if (a.equalsIgnoreCase("Gold 3")){
			return 60d;
		}
		else if (a.equalsIgnoreCase("Gold 2")){
			return 65d;
		}
		else if (a.equalsIgnoreCase("Gold 1")){
			return 70d;
		}
		else return 11d ;
	}
	
	public static Integer numberOfDays(Double a,Double b){
		System.out.println("yes");
		
		Integer cmp=0;
		
		// Bronze to Bronze
		if(a<25 && b<=25)
		{
			for(int i=a.intValue();i<b.intValue();i=i+5)
			{
				System.out.println(cmp);
				cmp=cmp+3;
				System.out.println(cmp);
			}
			System.out.println("hedhi"+cmp);
			return cmp;
			
		}
		//Bronze to silver
		else if(a<25 && b>=25 && b<50)
		{ System.out.println("awel");
			for(int i=a.intValue() ;i<25;i=i+5)
			{
				cmp=cmp+3;
			}
			for(int i=25 ;i<b.intValue();i=i+5)
			{
				cmp=cmp+4;
			}
			System.out.println("ouiii");
			return cmp;
			
		}
		//bronze to gold
		else if(a.intValue()<25 && b.intValue()>=50)
		{
			
			for(int  i=a.intValue() ;i<25;i=i+5)
			{
				
				
			cmp=cmp+3;
			
		
			}
			for(int i=25 ;i<50;i=i+5)
			{
				
			cmp=cmp+4;
		
			}
			for(int i=50 ;i<b.intValue();i=i+5)
			{
				cmp=cmp+5;
				
			}
			return cmp;
			
		}
//		silver to silver
		else if(a>=25 && b<=50)
		{
			
			for(int i=a.intValue();i<b.intValue();i=i+5)
			{
				
				cmp=cmp+4;
			
			}
			return cmp;
			
		}
		//silver to gold
		else if(a>=25 && b>=50 && a<50)
		{
			for(int i=a.intValue() ;i<50;i=i+5)
			{
				cmp=cmp+4;
			}
			for(int i=50 ;i<b.intValue();i=i+5)
			{
				cmp=cmp+5;
			}
			return cmp;
		}
		//gold to gold
		else if(a>=50 && b<=70)
		{
		
			for(int i=a.intValue() ;i<b.intValue();i=i+5)
			{
				System.out.println("trah");
				cmp=cmp+5;
			}
			return cmp;
		}
		
		
		else return null;
	}

	public static Integer Facture(Integer a)
	{
		Integer facture=a*5;
		return facture;
	}
	
	

}
