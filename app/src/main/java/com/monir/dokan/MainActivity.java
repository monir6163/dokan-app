package com.monir.dokan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView display, errorSellTitle, errorBuyTitle;
    EditText buyPrice, sellPrice;
    Button buttonCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buyPrice = findViewById(R.id.buyPrice);
        sellPrice = findViewById(R.id.sellPrice);
        buttonCal = findViewById(R.id.buttonCal);
        display = findViewById(R.id.display);

        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validation input field
               boolean check = validationInfo(buyPrice, sellPrice);
                if (check == true) {
                    float buyValue, sellValue, profit;
                    buyValue = Float.parseFloat(buyPrice.getText().toString());
                    sellValue = Float.parseFloat(sellPrice.getText().toString());

                    if (sellValue > buyValue) {
                        profit = sellValue - buyValue;
                        display.setText("মোট লাভ হয়েছে : " + profit + " টাকা");
                    } else if (sellValue == buyValue) {
                        display.setText("কোনো লাভ ক্ষতি হয়নি");
                    } else {
                        profit = buyValue - sellValue;
                        display.setText("মোট ক্ষতি হয়েছে : " + profit + " টাকা");
                    }
                }

            }
        });
    }

    private Boolean validationInfo(EditText buyPrice, EditText sellPrice) {
        if (buyPrice.length() == 0) {
            buyPrice.requestFocus();
            buyPrice.setError("আপনার কেনা দাম লিখুন");
            return false;
        } else if (sellPrice.length() == 0) {
            sellPrice.requestFocus();
            sellPrice.setError("আপনার বিক্রি দাম লিখুন");
            return false;
        } else {
            return true;
        }
    }
}