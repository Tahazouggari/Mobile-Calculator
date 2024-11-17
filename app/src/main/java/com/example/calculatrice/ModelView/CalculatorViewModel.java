package com.example.calculatrice.ModelView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculatrice.Model.CalculatorModel;

public class CalculatorViewModel extends ViewModel {
    private final CalculatorModel model = new CalculatorModel();

    private final MutableLiveData<String> display = new MutableLiveData<>("0");
    public LiveData<String> getDisplay() {
        return display;
    }

    private double currentValue = 0.0;
    private double lastValue = 0.0;
    private String currentOperator = null;
    private boolean isNewInput = true;


    public void onNumberClick(String number) {

        if (isNewInput  ) {
            display.setValue(number);
            isNewInput = false;
        } else {

                display.setValue(display.getValue() + number);
        }
    }

    public void onOperatorClick(String op) {
        double inputValue = Double.parseDouble(display.getValue() != null ? display.getValue() : "0");

        if (currentOperator != null) {

            currentValue = model.calculate(currentValue, inputValue, currentOperator);
        } else {

            currentValue = inputValue;
        }

        display.setValue(String.valueOf(currentValue));


        currentOperator = op;
        isNewInput = true;
    }

    public void onEqualsClick() {

            double inputValue = Double.parseDouble(display.getValue() != null ? display.getValue() : "0");

            if (currentOperator != null) {

                currentValue = model.calculate(currentValue, inputValue, currentOperator);
                display.setValue(String.valueOf(currentValue));
                currentOperator = null;
                isNewInput = true;
            }


    }

    public void onClearClick() {
        display.setValue("0");
        currentValue = 0.0;
        lastValue = 0.0;
        currentOperator = null;
        isNewInput = true;
    }

    public void onPlusMins() {
        double value2 = Double.parseDouble(display.getValue() != null ? display.getValue() : "0");
        double negative = model.NegativeSign(value2);
        display.setValue(String.valueOf(negative));
    }

    public void onPerCentClick() {
        double value2 = Double.parseDouble(display.getValue() != null ? display.getValue() : "0");
        double percent = model.PerCent(value2);
        display.setValue(String.valueOf(percent));
    }

    public void onDot() {
        String currentDisplay = display.getValue();
        if (currentDisplay != null && !currentDisplay.contains(".")) {
            display.setValue(currentDisplay + ".");
        }
    }
}
