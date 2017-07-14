package com.example.isacclee.firsthello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeviceConfigureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_configure);

        TextView name =(TextView) findViewById(R.id.textView4);
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
    }
}
