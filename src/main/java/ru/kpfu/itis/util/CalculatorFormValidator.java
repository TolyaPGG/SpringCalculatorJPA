package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.form.CalculatorForm;

public class CalculatorFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CalculatorForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CalculatorForm calc = (CalculatorForm) o;
        if (calc.getDigit() == null || calc.getDigit().isEmpty()) {
            errors.rejectValue("digit", "", "Digit can not be empty");
        }
        else{
            try{
                double digit = Double.parseDouble(calc.getDigit());
            }catch (NumberFormatException ex){
                errors.rejectValue("digit", "", "Digit must be a number");
            }
        }
        if (calc.getMathaction() == null || (!calc.getMathaction().equals("+") && !calc.getMathaction().equals("-")
                && !calc.getMathaction().equals("*") && !calc.getMathaction().equals("/") && !calc.getMathaction().equals("="))) {
            errors.rejectValue("mathaction", "", "Incorrect operation");
        }
    }
}
