package com.goblinvault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    private List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpensesForYear(int year) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getYearTag() == year) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public List<Expense> getPieChartForYear(int year) {
        return calculatePieChart(getExpensesForYear(year));
    }

    public List<Expense> getExpensesForMonth(int year, int month) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getYearTag() == year && expense.getMonthTag() == month) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public List<Expense> getPieChartForMonth(int year, int month) {
        return calculatePieChart(getExpensesForMonth(year, month));
    }

    public List<Expense> getExpensesForDay(int year, int month, int day) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getYearTag() == year && expense.getMonthTag() == month && expense.getDayTag() == day) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public List<Expense> getPieChartForDay(int year, int month, int day) {
        return calculatePieChart(getExpensesForDay(year, month, day));
    }

    private List<Expense> calculatePieChart(List<Expense> filteredExpenses) {
        Map<ExpenseCategory, Float> categoryTotalMap = new HashMap<>();

        for (Expense expense : filteredExpenses) {
            ExpenseCategory category = expense.getCategory();
            float totalAmount = categoryTotalMap.getOrDefault(category, 0f);
            categoryTotalMap.put(category, totalAmount + expense.getAmount());
        }

        List<Expense> pieChartExpenses = new ArrayList<>();
        for (Map.Entry<ExpenseCategory, Float> entry : categoryTotalMap.entrySet()) {
            ExpenseCategory category = entry.getKey();
            float totalAmount = entry.getValue();
            pieChartExpenses.add(new Expense(totalAmount, category, System.currentTimeMillis(), 0, 0, 0));
        }

        pieChartExpenses.sort((expense1, expense2) -> Float.compare(expense2.getAmount(), expense1.getAmount()));
        return pieChartExpenses;
    }
}
