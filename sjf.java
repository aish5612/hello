package spos;
import java.util.*;
import java.util.Scanner;


public class sjf {
	public static void main(String args[]) {
		
		int n;
		int i;
		int j;
		int total = 0;
		int pos;
		int temp;
		float waitAvg, tatAvg;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("enter no of processes: ");
		n = s.nextInt();
		
		int[] process = new int[n];
		int[] burstTime = new int[n];
		int[] waitingTime = new int[n];
		int[] tat = new int[n];
		
		System.out.println("ENter Burst Time:");
		for(i =0 ; i < n; i++) {
			System.out.println("p" + (i+1));
			burstTime[i] = s.nextInt();
			process[i] = i+1;
		}
		
		
		for(i = 0; i < n; i++) {
			pos = i;
			for(j = i+1; j < n; j++) {
				if(burstTime[j] < burstTime[pos]);
				pos = j;
			}
			
			temp = burstTime[i];
			burstTime[i] = burstTime[pos];
			burstTime[pos] = temp;
			
			temp = process[i];
			process[i] = process[pos];
			process[pos] = temp;
		}
		
		waitingTime[0] = 0;
		for(i= 1; i < n; i++) {
			waitingTime[i] += burstTime[i];
			total += waitingTime[i];
			
		}
		waitAvg = (float)total/n;
		total =0;
		System.out.println("--------------------------------------------------------");
		System.out.println("process\t BurstTime \tWaitingTime \tTurnAround time");
		System.out.println("--------------------------------------------------------");
		for(i = 0; i < n; i++) {
			tat[i] = burstTime[i] + waitingTime[i];
			total += tat[i];
			System.out.println("\np" + process[i] +"\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + tat[i]);
		}
		tatAvg = (float)total /n;
		System.out.println("\nAvgWaitingTime: " + waitAvg);
		System.out.println("TurnAroundTime: " + tatAvg);
	}


}
