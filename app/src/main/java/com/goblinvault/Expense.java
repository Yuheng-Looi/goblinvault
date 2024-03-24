package com.goblinvault;

public class Expense {
    private float amount;
    private ExpenseCategory category;
    private long timestamp;
    private int dayTag;
    private int monthTag;
    private int yearTag;

    public Expense(float amount, ExpenseCategory category, long timestamp, int dayTag, int monthTag, int yearTag) {
        this.amount = amount;
        this.category = category;
        this.timestamp = timestamp;
        this.dayTag = dayTag;
        this.monthTag = monthTag;
        this.yearTag = yearTag;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDayTag() {
        return dayTag;
    }

    public void setDayTag(int dayTag) {
        this.dayTag = dayTag;
    }

    public int getMonthTag() {
        return monthTag;
    }

    public void setMonthTag(int monthTag) {
        this.monthTag = monthTag;
    }

    public int getYearTag() {
        return yearTag;
    }

    public void setYearTag(int yearTag) {
        this.yearTag = yearTag;
    }
}

