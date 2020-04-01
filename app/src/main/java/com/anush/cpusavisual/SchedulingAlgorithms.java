package com.anush.cpusavisual;

import java.util.ArrayList;
import java.util.List;

public class SchedulingAlgorithms {
    List<Process> processes,queue,ganttChartProcesses;
    Process chartDetails;
    private void createQueue()
    {
        ganttChartProcesses = new ArrayList<>();
        processes = new ArrayList<>();
        queue = new ArrayList<>();
    }
    public List<Process> FCFS(Integer numberOfProcesses)
    {
        createQueue();
        int curr_time = 0,
        wait_time = 0,
        resp_time = 0,
        turn_time = 0,
        sum_time = 0;
        for (Process p:EnterProcessActivity.processList)
        {
            if (p.getArrivalTime() > curr_time)
                curr_time = p.getArrivalTime();

            chartDetails = new Process();
            chartDetails.setProcessName(p.getProcessName());
            chartDetails.setArrivalTime(curr_time);
            chartDetails.setBurstTime(curr_time+p.getBurstTime());

            p.setWaitTime(curr_time - p.getArrivalTime());
            wait_time+=p.getWaitTime();
            curr_time+=p.getBurstTime();
            p.setTurnAroundTime(curr_time-p.getArrivalTime());
            p.setResponseTime(chartDetails.getArrivalTime()-p.getArrivalTime());
            turn_time += p.getTurnAroundTime();
            resp_time += p.getResponseTime();
            sum_time += p.getBurstTime();

            int ganttChartProcessesSize=ganttChartProcesses.size();
            if( ganttChartProcessesSize>0)
            {
                if(ganttChartProcesses.get(ganttChartProcessesSize-1).getBurstTime() != chartDetails.getArrivalTime())
                {
                    Process idle=new Process(ganttChartProcesses.get(ganttChartProcessesSize-1).getBurstTime(),chartDetails.getArrivalTime());
                    idle.setProcessName("Idle");
                    ganttChartProcesses.add(idle);
                }
            }
            else if (chartDetails.getArrivalTime()>0)
            {
                Process idle=new Process(0,chartDetails.getArrivalTime());
                idle.setProcessName("Idle");
                ganttChartProcesses.add(idle);
            }
            ganttChartProcesses.add(chartDetails);
        }
        wait_time/=numberOfProcesses;
        resp_time/=numberOfProcesses;
        turn_time/=numberOfProcesses;
        float throughput=numberOfProcesses/curr_time;
        float cpu_util=sum_time*100/curr_time;
        Process temp=new Process();
        temp.setResponseTime(resp_time);
        temp.setTurnAroundTime(turn_time);
        temp.setWaitTime(wait_time);
        temp.setArrivalTime(curr_time);
        temp.setBurstTime(sum_time);
        temp.setProcessName("Stats");
        ganttChartProcesses.add(temp);
        return ganttChartProcesses;
    }
    public List<Process> RoundRobin(Integer numberOfProcesses, Integer quanta)
    {
        createQueue();
        queue.add(EnterProcessActivity.processList.get(0));
        int[] at = new int[numberOfProcesses];
        for(int i=0;i<numberOfProcesses;++i)
        {
            at[i]=EnterProcessActivity.processList.get(i).getArrivalTime();
        }
        while(!queue.isEmpty())
        {
            if(queue.get(0).getBurstTime()>quanta)
            {

            }
        }
        return processes;
    }
    public List<Process> SJF(Integer numberOfProcesses)
    {

        return processes;
    }
}
