package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalculatorService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/history")
public class HistoryController {
    @Autowired
    CalculatorService calculatorService;
    @RequestMapping(method = RequestMethod.GET)
    public String getHistory(Model model){
        List<Calculator> calculators = calculatorService.findAllByTime(new Date());;
        model.addAttribute("calculators", calculators);
        return "history";
    }
}
