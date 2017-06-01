package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Calculator;

import java.util.Date;
import java.util.List;

public interface CalculatorService {
    void saveCalculators();
    String calculate(Calculator calculator, Calculator prevCalc);
    List<Calculator> findAllByTime(Date dateTime);
}
