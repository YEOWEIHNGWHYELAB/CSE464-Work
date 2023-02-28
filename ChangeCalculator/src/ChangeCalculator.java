import java.util.Scanner;

public class ChangeCalculator

{


  public static void main(String[] args)
  {
   Scanner scan = new Scanner(System.in);
   double cost, paidAmount;
   int[] changes = new int[5];
   System.out.println("Please enter the cost:");
   cost = scan.nextDouble();

   System.out.println("Please enter the paid amount:");
   paidAmount = scan.nextDouble();

   changes=changeCalc(paidAmount, cost);

   for(int i=0; i<5 ; i++)
   {
	   System.out.println(changes[i]);
   }


  }

  public static int[] changeCalc(double paid, double cost)
  {

  	 int change = (int)((paid - cost)*100.0);
  	 int dollars=0, quarters=0, dimes=0, nickles=0, pennies=0;
  	   int[] changes = new int[5];
  	   
  	   
  	   /*
  	   if(change > 0)
  	   {
  		   dollars=change/100;
  		   changes[0]=dollars;

  		   change = change%100;

  		   quarters = change/25;
  		   changes[1]=quarters;

  		   change = change%25;

  		   dimes = change/10;
  	       changes[2]=dimes;

  		   change = change%10;

  		   nickles = change/5;

  		   changes[3]=nickles;

  		   pennies = change%5;
  	       changes[4]=pennies;

      }
      */
  	 if(change > 0)
	   {
		   dollars=change/100;
		   changes[0]=dollars;

		   change = change%100;

		   quarters = change/25;
		   changes[1]=quarters;

		   change = change%25;

		   dimes = change/10;
	       changes[2]=dimes;

		   change = change%10;

		   nickles = change/5;
		   changes[3]=nickles;
		   
		   change = change%5;

		   pennies = change;
	       changes[4]=pennies;

    }

     return changes;

}
}