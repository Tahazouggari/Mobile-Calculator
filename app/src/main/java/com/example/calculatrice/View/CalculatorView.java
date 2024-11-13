// CalculatorView.java

package com.example.calculatrice.View;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatrice.ModelView.CalculatorViewModel;
import com.example.calculatrice.R;

public class CalculatorView {

    private final CalculatorViewModel viewModel;
    private final TextView displayTextView;

    public CalculatorView(AppCompatActivity activity, LifecycleOwner lifecycleOwner) {

        viewModel = new ViewModelProvider(activity).get(CalculatorViewModel.class);


        displayTextView = activity.findViewById(R.id.displayTextView);


        viewModel.getDisplay().observe(lifecycleOwner, displayTextView::setText);


        setupNumberButtons(activity);
        setupOperatorButtons(activity);
        setupControlButtons(activity);
    }

    private void setupNumberButtons(AppCompatActivity activity) {
        int[] numberButtonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
        };

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            viewModel.onNumberClick(button.getText().toString());
        };

        for (int id : numberButtonIds) {
            activity.findViewById(id).setOnClickListener(listener);
        }
    }

    private void setupOperatorButtons(AppCompatActivity activity) {
        int[] operatorButtonIds = {
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide
        };

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            viewModel.onOperatorClick(button.getText().toString());
        };

        for (int id : operatorButtonIds) {
            activity.findViewById(id).setOnClickListener(listener);
        }
    }

    private void setupControlButtons(AppCompatActivity activity) {
        activity.findViewById(R.id.buttonEquals).setOnClickListener(view -> viewModel.onEqualsClick());
        activity.findViewById(R.id.buttonClear).setOnClickListener(view -> viewModel.onClearClick());
        activity.findViewById(R.id.PlusMins).setOnClickListener(view -> viewModel.onPlusMins());
        activity.findViewById(R.id.buttonPercent).setOnClickListener(view -> viewModel.onPerCentClick());
        activity.findViewById(R.id.buttondot).setOnClickListener(view -> viewModel.onDot());
    }
}
