package com.example.nfc_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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





    public void NFC(Intent i){
        String type = i.getType();
        String action = i.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)){


        }
    }



}