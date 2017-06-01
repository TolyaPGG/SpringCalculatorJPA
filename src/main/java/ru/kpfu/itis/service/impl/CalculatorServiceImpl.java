package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.repository.CalculatorRepository;
import ru.kpfu.itis.service.CalculatorService;
import ru.kpfu.itis.util.MathErrors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    CalculatorRepository calculatorRepository;

    List<Calculator> calculatorList = new ArrayList<>();

    @Override
    public void saveCalculators(){
        Date now = new Date();
        for(Calculator c : calculatorList){
            Date cTime = c.getTime();
            if(cTime.getDay() == now.getDay() && cTime.getHours() == now.getHours()){
                calculatorRepository.save(c);

            }
        }
    }
    @Override
    public String calculate(Calculator calculator, Calculator prevCalc) {
        double prevDigit = Double.parseDouble(prevCalc.getDigit());
        double newDigit = Double.parseDouble(calculator.getDigit());
        double result;
        if(calculator.getMathaction().equals("+")){
           result = prevDigit + newDigit;
        }else if(calculator.getMathaction().equals("-")){
            result = prevDigit - newDigit;
        }else if(calculator.getMathaction().equals("*")){
            result = prevDigit * newDigit;
        }else if(calculator.getMathaction().equals("/")){
            if(newDigit != 0)
                result = prevDigit / newDigit;
            else{
                return MathErrors.DivisionByZero.toString();
            }
        }else{
            result = newDigit;
        }
        calculatorList.add(calculator);
        calculatorRepository.save(calculator);
        return String.valueOf(result);
    }

    @Override
    public List<Calculator> findAllByTime(Date dateTime) {
        return calculatorRepository.findAllByTime(dateTime);
    }
}
