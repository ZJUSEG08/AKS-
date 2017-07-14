package com.example.isacclee.firsthello;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.nfc.NdefRecord.createMime;

public class DeviceConfigureActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback{

    private NfcAdapter mNfcAdapter;
    TextView textViewID;
    TextView GoodsName;
    TextView deviceID;
    String GoodsID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_configure);

        GoodsName =(TextView) findViewById(R.id.textView4);
        TextView price = (TextView)findViewById(R.id.textView5);

        TextView DeviceID = (TextView)findViewById(R.id.textView);

        Controller controller = new Controller();
        GoodsStructure goodsStructure = new GoodsStructure();
        goodsStructure = controller.GoodsInfo(getApplicationContext(),deviceID.getText().toString());
        GoodsName.setText(goodsStructure.getGoodsName());
        price.setText(goodsStructure.getPrice().toString());



        DeviceStructure deviceStructure = new DeviceStructure();
        deviceStructure.aksID = deviceID.getText().toString();
        controller.GetDevice(deviceStructure);
        GoodsID = deviceStructure.goodsID;
        Button EditButton = (Button) findViewById(R.id.button6);
        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit();
            }
        });
        Button DisconnectButton = (Button) findViewById(R.id.button8);
        DisconnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disconnect();
            }
        });
        Button CancelButton = (Button) findViewById(R.id.button7);
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cancel();
            }
        });
        // Check for available NFC Adapter
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) {
            textViewID.setText("NFC Not Found.");
        }
        // Register callback
        mNfcAdapter.setNdefPushMessageCallback(this, this);
    }

    public void Cancel(){
        Controller controller = new Controller();
        controller.ResetDevice(this.deviceID.getText().toString());
    }
    public void Disconnect(){
        Intent intent = new Intent();
        intent.setClass(DeviceConfigureActivity.this,SearchActivity.class);
        startActivity(intent);
    }
    public void Edit(){
        Controller controller = new Controller();
        EditText count = (EditText)findViewById(R.id.editText8);
        EditText limit = (EditText)findViewById(R.id.editText6);
        EditText name = (EditText)findViewById(R.id.editText9);
        EditText address = (EditText)findViewById(R.id.editText10);
        EditText postal = (EditText)findViewById(R.id.editText11);
        EditText tel = (EditText)findViewById(R.id.editText12);
        DeviceStructure deviceStructure = new DeviceStructure();

        deviceStructure.phone = tel.getText().toString();
        deviceStructure.aksID = deviceID.getText().toString();
        deviceStructure.number = Integer.parseInt(count.getText().toString());
        deviceStructure.orderLimit = Integer.parseInt(limit.getText().toString());
        deviceStructure.goodsID = this.GoodsID;
        deviceStructure.receiverName = name.getText().toString();
        deviceStructure.address = address.getText().toString();
        deviceStructure.postCode = postal.getText().toString();
        controller.UpdateDevice(deviceStructure);
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
