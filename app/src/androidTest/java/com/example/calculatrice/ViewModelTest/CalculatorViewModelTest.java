package com.example.calculatrice.ViewModelTest;



import androidx.lifecycle.MutableLiveData;

import com.example.calculatrice.Model.CalculatorModel;
import com.example.calculatrice.ModelView.CalculatorViewModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorViewModelTest {

    private CalculatorViewModel viewModel;
    private CalculatorModel mockModel;

    @BeforeEach
    void setUp() {
        mockModel = mock(CalculatorModel.class);
        viewModel = new CalculatorViewModel();
    }

    @Test
    void testOnNumberClick() {
        viewModel.onNumberClick("5");
        assertEquals("5", viewModel.getDisplay().getValue());

        viewModel.onNumberClick("3");
        assertEquals("53", viewModel.getDisplay().getValue());
    }

    @Test
    void testOnOperatorClick() {
        viewModel.onNumberClick("5");
        viewModel.onOperatorClick("+");
        viewModel.onNumberClick("3");

        when(mockModel.calculate(5.0, 3.0, "+")).thenReturn(8.0);

        viewModel.onEqualsClick();
        assertEquals("8.0", viewModel.getDisplay().getValue());
    }

    @Test
    void testOnEqualsClick() {
        viewModel.onNumberClick("10");
        viewModel.onOperatorClick("-");
        viewModel.onNumberClick("3");

        when(mockModel.calculate(10.0, 3.0, "-")).thenReturn(7.0);

        viewModel.onEqualsClick();
        assertEquals("7.0", viewModel.getDisplay().getValue());
    }

    @Test
    void testOnClearClick() {
        viewModel.onNumberClick("5");
        viewModel.onOperatorClick("+");
        viewModel.onClearClick();

        assertEquals("0", viewModel.getDisplay().getValue());
    }

    @Test
    void testOnPlusMinus() {
        viewModel.onNumberClick("5");

        when(mockModel.NegativeSign(5.0)).thenReturn(-5.0);

        viewModel.onPlusMins();
        assertEquals("-5.0", viewModel.getDisplay().getValue());
    }

    @Test
    void testOnPerCentClick() {
        viewModel.onNumberClick("50");

        when(mockModel.PerCent(50.0)).thenReturn(0.5);

        viewModel.onPerCentClick();
        assertEquals("0.5", viewModel.getDisplay().getValue());
    }
}