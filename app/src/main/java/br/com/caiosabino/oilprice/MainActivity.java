package br.com.caiosabino.oilprice;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.invoke.MethodHandleInfo;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private TextView priceGasolineTextView;
    private TextView priceEthanolTextView;
    private TextView resultTextView;
    private ImageView oilImageView;
    private double priceGasoline = 2.5;
    private double priceEthanol = 2.5;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceGasolineTextView = findViewById(R.id.priceGasolineTextView);
        priceEthanolTextView = findViewById(R.id.priceEthanolTextView);
        resultTextView = findViewById(R.id.resultTextView);
        priceGasolineTextView.setText(currencyFormat.format(priceGasoline));
        priceEthanolTextView.setText(currencyFormat.format(priceEthanol));
        oilImageView = findViewById(R.id.oilImageView);

        final SeekBar gasolineSeekBar = findViewById(R.id.gasolineSeekBar);
        final SeekBar ethanolSeekBar = findViewById(R.id.ethanolSeekBar);

        Dinamic dinamic = new Dinamic();
        dinamic.changeImageAndText(priceEthanol, priceGasoline);

        gasolineSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        priceGasoline = progress / 100.;
                        String formattedValueGasoline = currencyFormat.format(priceGasoline);
                        priceGasolineTextView.setText(formattedValueGasoline);
                        Dinamic dinamic = new Dinamic();
                        dinamic.changeImageAndText(priceEthanol, priceGasoline);
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
                        String formattedValueGasoline = currencyFormat.format(priceEthanol);
                        priceEthanolTextView.setText(formattedValueGasoline);
                        Dinamic dinamic = new Dinamic();
                        dinamic.changeImageAndText(priceEthanol, priceGasoline);
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

    public class Dinamic {
        public void changeImageAndText(double priceEthanol, double priceGasoline){
            if((priceEthanol / priceGasoline >= 0.7)) {
                oilImageView.setImageResource(R.drawable.gasolineImage);
                resultTextView.setText(R.string.gasoline);
            }
            else{
                oilImageView.setImageResource(R.drawable.ethanolImage);
                resultTextView.setText(R.string.ethanol);
            }
        }
    }
}