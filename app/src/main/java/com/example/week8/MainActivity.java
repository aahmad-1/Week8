package com.example.week8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    EditText inputFirstNumber, inputSecondNumber;
    TextView textResult;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
    }

    public int getIntegerFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    public void onClick(View v) {
        num1 = getIntegerFromEditText(inputFirstNumber);
        num2 = getIntegerFromEditText(inputSecondNumber);
        int id = v.getId();

        if (id == R.id.buttonPlus) {
            textResult.setText(String.valueOf(num1 + num2));
        } else if (id == R.id.buttonMinus) {
            textResult.setText(String.valueOf(num1 - num2));
        } else if (id == R.id.buttonMultiply) {
            textResult.setText(String.valueOf(num1 * num2));
        } else if (id == R.id.buttonDivide) {
            if (num2 != 0) {
                textResult.setText(String.valueOf(num1 / num2));
            } else {
                textResult.setText("Cannot divide by zero");
            }
        }
    }
}