package tomerbu.edu.layoutandeventsdemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton radioCelsius, radioFahrenheit;
    EditText etTemp;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioCelsius = (RadioButton) findViewById(R.id.radioCelsius);
        radioFahrenheit = (RadioButton) findViewById(R.id.radioFaherenheit);
        etTemp = (EditText) findViewById(R.id.etTemp);
        btnCalc = (Button) findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String tempString = etTemp.getText().toString();
            double temp = Double.valueOf(tempString);
            String symbol = " C";
            if (radioCelsius.isChecked()){
                //convert from fah to celsius:
                temp = (temp - 32) * 5 / 9;
            }else {
                temp = 32 + 9/5 * temp;
                symbol = " F";
            }
            etTemp.setText(String.format("%f%s", temp, symbol));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
