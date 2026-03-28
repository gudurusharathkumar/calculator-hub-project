package com.example.calculatorhub.controller;

import com.example.calculatorhub.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/calculators")
@CrossOrigin
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    private Map<String, Object> response(Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put("result", value);
        return map;
    }

    @GetMapping("/emi")
    public Map<String, Object> emi(double principal, double rate, int time) {
        return response(service.emi(principal, rate, time));
    }

    @GetMapping("/gst")
    public Map<String, Object> gst(double amount, double rate) {
        return response(service.gst(amount, rate));
    }

    @GetMapping("/roi")
    public Map<String, Object> roi(double gain, double investment) {
        return response(service.roi(gain, investment));
    }

    @GetMapping("/interest")
    public Map<String, Object> interest(double p, double r, double t) {
        return response(service.interest(p, r, t));
    }

    @GetMapping("/break-even")
    public Map<String, Object> breakEven(double fixedCost, double pricePerUnit, double variableCost) {
        return response(service.breakEven(fixedCost, pricePerUnit, variableCost));
    }

    @GetMapping("/time-duration")
    public Map<String, Object> timeDuration(String start, String end) {
        return response(service.timeDuration(start, end));
    }

    @GetMapping("/date-diff")
    public Map<String, Object> dateDiff(String start, String end) {
        return response(service.dateDiff(start, end));
    }

    @GetMapping("/bmi")
    public Map<String, Object> bmi(double weight, double height) {
        return response(service.bmi(weight, height));
    }

    @GetMapping("/percentage")
    public Map<String, Object> percentage(double obtained, double total) {
        return response(service.percentage(obtained, total));
    }

    @GetMapping("/age")
    public Map<String, Object> age(int birthYear) {
        return response(service.age(birthYear));
    }

    @GetMapping("/calories")
    public Map<String, Object> calories(double weight) {
        return response(service.calories(weight));
    }

    @GetMapping("/water")
    public Map<String, Object> water(double weight) {
        return response(service.water(weight));
    }

    @GetMapping("/pregnancy")
    public Map<String, Object> pregnancy(String lastPeriod) {
        return response(service.pregnancy(lastPeriod));
    }
    @GetMapping("/startup")
    public Map<String, Object> startup(double revenue, double multiplier) {
        return response(service.startup(revenue, multiplier));
    }


    @GetMapping("/profit")
    public Map<String, Object> profit(double cost, double revenue) {
        return response(service.profit(cost, revenue));
    }

    @GetMapping("/cost")
    public Map<String, Object> cost(double fixedCost, double variableCost, int units) {
        return response(service.cost(fixedCost, variableCost, units));
    }
}