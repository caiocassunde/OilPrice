package br.com.caiosabino.oilprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private TextView gasolineTextView;
    private TextView priceGasolineTextView;
    private TextView ethanolTextView;
    private TextView priceEthanolTextView;
    private double price = 2.5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasolineTextView = findViewById(R.id.gasolineTextView);
        priceGasolineTextView = findViewById(R.id.priceGasolineTextView);
        ethanolTextView = findViewById(R.id.ethanolTextView);
        priceEthanolTextView = findViewById(R.id.priceEthanolTextView);
        priceGasolineTextView.setText(currencyFormat.format(price));
        priceEthanolTextView.setText(currencyFormat.format(price));
        SeekBar gasolineSeekBar = findViewById(R.id.gasolineSeekBar);
        gasolineSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        price = progress / 100.;
                        String valorFormatado = currencyFormat.format(price);
                        priceGasolineTextView.setText(valorFormatado);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        SeekBar ethanolSeekBar = findViewById(R.id.ethanolSeekBar);
        ethanolSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        price = progress / 100.;
                        String valorFormatado = currencyFormat.format(price);
                        priceEthanolTextView.setText(valorFormatado);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
}