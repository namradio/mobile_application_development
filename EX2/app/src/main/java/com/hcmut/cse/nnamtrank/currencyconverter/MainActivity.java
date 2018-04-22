package com.hcmut.cse.nnamtrank.currencyconverter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private EditText Input;
    private TextView Output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        Input = (EditText) findViewById(R.id.InputEditText);
        Output = (TextView) findViewById(R.id.OutputTextView);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list1 = new ArrayList<String>();
        list1.add("EUR - Euro");
        list1.add("JPY - Japanese Yen");
        list1.add("GBP - British Pound");
        list1.add("CAD - Canadian Dollar");
        list1.add("VND - Vietnam Dong");
        list1.add("USD - United States Dollar");
        list1.add("AUD - Australian Dollar");
        list1.add("CNY - Chinese Yuan");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);


        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list2 = new ArrayList<String>();
        list1.add("EUR - Euro");
        list1.add("JPY - Japanese Yen");
        list1.add("GBP - British Pound");
        list1.add("CAD - Canadian Dollar");
        list1.add("VND - Vietnam Dong");
        list1.add("USD - United States Dollar");
        list1.add("AUD - Australian Dollar");
        list1.add("CNY - Chinese Yuan");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
    }

    public void onClick(View v) {

        int index1 = spinner1.getSelectedItemPosition();
        int index2 = spinner2.getSelectedItemPosition();
        float value = Float.parseFloat(Input.getText().toString());

    /* we have 8 units to convert from and to.
     * that means 8*8 = 64 cases!
     * to minimize work we convert from any selected unit to USD
     * then we convert from USD to the desired unit.
     */

        // ratios from google convertor
        float ratio[] = {0.81380f, 107.6650f, 1.4003f, 1.2783f, 22753.0000f, 1.0f, 1.3032f, 6.2942f};
        float result = value / ratio[index1] * ratio[index2];
        Output.setText(result + "");
    }
}