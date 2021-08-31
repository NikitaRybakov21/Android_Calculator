package com.example.android_calculator;

public class ModelCalculator implements AppInterface.InterfaceModel {
    private double number = 0;
    private double numberDot  = 0;
    private double saveNumber = 0;

    private boolean flagDot = false;
    private String flagAction;
    private int counter = 1;

    @Override
    public double changesAction(String buttonName) {
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
        }
        if (buttonName.equals("=")) {
            double saveNumber2 = number + (numberDot / counter);

            if (flagAction.equals("+")) return plus(saveNumber, saveNumber2);
            if (flagAction.equals("-")) return mines(saveNumber, saveNumber2);
            if (flagAction.equals("*")) return multiply(saveNumber, saveNumber2);
            if (flagAction.equals("/")) return div(saveNumber, saveNumber2);
        }
        return 0;
    }

    @Override
    public double changesNumber(int buttonName) {
        if (flagDot) {
            numberDot = numberDot * 10 + buttonName;
            counter   = counter   * 10;
        } else {
            number = number * 10 + buttonName;
        }
        return number + (numberDot / counter);
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

    @Override
    public boolean getFlagDot(){
        return flagDot;
    }
}
