/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osprojectt;

import java.util.ArrayList;
import java.util.LinkedList;
import static osprojectt.Test.print;

/**
 *
 * @author yaseminturhan
 */
public class RoundRobin {
    
     private static ArrayList<Process> cloneIt(ArrayList<Process> processes) {
		ArrayList<Process> clone = new ArrayList<Process>(processes.size());
		for (Process process : processes) {
			clone.add((Process) process.clone());
		}
		return clone;
      
    }
    
    public static void RoundRobin(ArrayList<Process> processes, int quantum) {
		String[] ganntChart;
		int[] bTimes = new int[processes.size()];
		LinkedList<Process> roundrobin = new LinkedList<Process>();
		int ganntChartSize = 0;
                int responseTime = 0;
                int counter = 0;
		for (Process process : processes) {
			ganntChartSize = ganntChartSize + process.getBurstTime();
			roundrobin.add(process);
			bTimes[counter++] = process.getBurstTime();
		}
		ganntChart = new String[ganntChartSize];
		for (int i = 0; i < ganntChart.length; i++) {
			ganntChart[i] = null;
		}
		while (!roundrobin.isEmpty()) {
			Process appoint = roundrobin.pop();
			if (!appoint.isStarted()) {
				appoint.addResponseTime(responseTime);
				appoint.setStarted(true);
			}
			ganntChart[responseTime] = appoint.getName();
			appoint.addWaitingTime(responseTime - appoint.getEndTime());
			if (appoint.getBurstTime() > quantum) {
				appoint.setBurstTime(appoint.getBurstTime() - quantum);
				responseTime = responseTime + quantum;
				appoint.setEndTime(responseTime);
				roundrobin.add(appoint);
			} else {
				responseTime = responseTime + appoint.getBurstTime();
				appoint.setEndTime(responseTime);
				appoint.addTurnaroundTime(responseTime);
			}
		}
		for (int i = 0; i < processes.size(); i++) {
			processes.get(i).setBurstTime(bTimes[i]);
		}
		print(processes, ganntChart, "RR-" + quantum);
	}
    
}
