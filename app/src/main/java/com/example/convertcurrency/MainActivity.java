package com.example.convertcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] currencies ={"VND(₫)","USA($)","JPY(¥)","CNY(¥)","EUR(€)","GBP(£)","RUB(₽)","KRW(₩)","AUD($)","SGD(S$)"};
    double[] converter = {1,23180.34,221.29,3467.41,27464.98,30284.68,304.60,20.55,16550.81,17064.85};
    //                   vietnam, my,  nhat, trung quoc,   eu,    anh,   nga, han quoc,uc,singgapo
    EditText amount;
    TextView result;
    Spinner spinnerfrom;
    Spinner spinnerto;
    int f;
    int t;
    double r;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount=(EditText)findViewById(R.id.amount);
        result=(TextView) findViewById(R.id.result);
        spinnerfrom=(Spinner)findViewById(R.id.spinnerfrom);
        spinnerto=(Spinner)findViewById(R.id.spinnerto);

        //ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,currencies);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.layout_item,
                R.id.text,
                currencies);

        spinnerfrom.setAdapter(adapter);
        spinnerto.setAdapter(adapter);

        spinnerfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                f=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                t=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    r= (float)Integer.parseInt(String.valueOf(amount.getText())) *converter[f] / converter[t];
                    result.setText(String.valueOf(r));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}