package com.example.isacclee.firsthello;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static android.nfc.NdefRecord.createMime;

public class DeviceConfigureActivity extends AppCompatActivity{

    private NfcAdapter mNfcAdapter;
    TextView textViewID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_configure);

        textViewID =(TextView) findViewById(R.id.textView4);
//        TextView price = findViewById(R.id.textView5);
//        TextView orderInfo = findViewById(R.id.OrderInfo);
//        TextView expressState = findViewById(R.id.express_state);
//        TextView expressID = findViewById(R.id.expressid);
        //getArgument获取传递过来的Bundle对象
//        name.setText(getArguments().getString("name"));
//        orderInfo.setText(getArguments().getString("OrderInfo"));
//        price.setText(getArguments().getString("price"));
//        expressID.setText(getArguments().getString("ExpressID"));
//        expressState.setText(getArguments().getString("ExpressState"));

//        // Check for available NFC Adapter
//        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
//        if (mNfcAdapter == null) {
//            textViewID.setText("NFC Not Found.");
//        }
//        // Register callback
//        mNfcAdapter.setNdefPushMessageCallback(this, this);
//    }
//
//    @Override
//    public NdefMessage createNdefMessage(NfcEvent event) {
//        String text;
//        NdefMessage msg;
//
//        text = ("hello");
//        msg = new NdefMessage(
//                new NdefRecord[] { createMime(
//                        "application/vnd.com.g08.swallow.dashbutton", text.getBytes())
//                        //,NdefRecord.createApplicationRecord("com.g08.swallow.dashbutton")
//                });
//
//        return msg;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        String action = getIntent().getAction();
//
//        textViewID.append(action);
////        processNDEFIntent(getIntent());
//        // Check to see that the Activity started due to an Android Beam
//        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
//            processNDEFIntent(getIntent());
//        }
//    }
//
//    @Override
//    public void onNewIntent(Intent intent) {
//        // onResume gets called after this to handle the intent
//        setIntent(intent);
//    }
//
//    /**
//     * Parses the NDEF Message from the intent and prints to the TextView
//     */
//    void processNDEFIntent(Intent intent) {
//        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
//                NfcAdapter.EXTRA_NDEF_MESSAGES);
//        // only one message sent during the beam
//        NdefMessage msgID = (NdefMessage) rawMsgs[0];
//        textViewID.append("\nempty message");
//        if (null != msgID){
//            textViewID.append("\nnot null");
//            textViewID.append(new String(msgID.getRecords()[0].getPayload()));
//            textViewID.append("\n");
//        }
    }
}
