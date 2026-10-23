package com.example.expensetracker.data.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class TransactionEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public double amount;
    public String type; // "INCOME" or "EXPENSE"
    public String category;
    public String date;
    public String notes;

    public TransactionEntity(String title, double amount, String type,
                             String category, String date, String notes) {
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }
}
