package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textDisplay;
    Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
            buttonSeven, buttonEight, buttonNine, buttonAdd, buttonSubtract, buttonMultiply,
            buttonDivide, buttonDecimal, buttonEquals, buttonClear;

    String currentInput = "";
    double firstOperand = 0;
    String operator = "";
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        textDisplay = findViewById(R.id.textDisplay);
        buttonZero = findViewById(R.id.buttonZero);
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDecimal = findViewById(R.id.buttonDecimal);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonClear = findViewById(R.id.buttonClear);

        // Set OnClickListener for all buttons
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) { // Use android.view.View here
                android.widget.Button button = (android.widget.Button) view; // Explicit cast
                String buttonText = button.getText().toString();

                switch (buttonText) {
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                        currentInput += buttonText;
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        if (!currentInput.isEmpty()) {
                            firstOperand = Double.parseDouble(currentInput);
                            operator = buttonText;
                            currentInput = "";
                        }
                        break;
                    case ".":
                        if (!currentInput.contains(".")) {
                            currentInput += ".";
                        }
                        break;
                    case "=":
                        if (!currentInput.isEmpty() && !operator.isEmpty()) {
                            double secondOperand = Double.parseDouble(currentInput);
                            result = calculateResult(firstOperand, secondOperand, operator);
                            currentInput = String.valueOf(result);
                            operator = "";
                        }
                        break;
                    case "C":
                        currentInput = "";
                        firstOperand = 0;
                        operator = "";
                        result = 0;
                        break;
                }

                textDisplay.setText(currentInput);
            }
        };

        buttonZero.setOnClickListener(buttonClickListener);
        buttonOne.setOnClickListener(buttonClickListener);
        buttonTwo.setOnClickListener(buttonClickListener);
        buttonThree.setOnClickListener(buttonClickListener);
        buttonFour.setOnClickListener(buttonClickListener);
        buttonFive.setOnClickListener(buttonClickListener);
        buttonSix.setOnClickListener(buttonClickListener);
        buttonSeven.setOnClickListener(buttonClickListener);
        buttonEight.setOnClickListener(buttonClickListener);
        buttonNine.setOnClickListener(buttonClickListener);
        buttonAdd.setOnClickListener(buttonClickListener);
        buttonSubtract.setOnClickListener(buttonClickListener);
        buttonMultiply.setOnClickListener(buttonClickListener);
        buttonDivide.setOnClickListener(buttonClickListener);
        buttonDecimal.setOnClickListener(buttonClickListener);
        buttonEquals.setOnClickListener(buttonClickListener);
        buttonClear.setOnClickListener(buttonClickListener);
    }

    private double calculateResult(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    return Double.NaN; // Handle division by zero
                }
            default:
                return 0;
        }
    }
}