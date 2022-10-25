package com.supremepole.simpledemo;

public class Bill {

    private int id = 1;
    private String name = "";
    private int amount = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString() {
        return "id=" + getId() + ";name=" + getName() + ";amount=" + getAmount();
    }

}
