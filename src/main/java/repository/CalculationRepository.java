package com.example.calculatorhub.repository;

import com.example.calculatorhub.entity.CalculationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CalculationRepository extends JpaRepository<CalculationHistory, Integer> {

    List<CalculationHistory> findByType(String type);
}