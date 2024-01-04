package src;
import java.util.Scanner;
public class NumberGuess {
	static int won=0;
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		numberGuess();
		int count=1;
		boolean attempts=false;
		
		while(!attempts)
		{
			System.out.println("Do you want to Play again? Press y or n: ");
			char y=sc.next().charAt(0);
			if(y== 'y') {
				numberGuess();
				count++;
			}
			else {
				System.out.println("Thanks for Playing..");
				break;
			}
		}
		System.out.println("Your No. of attempts: "+count+" and Your Score out of "+count+" attempts are: "+won);
	}
	
	public static void numberGuess()
	{
		
		int random_no= (int) (Math.random()*100) + 1;
		int c=6;
		int ch;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		boolean right=false;
		System.out.println("I choose the No. between 1-100\nYou will try with 6 lives\nGuess the No.:");
		while(c > 0) {
			ch=sc.nextInt();
			
			if(random_no==ch) {
				System.out.println("Congratulation!!\n You Guess the Correct No.\n You Win");
				right=true;
				won++;
				break;
			}
			
			else if(ch > random_no) {
				System.out.println("You choose greater No. You left with "+(c-1)+" trials");
				c--;
			}
			else {
				System.out.println("You choose lower No. You left with "+(c-1)+" trials");
				c--;
			}
		}
		
		if(right==false) {
			System.out.println("Sorry..You loose the Game\nThe number was "+random_no+"\nBetter Luck Next Tries..");
		}
	}
}