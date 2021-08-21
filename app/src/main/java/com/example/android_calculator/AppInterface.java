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
        void clearText();
        void setText(double result,boolean flagDot);
        void setAnswerText(double result);
    }
    interface InterfaceModel{
        void changesAction(String buttonName);
        void changesNumber(int buttonName);
    }
}
