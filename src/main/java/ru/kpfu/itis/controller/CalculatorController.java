package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.form.CalculatorForm;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalculatorService;
import ru.kpfu.itis.util.ToCalculatorTransformer;
import ru.kpfu.itis.util.CalculatorFormValidator;
import ru.kpfu.itis.util.MathErrors;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    CalculatorFormValidator validator = new CalculatorFormValidator();



    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String getCalculatorPage(HttpSession session, Model model) {
        Enumeration atts = session.getAttributeNames();
        while(atts.hasMoreElements()){
            Object o = atts.nextElement();
            session.setAttribute((String)o, null);
        }

        CalculatorForm calculatorForm = new CalculatorForm();
        model.addAttribute("calculatorForm", calculatorForm);
        return "calculator";
    }
    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public String calculate(HttpSession session, Model model, @ModelAttribute CalculatorForm calculatorForm, BindingResult result) {
        validator.validate(calculatorForm, result);
        if (result.hasErrors()) {
            return "calculator";
        } else {
            Calculator calculator = ToCalculatorTransformer.transform(calculatorForm);
            if(session.getAttribute("prevDigit") == null || session.getAttribute("prevMath") == null) {
                session.setAttribute("prevDigit", calculatorForm.getDigit());
                session.setAttribute("prevMath", calculatorForm.getMathaction());

                model.addAttribute("digit", calculatorForm.getDigit());
                model.addAttribute("mathaction", calculatorForm.getMathaction());
                return "calculator";
            }

            Calculator prevCalc = new Calculator((String)session.getAttribute("prevDigit"), (String)session.getAttribute("prevMath"));
            String calculationResult = calculatorService.calculate(calculator, prevCalc);
            for (MathErrors error : MathErrors.values()) {
                if(calculationResult.equals(error.toString())){
                    model.addAttribute("matherror", error.toString());
                    model.addAttribute("digit", prevCalc.getDigit());
                    model.addAttribute("mathaction", prevCalc.getMathaction());
                    return "calculator";
                }
            }
            model.addAttribute("digit", calculationResult);
            model.addAttribute("mathaction", calculator.getMathaction());
            if(!calculator.getMathaction().equals("=")) {
                session.setAttribute("prevDigit", calculationResult);
                session.setAttribute("prevMath", calculator.getMathaction());
            }else{
                session.setAttribute("prevDigit", null);
                session.setAttribute("prevMath", null);
            }
            return "calculator";
        }
    }

}
