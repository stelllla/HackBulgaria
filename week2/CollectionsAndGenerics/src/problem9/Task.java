package problem9;

import java.util.Random;

public class Task  {

    private int priority;

    private int timeRequired;

    private boolean isFinished;
    
    private String name;

    public Task(String name,int priority, int timeRequired, boolean isFinished) {

        this.name = name;
        this.priority = priority;
        this.timeRequired = timeRequired;
        this.isFinished = isFinished;
    }

    public Task(String name,int priority, int timeRequired) {
        
        this.name = name;
        this.priority = priority;
        this.timeRequired = timeRequired;
        this.isFinished = false;

    }

    public Task() {
        
        this.name = "";
        Random rand = new Random();
        this.priority = rand.nextInt(10) % 10;
        this.timeRequired = 8;
        this.isFinished = false;
    }

    public Task(String name,int time) {
        
        this.name = name;
        this.priority = 9;
        this.timeRequired = time;
        this.isFinished = false;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(int timeRequired) {
        this.timeRequired = timeRequired;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }



}
