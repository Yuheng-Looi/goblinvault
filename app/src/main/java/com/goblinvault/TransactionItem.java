package com.goblinvault;


public class TransactionItem {
    private String history;
    private String amount;

    public TransactionItem(String history, String amount) {
        this.history = history;
        this.amount = amount;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
