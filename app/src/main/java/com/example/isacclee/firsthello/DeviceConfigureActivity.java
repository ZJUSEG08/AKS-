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

public class DeviceConfigureActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback{

    private NfcAdapter mNfcAdapter;
    TextView textViewID;
    TextView DeviceInfo;
    TextView GoodsName;
    TextView price;
    TextView Address;
    TextView deviceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_configure);

        GoodsName =(TextView) findViewById(R.id.textView4);
        TextView price = (TextView)findViewById(R.id.textView5);
        TextView DeviceID = (TextView)findViewById(R.id.textView);
        TextView Address= (TextView)findViewById(R.id.textView7);
//        getArgument获取传递过来的Bundle对象

        Controller controller = new Controller();
        GoodsStructure goodsStructure = new GoodsStructure();
        goodsStructure = controller.GoodsInfo(getApplicationContext(),deviceID.getText().toString());
        GoodsName.setText(goodsStructure.getGoodsName());
        price.setText(goodsStructure.getPrice().toString());

        DeviceStructure deviceStructure = new DeviceStructure();
        deviceStructure.aksID = deviceID.getText().toString();
        controller.GetDevice(deviceStructure);
        Address.setText("收货人："+deviceStructure.receiverName+"\n地址："+deviceStructure.address+"\n邮编:"+deviceStructure.postCode+"\n电话:"+deviceStructure.phone);

        // Check for available NFC Adapter
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) {
            textViewID.setText("NFC Not Found.");
        }
        // Register callback
        mNfcAdapter.setNdefPushMessageCallback(this, this);
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        String text;
        NdefMessage msg;

        text = ("hello");
        msg = new NdefMessage(
                new NdefRecord[] { createMime(
                        "application/vnd.com.g08.swallow.dashbutton", text.getBytes())
                        //,NdefRecord.createApplicationRecord("com.g08.swallow.dashbutton")
                });

        return msg;
    }

    @Override
    public void onResume() {
        super.onResume();
        String action = getIntent().getAction();

        textViewID.append(action);
//        processNDEFIntent(getIntent());
        // Check to see that the Activity started due to an Android Beam
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            processNDEFIntent(getIntent());
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        // onResume gets called after this to handle the intent
        setIntent(intent);
    }

    /**
     * Parses the NDEF Message from the intent and prints to the TextView
     */
    void processNDEFIntent(Intent intent) {
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msgID = (NdefMessage) rawMsgs[0];
        textViewID.append("\nempty message");
        if (null != msgID){
            textViewID.append("\nnot null");
            textViewID.append(new String(msgID.getRecords()[0].getPayload()));
            textViewID.append("\n");
            deviceID.setText(new String(msgID.getRecords()[0].getPayload()));
        }

    }
}
