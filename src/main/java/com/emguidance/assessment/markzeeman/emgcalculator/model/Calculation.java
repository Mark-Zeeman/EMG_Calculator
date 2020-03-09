package com.emguidance.assessment.markzeeman.emgcalculator.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private double inputNumber1;
    private double inputNumber2;
    private String operator;
    private String answer;
    private Date dateCreated;

    public double getInputNumber1() {
        return inputNumber1;
    }

    public void setInputNumber1(double inputNumber1) {
        this.inputNumber1 = inputNumber1;
    }

    public double getInputNumber2() {
        return inputNumber2;
    }

    public void setInputNumber2(double inputNumber2) {
        this.inputNumber2 = inputNumber2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
