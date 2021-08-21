package com.example.android_calculator;

public class Presenter implements AppInterface.InterfacePresenter {
    private final AppInterface.InterfaceModel model = new ModelCalculator(this);
    private final MainActivity activity;

    public Presenter(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public void pressedButtonActions(String buttonName) {
        model.changesAction(buttonName);
    }

    @Override
    public void pressedButtonNumber(int buttonName) {
        model.changesNumber(buttonName);
    }

    @Override
    public void clearText() {
        this.activity.clearText();
    }

    @Override
    public void setText(double result,boolean flagDot) {
        if(flagDot) {
            this.activity.outputTextDouble(result);
        }
        else{
            this.activity.outputTextInt(result);
        }
    }

    @Override
    public void setAnswerText(double result) {
        this.activity.outputAnswer(result);
    }
}
