package com.example.calculatorhub.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

@Service
public class CalculatorService {

    // ================= FINANCE =================

    // EMI (Compound Interest)
    public double emi(double principal, double rate, int time) {
        double r = rate / (12 * 100);
        return (principal * r * Math.pow(1 + r, time)) /
                (Math.pow(1 + r, time) - 1);
    }


    // GST
    public double gst(double amount, double rate) {
        return amount + (amount * rate / 100);
    }

    // ROI
    public double roi(double gain, double investment) {
        return ((gain - investment) / investment) * 100;
    }

    // Simple Interest
    public double interest(double p, double r, double t) {
        return (p * r * t) / 100;
    }

    // Break-even
    public double breakEven(double fixedCost, double price, double variableCost) {
        double denominator = price - variableCost;

        if (denominator <= 0) {
            return 0; // prevent negative or error
        }

        return fixedCost / denominator;
    }

    // ================= PERSONAL =================

    // Percentage
    public double percentage(double obtained, double total) {
        return (obtained / total) * 100;
    }

    // Time Duration (Readable)
    public String timeDuration(String start, String end) {
        LocalTime s = LocalTime.parse(start);
        LocalTime e = LocalTime.parse(end);

        if (e.isBefore(s)) {
            e = e.plusHours(24);
        }

        Duration d = Duration.between(s, e);

        long hours = d.toHours();
        long minutes = d.toMinutes() % 60;

        return hours + " hours " + minutes + " minutes";
    }
    // DATE DIFF
    public long dateDiff(String start, String end) {
        return java.time.temporal.ChronoUnit.DAYS.between(
                LocalDate.parse(start),
                LocalDate.parse(end)
        );
    }
    // Age
    public int age(int birthYear) {
        int currentYear = LocalDate.now().getYear();
        return currentYear - birthYear;
    }

    // ================= HEALTH =================

    // BMI
    public double bmi(double weight, double height) {
        return weight / (height * height);
    }

    // Calories
    public double calories(double weight) {
        return weight * 30;
    }

    // Water Intake
    public double water(double weight) {
        return weight * 0.033;
    }

    // Pregnancy Due Date (NEW)
    public LocalDate pregnancy(String lastPeriod) {
        return LocalDate.parse(lastPeriod).plusDays(280);
    }

    // ================= BUSINESS =================

    // Startup Valuation
    public double startup(double revenue, double multiplier) {
        return revenue * multiplier;
    }

    // Profit Margin
    public double profit(double cost, double revenue) {
        double result = ((revenue - cost) / cost) * 100;
        return Math.round(result * 100.0) / 100.0;
    }

    // Cost Estimator
    public double cost(double fixedCost, double variableCost, int units) {
        return fixedCost + (variableCost * units);
    }
}