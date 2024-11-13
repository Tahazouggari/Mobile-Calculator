package com.example.calculatrice;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorViewModel viewModel;
    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);
        displayTextView = findViewById(R.id.displayTextView);

        viewModel.getDisplay().observe(this, displayTextView::setText);

        setupNumberButtons();
        setupOperatorButtons();
        setupControlButtons();
    }

    private void setupNumberButtons() {
        int[] numberButtonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
        };

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            viewModel.onNumberClick(button.getText().toString());
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(listener);
        qqqqaaaaaqqa}
    }

    private void setupOperatorButtons() {
        int[] operatorButtonIds = {
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide
        };

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            viewModel.onOperatorClick(button.getText().toString());
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setupControlButtons() {
        findViewById(R.id.buttonEquals).setOnClickListener(view -> viewModel.onEqualsClick());
        findViewById(R.id.buttonClear).setOnClickListener(view -> viewModel.onClearClick());
    }
}
