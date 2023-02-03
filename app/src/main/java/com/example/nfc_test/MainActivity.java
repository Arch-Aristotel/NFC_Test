package com.example.nfc_test;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private NfcAdapter mNFC;

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);
        mNFC = (NfcAdapter.getDefaultAdapter(this));
    }
    public void get_Start(View v){
        if(!mNFC.isEnabled())
        txt.setText("NFC Disabled");
        else{
            txt.setText("is good");

        }
    }
}