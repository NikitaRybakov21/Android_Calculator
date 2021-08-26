package com.example.android_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AppInterface.InterfaceActivity {
    private TextView textViewAnswer;
    private TextView textView;
    private SharedPreferences sharedPreferences;
    private static final String KEY_THEME = "key_theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        String theme = sharedPreferences.getString(KEY_THEME,"");
        if(theme.equals("DarkTheme")){
            setTheme(R.style.DarkTheme);
        }
        if(theme.equals("LightTheme")){
            setTheme(R.style.Theme_Android_Calculator);
        }

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textInput);
        textViewAnswer = findViewById(R.id.textViewAnswer);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);

        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonEqually = findViewById(R.id.buttonEqually);
        Button buttonClear = findViewById(R.id.buttonC);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonMines = findViewById(R.id.buttonMinus);
        Button buttonDiv = findViewById(R.id.buttonDiv);

        Button switch1 = findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((Switch) view).isChecked();
                if (checked){
                    saveTheme("DarkTheme");
                }
                else{
                    saveTheme("LightTheme");
                }
                recreate();
            }
        });

        AppInterface.InterfacePresenter presenter = new Presenter(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber( 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(6);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(7);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(8);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(9);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonNumber(0);
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonActions(".");
            }
        });
        buttonEqually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonActions("=");
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonActions("+");
            }
        });
        buttonMines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonActions("-");
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonActions("*");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonActions("/");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.pressedButtonActions("C");
            }
        });
    }

    @Override
    public void outputTextDouble(double result) {
        String num = Double.toString(result);
        textView.setText(num);
    }

    @Override
    public void outputTextInt(double result) {
        String num = Integer.toString((int) result);
        textView.setText(num);
    }

    @Override
    public void outputAnswer(double result) {
        String num = Double.toString(result);
        textViewAnswer.setText(num);
    }

    @Override
    public void clearText() {
        textViewAnswer.setText("");
        textView.setText("");
    }

    private void saveTheme(String theme){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        sharedPreferences.edit().putString(KEY_THEME,theme).apply();
    }
}
