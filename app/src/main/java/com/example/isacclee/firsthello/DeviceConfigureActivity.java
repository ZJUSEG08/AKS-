package com.example.isacclee.firsthello;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.nfc.NdefRecord.createMime;

public class DeviceConfigureActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback{

    private NfcAdapter mNfcAdapter;
    TextView GoodsName;
    TextView deviceID;
    String GoodsID;
    TextView price;
    Controller controller = new Controller();
    GoodsStructure goodsStructure = new GoodsStructure();
    EditText count;
    DeviceStructure deviceStructure = new DeviceStructure();
    EditText limit;
    EditText name;
    EditText address;
    EditText postal;
    EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_configure);

        GoodsName =(TextView) findViewById(R.id.textView4);
        price = (TextView)findViewById(R.id.textView5);

        deviceID = (TextView)findViewById(R.id.textView);

        count = (EditText)findViewById(R.id.editText8);


//        Intent intent = getIntent();
//        if(intent != null){
//
//        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeviceConfigureActivity.this,ShopActivity.class);
                startActivity(intent);
            }
        });
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
            Toast.makeText(this,"NFC not found",Toast.LENGTH_LONG).show();
        }else
        // Register callback
        mNfcAdapter.setNdefPushMessageCallback(this, this);
    }

    public void Cancel(){
        Controller controller = new Controller();
        controller.ResetDevice(this.deviceID.getText().toString());
        Toast.makeText(this,"已取消绑定",Toast.LENGTH_SHORT).show();
        try{
            Thread.currentThread().sleep(1000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClass(DeviceConfigureActivity.this,SearchActivity.class);
        startActivity(intent);
    }
    public void Disconnect(){
        Intent intent = new Intent();
        intent.setClass(DeviceConfigureActivity.this,SearchActivity.class);
        Toast.makeText(this,"已断开连接",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void Edit(){
        EditText limit = (EditText)findViewById(R.id.editText6);
        EditText name = (EditText)findViewById(R.id.editText9);
        EditText address = (EditText)findViewById(R.id.editText10);
        EditText postal = (EditText)findViewById(R.id.editText11);
        EditText tel = (EditText)findViewById(R.id.editText12);

        deviceStructure.phone = tel.getText().toString();
        deviceStructure.aksID = deviceID.getText().toString();
        deviceStructure.number = Integer.parseInt(count.getText().toString());
        deviceStructure.orderLimit = Integer.parseInt(limit.getText().toString());
        deviceStructure.goodsID = this.GoodsID;
        deviceStructure.receiverName = name.getText().toString();
        deviceStructure.address = address.getText().toString();
        deviceStructure.postCode = postal.getText().toString();

        controller.UpdateDevice(deviceStructure);
        Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();

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

//        processNDEFIntent(getIntent());
        // Check to see that the Activity started due to an Android Beam
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            processNDEFIntent(getIntent());
        }else{
//            String result = FileCacheUtil.getCache(getApplicationContext(),FileCacheUtil.currentGoodsID);
//            goodsStructure = controller.GoodsInfo(getApplicationContext(),deviceID.getText().toString());
            String id = getIntent().getStringExtra("goodsId");
            TextView Goodsname = (TextView) findViewById(R.id.textView4);
            TextView Price = (TextView) findViewById(R.id.textView5);
            goodsStructure = controller.GoodsInfo(this,id);
            Goodsname.setText(goodsStructure.getGoodsName());
            Price.setText(goodsStructure.getPrice().toString()+"元");
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
        if (null != msgID){
            deviceID.setText(new String(msgID.getRecords()[0].getPayload()));
            GoodsStructure goodsStructure;

            DeviceStructure deviceStructure = new DeviceStructure();
            deviceStructure.aksID = deviceID.getText().toString();

            String email = FileCacheUtil.getCache(getApplicationContext(),FileCacheUtil.userInfo);
            int result = controller.CheckDevice(email,deviceStructure.aksID);
            if(result == -1){
                Toast.makeText(this,"该设备已和该账号绑定",Toast.LENGTH_LONG);
            }else if (result == 0){
                Toast.makeText(this,"该设备已被其他账号绑定",Toast.LENGTH_LONG);
                Intent intent2 =  new Intent(DeviceConfigureActivity.this,SearchActivity.class);
                startActivity(intent2);
            }

            controller.GetDevice(deviceStructure);
            GoodsID = deviceStructure.goodsID;

            if(GoodsID == null) GoodsID="00000";
            goodsStructure = controller.GoodsInfo(getApplicationContext(),GoodsID);
//            goodsStructure = controller.GoodsInfo(getApplicationContext(),"00004");
            GoodsName.setText(goodsStructure.getGoodsName());

            price.setText(Double.toString(goodsStructure.getPrice()));
        }


    }
}
