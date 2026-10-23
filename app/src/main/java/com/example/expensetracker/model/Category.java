package com.example.expensetracker.model;

public class Category {
    private final String name;
    private final String type;

    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public String getType() { return type; }
}
