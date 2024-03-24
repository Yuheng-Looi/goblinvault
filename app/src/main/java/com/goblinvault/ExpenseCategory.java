package com.goblinvault;

public enum ExpenseCategory {
    GROCERY("Grocery"),
    SHOPPING("Shopping"),
    FOOD_DRINKS("Food & Drinks"),
    BILLS_FEES("Bills & Fees"),
    TRANSPORT("Transport"),
    GIFTS("Gifts"),
    BEAUTY("Beauty");

    private final String displayName;

    ExpenseCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
