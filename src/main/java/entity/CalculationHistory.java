package  com.example.calculatorhub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "calculations")
public class CalculationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;   // EMI, BMI, etc
    private double input1;
    private double input2;
    private double result;

    public CalculationHistory() {}

    public CalculationHistory(String type, double input1, double input2, double result) {
        this.type = type;
        this.input1 = input1;
        this.input2 = input2;
        this.result = result;
    }

    // getters and setters
    public Long getId() { return id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getInput1() { return input1; }
    public void setInput1(double input1) { this.input1 = input1; }

    public double getInput2() { return input2; }
    public void setInput2(double input2) { this.input2 = input2; }

    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
}