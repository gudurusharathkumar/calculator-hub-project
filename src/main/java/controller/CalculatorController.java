package com.example.calculatorhub.controller;

import com.example.calculatorhub.entity.CalculationHistory;
import com.example.calculatorhub.repository.CalculationRepository;
import com.example.calculatorhub.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/calculators")
@CrossOrigin
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @Autowired
    private CalculationRepository repo;

    //  HOME
    @GetMapping("/")
    public String home() {
        return "Calculator Hub Backend Running";
    }

    // ================= FINANCE =================

    @GetMapping("/gst")
    public Map<String, Double> gst(@RequestParam double amount, @RequestParam double rate) {
        Map<String, Double> res = new HashMap<>();
        res.put("gst", service.gst(amount, rate));
        save("GST", amount, rate, res.get("gst"));
        return res;
    }

    @GetMapping("/roi")
    public Map<String, Double> roi(@RequestParam double gain, @RequestParam double investment) {
        Map<String, Double> res = new HashMap<>();
        res.put("roi", service.roi(gain, investment));
        save("ROI", gain, investment, res.get("roi"));
        return res;
    }

    @GetMapping("/interest")
    public Map<String, Double> interest(@RequestParam double p,
                                        @RequestParam double r,
                                        @RequestParam double t) {

        Map<String, Double> res = new HashMap<>();
        res.put("interest", service.interest(p, r, t));
        save("INTEREST", p, r, res.get("interest"));
        return res;
    }

    @GetMapping("/break-even")
    public Map<String, Double> breakEven(@RequestParam double fixedCost,
                                         @RequestParam double price,
                                         @RequestParam double variableCost) {

        Map<String, Double> res = new HashMap<>();
        res.put("breakEven", service.breakEven(fixedCost, price, variableCost));
        save("BREAK_EVEN", fixedCost, price, res.get("breakEven"));
        return res;
    }

    // ================= PERSONAL =================

    @GetMapping("/date-diff")
    public Map<String, Long> dateDiff(@RequestParam String start,
                                      @RequestParam String end) {

        Map<String, Long> res = new HashMap<>();
        res.put("days", service.dateDiff(start, end));
        return res;
    }

    @GetMapping("/time-duration")
    public Map<String, Long> timeDuration(@RequestParam String start,
                                          @RequestParam String end) {

        Map<String, Long> res = new HashMap<>();
        res.put("minutes", service.timeDuration(start, end));
        return res;
    }

    // ================= HEALTH =================

    @GetMapping("/bmi")
    public Map<String, Double> bmi(@RequestParam double weight,
                                   @RequestParam double height) {

        Map<String, Double> res = new HashMap<>();
        res.put("bmi", service.bmi(weight, height));
        save("BMI", weight, height, res.get("bmi"));
        return res;
    }

    @GetMapping("/calories")
    public Map<String, Double> calories(@RequestParam double weight) {

        Map<String, Double> res = new HashMap<>();
        res.put("calories", service.calories(weight));
        save("CALORIES", weight, 0, res.get("calories"));
        return res;
    }

    @GetMapping("/water")
    public Map<String, Double> water(@RequestParam double weight) {

        Map<String, Double> res = new HashMap<>();
        res.put("water", service.water(weight));
        save("WATER", weight, 0, res.get("water"));
        return res;
    }

    // ================= BUSINESS =================

    @GetMapping("/profit")
    public Map<String, Double> profit(@RequestParam double revenue,
                                      @RequestParam double cost) {

        Map<String, Double> res = new HashMap<>();
        res.put("profitMargin", service.profit(revenue, cost));
        save("PROFIT", revenue, cost, res.get("profitMargin"));
        return res;
    }

    @GetMapping("/startup")
    public Map<String, Double> startup(@RequestParam double revenue,
                                       @RequestParam double multiplier) {

        Map<String, Double> res = new HashMap<>();
        res.put("valuation", service.startup(revenue, multiplier));
        save("STARTUP", revenue, multiplier, res.get("valuation"));
        return res;
    }

    @GetMapping("/cost")
    public Map<String, Double> cost(@RequestParam double fixedCost,
                                    @RequestParam double variableCost,
                                    @RequestParam double units) {

        Map<String, Double> res = new HashMap<>();
        res.put("totalCost", service.cost(fixedCost, variableCost, units));
        save("COST", fixedCost, variableCost, res.get("totalCost"));
        return res;
    }

    // ================= HISTORY =================

    @GetMapping("/history")
    public List<CalculationHistory> getAll() {
        return repo.findAll();
    }

    //  FILTER
    @GetMapping("/history/filter")
    public List<CalculationHistory> filter(@RequestParam String type) {
        return repo.findByType(type);
    }

    //  DASHBOARD
    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {
        Map<String, Object> data = new HashMap<>();
        data.put("totalCalculations", repo.count());
        return data;
    }

    //  DELETE
    @DeleteMapping("/history/{id}")
    public String delete(@PathVariable int id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    // ================= SAVE METHOD =================

    private void save(String type, double input1, double input2, double result) {
        CalculationHistory h = new CalculationHistory();
        h.setType(type);
        h.setInput1(input1);
        h.setInput2(input2);
        h.setResult(result);
        repo.save(h);
    }
}