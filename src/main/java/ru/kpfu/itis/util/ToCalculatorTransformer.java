package ru.kpfu.itis.util;


import ru.kpfu.itis.form.CalculatorForm;
import ru.kpfu.itis.model.Calculator;

import java.util.Date;

public class ToCalculatorTransformer {


    public static Calculator transform(CalculatorForm form) {
        if (form == null) {
            return null;
        }
        Calculator calculator = new Calculator();
        calculator.setDigit(form.getDigit());
        calculator.setMathaction(form.getMathaction());
        calculator.setTime(new Date());
        return calculator;
    }
}
