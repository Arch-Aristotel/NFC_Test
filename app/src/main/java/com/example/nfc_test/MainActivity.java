package com.example.nfc_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NfcAdapter mNFC;
    String a;

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);




    }
    public void get_Start(View v){
        mNFC = (NfcAdapter.getDefaultAdapter(this));
        if(!mNFC.isEnabled())
        txt.setText("NFC Disabled");
        else{
            txt.setText("is good");
            NFC_Adapt(getIntent());
            txt.setText("Hello "+a);

        }

    }

    public void NFC_Adapt(Intent e){
        String word = e.getAction();
        if (mNFC.ACTION_TAG_DISCOVERED.equals(word) ||
                mNFC.ACTION_TECH_DISCOVERED.equals(word) ||
                    mNFC.ACTION_NDEF_DISCOVERED.equals(word)){
            Tag t = e.getParcelableExtra(mNFC.EXTRA_TAG);
            for(String w : t.getTechList()){
                w=a;
            }
        }
        else a="word";
    }





    public void NFC(Intent i){
        String type = i.getType();
        String action = i.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)){
            Parcelable[] parcs = i.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

            for (Parcelable p : parcs) {
                txt.setText(p.toString());
                }
        }
    }

}