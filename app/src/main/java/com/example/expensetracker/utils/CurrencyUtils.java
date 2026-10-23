package com.example.expensetracker.utils;
import java.text.NumberFormat; import java.util.Locale;
public final class CurrencyUtils { private CurrencyUtils(){} public static String format(double amount){NumberFormat f=NumberFormat.getCurrencyInstance(new Locale("en","IN"));f.setMinimumFractionDigits(2);f.setMaximumFractionDigits(2);return f.format(amount);} }
