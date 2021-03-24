package com.jelly.tic.entity;

public class Station extends AbstractEntity{

    private String start;
    private String reach;
    private int price;
    private String start_time;
    private String reach_time;

    public String getStart() {return start;}

    public void setStart(String start) {this.start = start;}

    public String getReach() {return reach;}

    public void setReach(String reach) {this.reach = reach;}

    public double getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}

    public String getStart_time() {return start_time;}

    public void setStart_time(String start_time) {this.start_time = start_time;}

    public String getReach_time() {return reach_time;}

    public void setReach_time(String reach_time) {this.reach_time = reach_time;}

    public String toString() {
        return String.format("Station[start=%s, reach=%s, price=%s, start_time=%s, reach_time=%s]",
                getStart(), getReach(), getPrice(), getStart_time(), getReach_time());
    }


}
