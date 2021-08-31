package com.example.android_calculator;

public interface AppInterface {

    interface InterfaceActivity{
        void outputTextInt(double result);
        void outputTextDouble(double result);
        void outputAnswer(double result);
        void clearText();
    }
    interface InterfacePresenter{
        void pressedButtonActions(String buttonName);
        void pressedButtonNumber(int buttonName);
        void setText(double result,boolean flagDot);
        void setAnswerText(double result);
    }
    interface InterfaceModel{
        double changesAction(String buttonName);
        double changesNumber(int buttonName);
        boolean getFlagDot();
    }
}
