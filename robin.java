import java.util.Scanner;

public class robin {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		int[] wTime = new int[10];//waiting time
		int[] bTime = new int[10];//burstTime
		int[] rTime = new int[10];//remaing Time
		int[] tat = new int[10];
		int n;
		int quantum;
		int i;
		int count = 0;
		float waitAvg=0;
		float tatAvg=0;
		int temp;
		int sq = 0;
		
		System.out.println("Enter the number of processes: ");
		n = s.nextInt();
		for(i = 0; i <n; i++ ) {
			System.out.println("Enter Burst time of p" + (i+1) + ": ");
			bTime[i] = s.nextInt();
			rTime[i] = bTime[i];
		}
		
		
		System.out.println("Enter the Quantum time: ");
		quantum = s.nextInt();
		
		while(true) {
			for(i = 0, count = 0; i < n; i++) {
				temp = quantum;
				
				if(rTime[i] == 0){
					count++;
					continue;					
				}
				
				if(rTime[i] > quantum) {
					rTime[i] -= quantum;	
				}
				else {
					if(rTime[i]>=0) {
					temp = rTime[i];
					rTime[i] = 0; }
				sq += temp;
				tat[i]=sq;
				}
			}
				if(count == n) {
					break;
				}
		}
				 
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println(" process \t bursttime \t turnaroundtime \t waitingTime");
				System.out.println("-----------------------------------------------------------------------------");
				
				
				for(i = 0; i < n; i++) {
					wTime[i] = tat[i] - bTime[i];
					waitAvg += wTime[i];
					tatAvg += tat[i];
					System.out.println("P" +(i+1) + "\t\t\t" +bTime[i] +"\t\t\t" + tat[i] + "\t\t\t" + wTime[i]);
					
				}
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Avg waiting time = " + (waitAvg/n));
				System.out.println("Avg tat = " + (tatAvg/n));
				
			}
		}
		
		
	

