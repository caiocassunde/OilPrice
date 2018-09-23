package br.com.caiosabino.oilprice;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private TextView priceGasolineTextView;
    private TextView priceEthanolTextView;
    private TextView resultTextView;
    private double priceGasoline = 2.5;
    private double priceEthanol = 2.5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceGasolineTextView = findViewById(R.id.priceGasolineTextView);
        priceEthanolTextView = findViewById(R.id.priceEthanolTextView);
        resultTextView = findViewById(R.id.resultTextView);
        priceGasolineTextView.setText(currencyFormat.format(priceGasoline));
        priceEthanolTextView.setText(currencyFormat.format(priceEthanol));

        final SeekBar gasolineSeekBar = findViewById(R.id.gasolineSeekBar);
        final SeekBar ethanolSeekBar = findViewById(R.id.ethanolSeekBar);
        gasolineSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        priceGasoline = progress / 100.;
                        String valorFormatadoGasoline = currencyFormat.format(priceGasoline);
                        priceGasolineTextView.setText(valorFormatadoGasoline);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        ethanolSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        priceEthanol = progress / 100.;
                        String valorFormatadoEthanol = currencyFormat.format(priceEthanol);
                        priceEthanolTextView.setText(valorFormatadoEthanol);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        if(!(priceEthanol / priceGasoline >= 0.7)){
            resultTextView.setText("Ethanol");
        }
    }
}