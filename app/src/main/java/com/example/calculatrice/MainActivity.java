

package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.calculatrice.View.CalculatorView;

public class MainActivity extends AppCompatActivity {

    private CalculatorView calculatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the CalculatorView to manage UI interactions
        calculatorView = new CalculatorView(this, this);
    }
}
