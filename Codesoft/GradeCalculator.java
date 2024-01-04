package src;
import java.util.Scanner;
public class GradeCalculator {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int marks[] = new int[100];
		int tot_marks=0;
		String res = null;
		System.out.println("Enter the no. of Subjects: ");
		int sub=sc.nextInt();
		
		System.out.println("Enter the marks of each subject out of 100: ");
		for(int i=0; i<sub; i++) {
			marks[i]=sc.nextInt();
			tot_marks=tot_marks + marks[i];
		}
		 double per=(double)tot_marks/sub;
		
		if(per>=80) {
			res="Grade A";
		}
		else if(per<80 && per>=70) {
			res="Grade B";
		}
		else if(per<70 && per>=60) {
			res="Grade C";
		}
		else if(per<60 && per>=50) {
			res="Grade D";
		}
		else {
			res="Grade F";
		}
		
		System.out.println("Your Total Marks: "+tot_marks+"\nYour Percentage: "+per+"\nYou got Grade: "+res);
		
	}

}
