package com.example.isacclee.firsthello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderDetailActivity extends AppCompatActivity {

    public TextView Price;
    public TextView OrderInfo;
    public TextView ExpressState;
    public TextView ExpressId;
    public TextView GoodName;
    Controller controller = new Controller();
    GoodsStructure goodsStructure = new GoodsStructure();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initData();
    }

    private void initData(){
        Intent intent = getIntent();
        intent.getExtras();
        Bundle data =intent.getExtras();
        int position =data.getInt("data_position");
        Log.i("receive",String.valueOf(position));
        OrderStructure orderStructure = MainActivity.datas.get(position);
        Price = (TextView) findViewById(R.id.textView16);
        OrderInfo = (TextView) findViewById(R.id.OrderInfo);
        ExpressState = (TextView) findViewById(R.id.express_state);
        ExpressId= (TextView) findViewById(R.id.expressid);
        GoodName = (TextView) findViewById(R.id.textView15);

        goodsStructure = controller.GoodsInfo(this,orderStructure.goodsID);

        controller.OrderInfo(orderStructure);
        GoodName.setText(goodsStructure.getGoodsName());
        OrderInfo.setText("订单编号："+orderStructure.orderID+"\n创建时间："+orderStructure.creatingTime+"\n发货时间："+orderStructure.sendingTime+"\n收货人  ："+orderStructure.receiver+"\n收货地址："+orderStructure.address);
        Price.setText("单价："+goodsStructure.getPrice().toString()+"\n数量："+String.valueOf(orderStructure.number)+"\n总价："+String.valueOf(orderStructure.number*goodsStructure.getPrice()));
        ExpressId.setText(orderStructure.supplier+"\n单号:"+orderStructure.expressID+"\n");
        String wholeState = "";
        for(int i = 0; i< orderStructure.numOfStates;i++){
         //   wholeState += orderStructure.statesList[i].time + " " + orderStructure.statesList[i].state+"\n";
            wholeState += orderStructure.statesListTime[i] + " " + orderStructure.statesListState[i]+"\n\n";
        }
        ExpressState.setText(wholeState);
//        ExpressState.setText("2015-67-3 .234.324.23 到达北京");

    }
}
