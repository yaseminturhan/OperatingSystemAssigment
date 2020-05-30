/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osprojectt;

import java.util.ArrayList;
import static osprojectt.Test.print;

/**
 *
 * @author yaseminturhan
 */
public class FCFS  {
    
    
    
    
    private static ArrayList<Process> cloneIt(ArrayList<Process> processes) {
		ArrayList<Process> clone = new ArrayList<Process>(processes.size());
		for (Process process : processes) {
			clone.add((Process) process.clone());
		}
		return clone;
      
    }
    
    public static void FisrtServe(ArrayList<Process> processes) {
                String[] ganntChart;
                int ganntChartSize = 0;
                int responseTime = 0;
		
		for (Process process : processes) {
			ganntChartSize = ganntChartSize + process.getBurstTime();
			process.addResponseTime(responseTime);
			process.addWaitingTime(responseTime);
			responseTime = responseTime + process.getBurstTime();
			process.setEndTime(responseTime);
			process.addTurnaroundTime(responseTime);
		}
		ganntChart = new String[ganntChartSize];
		for (int i = 0; i < ganntChart.length; i++) {
			ganntChart[i] = null;
		}
		for (Process process : processes) {
			ganntChart[process.getResponseTime()] = process.getName();
		}
		print(processes, ganntChart, "FCFS");
	}

   

}
