package ru.kpfu.itis.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calculators")
public class Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String digit;

    private String mathaction;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Calculator(String digit, String mathaction){
        if(digit == null) {
            this.digit = "0";
        }
        else{ this.digit = digit; }
        if(mathaction == null) {
            this.mathaction = "=";
        }
        else { this.mathaction = mathaction; }
        this.time = new Date();
    }
    public Calculator(){

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
