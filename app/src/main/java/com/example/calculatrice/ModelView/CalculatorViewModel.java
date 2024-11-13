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

    private double value1 = 0.0;
    private String operator = null;
    private boolean isNewValue = true;

    public void onNumberClick(String number) {
        if (isNewValue) {
            display.setValue(number);
            isNewValue = false;
        } else {
            display.setValue(display.getValue() + number);
        }
    }

    public void onOperatorClick(String op) {
        value1 = Double.parseDouble(display.getValue() != null ? display.getValue() : "0");
        operator = op;
        isNewValue = true;
    }

    public void onEqualsClick() {
        double value2 = Double.parseDouble(display.getValue() != null ? display.getValue() : "0");
        double result = operator != null ? model.calculate(value1, value2, operator) : value1;
        display.setValue(String.valueOf(result));
        isNewValue = true;
    }

    public void onClearClick() {
        display.setValue("0");
        value1 = 0.0;
        operator = null;
        isNewValue = true;
    }
}
