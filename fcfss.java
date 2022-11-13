import java.io.*;
import java.util.Scanner;

public class fcfss {
	public static void main(String args[]) 
	{
		int i;
		int n;
		
		int[] burst_time = new int[50];
		int[] wt = new int[50];
		int [] tt = new int[50];
		
		float avg_wt = 0;
		float avg_tt = 0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter no of process: ");
		n = s.nextInt();
		
		System.out.println("Enter burst time for processes: ");
		for(i = 0; i < n; i++) {
			System.out.println("p" + (i+1) + ": ");
			burst_time[i] = s.nextInt();
			
		}
		
		for(i = 1; i < n; i++) {
			wt[i] = wt[i-1] + burst_time[i-1];
			avg_wt  += wt[i];
		}
		avg_wt = avg_wt/n;
		
		for(i = 0; i < n; i++) {
			tt[i] = wt[i] + burst_time[i];
			avg_tt += tt[i];
			}
		avg_tt /= n;
		
 		System.out.println("***************************************************************************");
		System.out.println("\tProcess\t\tburstTime\twaitingTime\tTurnAroundTime");
		System.out.println("**************************************************************************");
		for(i = 0; i < n; i ++) {
			System.out.println("\tp"+(i+1) + "\t\t" + burst_time[i]+ "\t\t" + wt[i] + "\t\t" + tt[i]);
		}


		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Avg waiting time :" + avg_wt);
		System.out.println("Avg turn around time :" + avg_tt);
	}

}
