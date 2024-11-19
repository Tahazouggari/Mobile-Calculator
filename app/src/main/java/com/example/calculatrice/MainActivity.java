package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.calculatrice.View.CalculatorView;

public class MainActivity extends AppCompatActivity {

    private CalculatorView calculatorView;
    private String currentResult = ""; // Sauvegarde du résultat actuel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        calculatorView = new CalculatorView(this, this);


    }


}
