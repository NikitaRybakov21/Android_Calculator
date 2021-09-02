package com.example.android_calculator;

public class Presenter implements AppInterface.InterfacePresenter {
    private final AppInterface.InterfaceModel model = new ModelCalculator();
    private final MainActivity activity;

    public Presenter(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public void pressedButtonActions(String buttonName) {
        setAnswerText(model.changesAction(buttonName));
    }

    @Override
    public void pressedButtonNumber(int buttonName) {
        setText(model.changesNumber(buttonName),model.getFlagDot());
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
