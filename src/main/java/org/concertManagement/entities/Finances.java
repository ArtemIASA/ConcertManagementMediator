package org.concertManagement.entities;

import java.util.UUID;


public class Finances {

    private UUID id;


    private Concert concert;

    private int expenses;

    private int profit;

    private int revenue;

    public Finances() {
        this.expenses = 0;
        this.profit = 0;
        this.revenue = 0;
    }

    public void setExpenses(int expenses){
        this.expenses = expenses;
        this.revenue = profit - expenses;
    }

    public void setProfit(int profit){
        this.profit = profit;
        this.revenue = profit - expenses;
    }

    public int getExpenses(){
        return expenses;
    }

    public int getProfit(){
        return profit;
    }
}
