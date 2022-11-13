package spos;
import java.util.Scanner;

public class priority {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int temp; 
		int n, i;
		int[] p = new int[10];
		int[] priority = new int[10];
		int[] bTime = new int[10];
		int[] wTime = new int[10];
		int[] tat = new int[10];
		
		int wAvg = 0;
		int tatAvg = 0;
		
		
		System.out.println("Enter no of process");
		n = s.nextInt();
		System.out.println("enter burst time & priority: ");
		for(i=0; i < n; i++) {
			System.out.println("p" + (i+1) + ": ");
			bTime[i] = s.nextInt();
			priority[i] = s.nextInt();
			p[i] = i+1;
		}
		
		
		for(i = 0; i < n; i++) {
			for(int j = i+1; j<n; j++) {
				if(priority[i] < priority[j]) {
					temp = priority[i];
					priority[i] = priority[j];        //priority
					priority[j] = temp;
					
					temp = bTime[i];
					bTime[i] = bTime[j];              //burstTime
					bTime[j] = temp;
					
					temp = p[i];
					p[i] = p[j];                     //process number
					p[j] = temp;
				}
			}
		}
		wTime[0] = 0;
		tat[0] = bTime[0];
		tatAvg = tat[0];
	
		
		for(i = 1; i < n; i++) {
			wTime[i] = tat[i-1];
			wAvg += wTime[i];
			tat[i] = wTime[i] + bTime[i];
			tatAvg += tat[i];
		}
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.print("process \t priority \t bursttime \t waittime \turntime\n");
		System.out.println("---------------------------------------------------------------------------");
		
		for(i = 0; i< n; i++) {
			System.out.println(p[i] + "\t\t" + priority[i]  +"\t\t" + bTime[i] + "\t\t" + wTime[i] + "\t\t" + tat[i]);
		}
		}

}
