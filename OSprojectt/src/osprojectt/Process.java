/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osprojectt;

/**
 *
 * @author yaseminturhan
 */
public class Process implements Comparable<Process>, Cloneable{
    
    private String name;
    private int burstTime;
    private int responseTime;
    private int waitingTime;
    private int turnaroundTime;
    private int endTime;
    private boolean started;
    
   public Process(){
       name = null;
       burstTime = 0;
       responseTime = 0;
       waitingTime = 0;
       turnaroundTime = 0;
       endTime = 0;
       started = false;
   }

    

    public String getName() {
        return name;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean isStarted() {
        return started;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }


    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
    
    public void addResponseTime(int responseTime){
        
        this.responseTime = this.responseTime + responseTime;
        
    }
    
    public void addWaitingTime(int waitingTime ){
        this.waitingTime = this.waitingTime + waitingTime;
    }
    
    public void addTurnaroundTime(int turnaroundTime){
        this.turnaroundTime = this.turnaroundTime + turnaroundTime;
    }

    @Override
    public int compareTo(Process argument) {
        
        if (burstTime < argument.getBurstTime()) {
			return -1;
		} else if (burstTime > argument.getBurstTime()) {
			return 1;
		} else {
			return 0;
		}
        
    }
    
    public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}
    
   
}
