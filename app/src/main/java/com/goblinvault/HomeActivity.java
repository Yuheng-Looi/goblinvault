package com.goblinvault;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private PieChart pieChart;
    private ExpenseManager expManager;
    private int year = 2023;
    private int month = 12;
    private int day = 5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homepage);

        pieChart = findViewById(R.id.pie_chart);
        expManager = new ExpenseManager();

        randomExpenses(); // generate random expenses

        TextView analyticTitle = findViewById(R.id.analytic_title);
        analyticTitle.setText("Expenses Analytic (" + month + "/" + year + ")");

        List<Expense> monthlyExpenses = expManager.getPieChartForMonth(year, month);
        List<Expense> monthlyTransaction = expManager.getExpensesForMonth(year, month);
        updatePieChart(monthlyExpenses);
        handleTransaction(monthlyTransaction);

        findViewById(R.id.btnDaily).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView analyticTitle = findViewById(R.id.analytic_title);
                analyticTitle.setText("Expenses Analytic (" + day + "/" + month + "/" + year + ")");

                List<Expense> dailyExpenses = expManager.getPieChartForDay(year, month, day);
                updatePieChart(dailyExpenses);

                List<Expense> dailyTransaction = expManager.getExpensesForDay(year, month, day);
                handleTransaction(dailyTransaction);
            }
        });

        findViewById(R.id.btnMonthly).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView analyticTitle = findViewById(R.id.analytic_title);
                analyticTitle.setText("Expenses Analytic (" + month + "/" + year + ")");
                updatePieChart(monthlyExpenses);
                handleTransaction(monthlyTransaction);
            }
        });

        findViewById(R.id.btnYearly).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView analyticTitle = findViewById(R.id.analytic_title);
                analyticTitle.setText("Expenses Analytic (" + year + ")");
                List<Expense> yearlyExpenses = expManager.getPieChartForYear(year);
                updatePieChart(yearlyExpenses);

                List<Expense> yearlyTransaction = expManager.getExpensesForYear(year);
                handleTransaction(yearlyTransaction);
            }
        });

        TransactionHistoryOnClick();
//        initClickBills();
//    }
//
//    private void initClickBills() {
//        // all button will navigate to bank transfer activity when demo
//        findViewById(R.id.ibElectricBill).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, BankTransferActivity.class);
//                startActivity(intent);
//            }
//        });

        // Add other button click listeners similarly
    }

    private void handleTransaction(List<Expense> transactions) {
        List<TransactionItem> transactionItemList = new ArrayList<>();
        float totalExpenses = 0.0f;
        for (Expense expense : transactions) {
            transactionItemList.add(new TransactionItem(expense.getDayTag() + "-" + expense.getMonthTag() + "-" + expense.getYearTag() + "\n" + expense.getCategory(), "RM" + String.format("%.2f", expense.getAmount())));
            totalExpenses += expense.getAmount();
        }

        RecyclerView recyclerView = findViewById(R.id.rvTransaction);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TransactionAdapter(transactionItemList));

        TextView totalExpense = findViewById(R.id.tvTotalExpense);
        totalExpense.setText("Total Expenses: RM" + String.format("%.2f", totalExpenses));
    }

    private void TransactionHistoryOnClick() {
        ImageView ivArrow = findViewById(R.id.ivArrow);
        RecyclerView rvTransaction = findViewById(R.id.rvTransaction);
        ivArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rvTransaction.getVisibility() == View.GONE) {
                    rvTransaction.setVisibility(View.VISIBLE);
                    ivArrow.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    rvTransaction.setVisibility(View.GONE);
                    ivArrow.setImageResource(R.drawable.ic_arrow_left);
                }
            }
        });
    }

    private void randomExpenses() {
        expManager.addExpense(new Expense(50f, ExpenseCategory.BEAUTY, System.currentTimeMillis(), day, month, 2023));
        expManager.addExpense(new Expense(30f, ExpenseCategory.FOOD_DRINKS, System.currentTimeMillis(), day, month, 2023));
        expManager.addExpense(new Expense(20f, ExpenseCategory.FOOD_DRINKS, System.currentTimeMillis(), day, month, 2023));
        expManager.addExpense(new Expense(300f, ExpenseCategory.FOOD_DRINKS, System.currentTimeMillis(), 4, month, 2023));
        expManager.addExpense(new Expense(250F, ExpenseCategory.GIFTS, System.currentTimeMillis(), 3, month, 2023));
        expManager.addExpense(new Expense(50f, ExpenseCategory.BEAUTY, System.currentTimeMillis(), 2, month, 2023));
        expManager.addExpense(new Expense(250f, ExpenseCategory.SHOPPING, System.currentTimeMillis(), 1, month, 2023));
        expManager.addExpense(new Expense(250f, ExpenseCategory.GROCERY, System.currentTimeMillis(), 29, 10, 2023));
        expManager.addExpense(new Expense(150f, ExpenseCategory.FOOD_DRINKS, System.currentTimeMillis(), 29, 9, 2023));
        expManager.addExpense(new Expense(450f, ExpenseCategory.BILLS_FEES, System.currentTimeMillis(), 29, 8, 2023));
        expManager.addExpense(new Expense(650f, ExpenseCategory.TRANSPORT, System.currentTimeMillis(), 20, 7, 2023));
    }

    private void updatePieChart(List<Expense> expenses) {
        ArrayList<PieEntry> list = new ArrayList<>();

        for (Expense expense : expenses) {
            list.add(new PieEntry(expense.getAmount(), expense.getCategory().getDisplayName()));
        }

        int[] colors = new int[]{
                Color.rgb(255, 83, 83),   // Red
                Color.rgb(230, 159, 0),   // Orange
                Color.rgb(240, 228, 66),  // Yellow
                Color.rgb(0, 158, 115),   // Green
                Color.rgb(0, 114, 178),   // Blue
                Color.rgb(86, 180, 233),  // Cyan
                Color.rgb(204, 121, 167)   // Pink
        };

        PieDataSet pieDataSet = new PieDataSet(list, "Categories");
        pieDataSet.setColors(colors, 255);
        pieDataSet.setValueTextSize(15f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setSliceSpace(1f);
        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData pieData = new PieData(pieDataSet);
        pieData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.format("%.1f%%", value);
            }
        });

        pieChart.setData(pieData);
        pieChart.setHoleColor(Color.BLACK);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.animateY(500);
    }
}


