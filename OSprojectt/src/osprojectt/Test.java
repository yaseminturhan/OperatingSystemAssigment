/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osprojectt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static osprojectt.FCFS.FisrtServe;
import static osprojectt.RoundRobin.RoundRobin;
import static osprojectt.SJF.shortestJobFirst;

/**
 *
 * @author yaseminturhan
 */
public class Test {
    
    public static void main(String[] args) {

		testing("test1.txt", 1); // test file 1
		testing("test2.txt", 2); // test file 2
		testing("test3.txt", 3); // test file 3*/
                
               
                
	}
    
        private static ArrayList<Process> cloneIt(ArrayList<Process> processes) {
		ArrayList<Process> clone = new ArrayList<Process>(processes.size());
		for (Process process : processes) {
			clone.add((Process) process.clone());
		}
		return clone;
      
    }
    
    
    public static void testing(String takeName, int testingNum) {
		Scanner in = new Scanner(System.in);
        
                System.out.println("Enter config file name: ");
		ArrayList<Process> processes = new ArrayList<Process>();

		try {
                        String filename = in.next();
                        File inputFile = new File(filename);
			Scanner fileIn = new Scanner(inputFile);
			while (fileIn.hasNext()) {
				processes.add(new Process());
				processes.get(processes.size() - 1).setName(fileIn.nextLine());
				processes.get(processes.size() - 1).setBurstTime(
						Integer.parseInt(fileIn.nextLine()));
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
                
		System.out.println("Run of testfile" + testingNum + ": \n\n");
		FisrtServe(cloneIt(processes));
		shortestJobFirst(cloneIt(processes));
		RoundRobin(cloneIt(processes), 3);
		RoundRobin(cloneIt(processes), 5);
	}
    
    
    
    
    
    public static void print(ArrayList<Process> processes, String[] ganntChart, String sched) {
        
        
		System.out.print(sched + ": ");
		for (int i = 0; i < ganntChart.length; i++) {
			if (ganntChart[i] == null) {
				System.out.print(" ");
			} else {
				System.out.print("|" + ganntChart[i]);
			}
		}
		System.out.println("|");

		for (int i = 0; i < sched.length(); i++) {
			System.out.print(" ");
		}
		System.out.print("  ");
		for (int i = 0; i < ganntChart.length; i++) {
			if (ganntChart[i] == null) {
				System.out.print(" ");
			} else {
				System.out.print(i);
				if (i < 10) {
					for (int j = 0; j < ganntChart[i].length(); j++) {
						System.out.print(" ");
					}
				} else if (i < 100) {
					for (int j = 0; j < ganntChart[i].length() - 1; j++) {
						System.out.print(" ");
					}
				} else {
					for (int j = 0; j < ganntChart[i].length() - 2; j++) {
						System.out.print(" ");
					}
				}
			}
		}
		System.out.println(ganntChart.length);

		float avgWaitTime = 0, avgTATime = 0;
		for (Process process : processes) {
			System.out.println(process.getName() + ": ");
			System.out.println("\tBurst Time: " + process.getBurstTime() + " ms");
			System.out.println("\tEnd Time: " + process.getEndTime() + " ms");
			System.out.println("\tResponse Time: " + process.getResponseTime()
					+ " ms");
			System.out.println("\tWaiting Time: " + process.getWaitingTime()
					+ " ms");
			System.out.println("\tTurnaround Time: " + process.getTurnaroundTime()
					+ " ms" + "\n");
			avgWaitTime += process.getWaitingTime();
			avgTATime += process.getTurnaroundTime();
		}
		System.out.printf("Average Waiting Time: %.2f ms\n",
				avgWaitTime / processes.size());
		System.out.printf("Average Turnaround Time: %.2f ms\n\n\n", avgTATime
				/ processes.size());
	}
}

    
    
    
    

