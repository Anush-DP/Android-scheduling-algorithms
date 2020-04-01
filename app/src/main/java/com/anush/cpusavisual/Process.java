package com.anush.cpusavisual;

public class Process {

    private Integer arrivalTime;
    private Integer burstTime;
    private Integer waitTime = 0;
    private Integer turnAroundTime = 0;
    private Integer responseTime = 0;
    private String processName;

    public Process()
    {
        this(1,1);
    }

    public Process(int arrivalTime, int burstTime)
    {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    public void setWaitTime(int waitTime)
    {
        this.waitTime = waitTime;
    }

    public void setTurnAroundTime(int turnAroundTime)
    {
        this.turnAroundTime = turnAroundTime;
    }

    public void setResponseTime(int responseTime)
    {
        this.responseTime = responseTime;
    }

    public Integer getWaitTime()
    {
        return waitTime;
    }

    public Integer getTurnAroundTime() {
        return turnAroundTime;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public Integer getBurstTime() {
        return burstTime;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(Integer burstTime) {
        this.burstTime = burstTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
