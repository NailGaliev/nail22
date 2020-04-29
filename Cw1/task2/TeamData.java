package com.company;

public class TeamData implements Comparable<TeamData>{

    private String name;
    private int problems;
    private int solved;
    private int time;

    public TeamData(String name, int problems ) {
        this.name = name;
        this.problems = problems;
        this.solved = 0;
        this.time = 0;
    }

    public void success(int problem, int time) {
        this.solved++;
        this.time += time;
    }

    public int solved() {
        return solved;
    }

    public int time() {
        return time;
    }

    public double percentCorrect() {
        return (double)this.solved/(double)this.problems * 100.0;
    }

    @Override
    public String toString() {
        return this.name + " solved " + this.solved + " of " +
                this.problems + " in " + this.time + " minutes ";
    }

    @Override
    public int compareTo(TeamData o) {
        if(this.percentCorrect() > o.percentCorrect()) {
            return 1;
        }
        else if(this.percentCorrect() < o.percentCorrect()) {
            return -1;
        }
        else{
            if (this.time > o.time) {
                return 1;
            }
            else if(this.time < o.time) {
                return -1;
            }
            return 0;
        }
    }
}