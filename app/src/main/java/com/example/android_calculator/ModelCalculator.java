package com.example.android_calculator;

public class ModelCalculator implements AppInterface.InterfaceModel {
    private final Presenter presenter;

    private double number = 0;
    private double numberDot  = 0;
    private double saveNumber = 0;

    private boolean flagDot = false;
    private String flagAction;
    private int counter = 1;

    public ModelCalculator(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void changesAction(String buttonName) {
        if (buttonName.equals(".")) flagDot = true;
        if (buttonName.equals("+")) {
            saveNumber = number + (numberDot / counter);
            flagAction = "+";
            reset();
        }
        if (buttonName.equals("-")) {
            saveNumber = number + (numberDot / counter);
            flagAction = "-";
            reset();
        }
        if (buttonName.equals("*")) {
            saveNumber = number + (numberDot / counter);
            flagAction = "*";
            reset();
        }
        if (buttonName.equals("/")) {
            saveNumber = number + (numberDot / counter);
            flagAction = "/";
            reset();
        }
        if (buttonName.equals("C")) {
            reset();
            presenter.clearText();
        }
        if (buttonName.equals("=")) {
            double saveNumber2 = number + (numberDot / counter);

            if (flagAction.equals("+")) presenter.setAnswerText( plus(saveNumber, saveNumber2));
            if (flagAction.equals("-")) presenter.setAnswerText( mines(saveNumber, saveNumber2));
            if (flagAction.equals("*")) presenter.setAnswerText( multiply(saveNumber, saveNumber2));
            if (flagAction.equals("/")) presenter.setAnswerText( div(saveNumber, saveNumber2));
        }
    }

    @Override
    public void changesNumber(int buttonName) {
        if (flagDot) {
            numberDot = numberDot * 10 + buttonName;
            counter   = counter   * 10;
        } else {
            number = number * 10 + buttonName;
        }
        presenter.setText(number + (numberDot / counter),flagDot);
    }
    private void reset() {
        number    = 0;
        numberDot = 0;
        counter   = 1;
        flagDot   = false;
    }
    private double plus(double a, double b) {
        return a + b;
    }
    private double mines(double a, double b) {
        return a - b;
    }
    private double multiply(double a, double b) {
        return a * b;
    }
    private double div(double a, double b) {
        return a / b;
    }
}
