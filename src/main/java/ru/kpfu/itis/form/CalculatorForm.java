package ru.kpfu.itis.form;


public class CalculatorForm {
    private String digit;
    private String mathaction;
    public CalculatorForm(String digit, String mathaction){
        if(digit == null) {
            this.digit = "0";
        }
        else{ this.digit = digit; }
        if(mathaction == null) {
            this.mathaction = "=";
        }
        else { this.mathaction = mathaction; }
    }
    public CalculatorForm(){

    }
    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }


    public String getMathaction() {
        return mathaction;
    }

    public void setMathaction(String mathaction) {
        this.mathaction = mathaction;
    }

}
